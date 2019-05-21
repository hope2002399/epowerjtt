package com.centit.app.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 加密、解密相关工具类
 * 
 * @author jiangf
 * @version 1.0.0.1
 */
public class CipherTool {
	/**
	 * 字节数组转化为字符串
	 * 
	 * @param b
	 *            待转化字节数组
	 * @return 转化后的字符串，如果为null,则转化错误
	 */
	public static String byteToString(byte[] b, boolean bUpper)
			throws CipherException {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
			/*
			 * if (n < b.length - 1) { hs = hs + ":"; }
			 */
		}
		if (bUpper) {
			return hs.toUpperCase();
		} else {
			return hs.toLowerCase();
		}
	}

	/**
	 * 将对象序列化到指定文件
	 * 
	 * @param obj
	 *            待序列化的对象
	 * @param fileName
	 *            指定文件，如果文件不存在，则创建;；如果文件不为空，则覆盖
	 * @return true：成功； false： 失败
	 */
	public static boolean saveKeyToFile(Object obj, String fileName)
			throws CipherException {
		try {
			File fTemp = new File(fileName);
			if (!fTemp.exists()) {
				fTemp.createNewFile();
			}
			FileOutputStream foS = new FileOutputStream(fileName);
			ObjectOutputStream ooS = new ObjectOutputStream(foS);
			ooS.reset();
			ooS.writeObject(obj);
			ooS.close();
			return true;
		} catch (Exception e) {
			throw new CipherException(e);
		}
	}

	/**
	 * 从指定文件反序列化到对象
	 * 
	 * @param fileName
	 *            指定的文件名称
	 * @return 如果为null， 则反序列化失败
	 */
	public static Object loadKeyFromFile(String fileName)
			throws CipherException {
		try {
			FileInputStream fiS = new FileInputStream(fileName);
			ObjectInputStream oiS = new ObjectInputStream(fiS);
			Object obj = oiS.readObject();
			oiS.close();
			return obj;
		} catch (Exception e) {
			throw new CipherException(e);
		}
	}

	/**
	 * 解码编码后的公钥
	 * 
	 * @param encodedPubKey
	 * @return PublicKey
	 * @throws CipherException
	 */
	public static PublicKey decodePublicKey(byte[] encodedPubKey)
			throws CipherException {
		X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(encodedPubKey);
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("DSA");
			return keyFactory.generatePublic(bobPubKeySpec);
		} catch (Exception e) {
			throw new CipherException(e);
		}
	}

	/**
	 * 解码编码后的私钥
	 * 
	 * @param encodePriKey
	 * @return PrivateKey
	 * @throws CipherException
	 */
	public static PrivateKey decodePrivateKey(byte[] encodePriKey)
			throws CipherException {
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(encodePriKey);
		KeyFactory keyf;
		try {
			keyf = KeyFactory.getInstance("DSA");
			return keyf.generatePrivate(priPKCS8);
		} catch (Exception e) {
			throw new CipherException(e);
		}

	}
}
