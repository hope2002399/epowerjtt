package com.centit.powerruntime.util;

import java.rmi.RemoteException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang.StringUtils;

import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.webservice.po.Arg;
import com.centit.webservice.po.Result;
import com.centit.webservice.service.Impl.CityTogovServicePortTypeProxy;

public class EmsWebserviceUtil {
    private static CityTogovServicePortTypeProxy proxy = new CityTogovServicePortTypeProxy();
    private static String key = CodeRepositoryUtil.getValue("EMSPARAM", "KEY");

    // 第一个接口
    public static String cityToGovMail(String message) {
        try {
            if (StringUtils.isBlank(key) || "KEY".equals(key)) {
                key = "GOV17EMS";
            }
            Result result = proxy.cityToGovMail(new Arg(encrypt(message, key)));
            return result.getResult();
        } catch (RemoteException e) {
            System.out.println(" error1 is :" + e.getMessage());
        } catch (Exception e) {
            System.out.println(" error2 is :" + e.getMessage());
        }
        return "";
    }

    // 第二个接口
    public static String cityGetGovLogis(String message) {
        try {
            if (StringUtils.isBlank(key) || "KEY".equals(key)) {
                key = "GOV17EMS";
            }
            Result result = proxy
                    .cityGetGovLogis(new Arg(encrypt(message, key)));
            return result.getResult();
        } catch (RemoteException e) {
            System.out.println(" error1 is :" + e.getMessage());
        } catch (Exception e) {
            System.out.println(" error2 is :" + e.getMessage());
        }
        return "";
    }

    /**
     * 解密数据
     * 
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String message, String key) throws Exception {
        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        String rtn = new String(retByte, "UTF-8");
        return rtn;
    }

    /**
     * 加密数据
     * 
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] tempByte = cipher.doFinal(message.getBytes("UTF-8"));
        return toHexString(tempByte);

    }

    public static byte[] convertHexString(String ss) {
        byte digest[] = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }

    public static String toHexString(byte b[]) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2)
                plainText = "0" + plainText;
            hexString.append(plainText);
        }
        return hexString.toString();
    }

}
