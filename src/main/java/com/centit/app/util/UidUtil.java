package com.centit.app.util;

import java.rmi.server.UID;
import java.util.Random;

import com.centit.app.security.CipherException;
import com.centit.app.security.CipherTool;
import com.centit.app.security.Digest;

/**
 * UID生成方法
 * TODO Class description should be added
 * 
 * @author jf
 * @create 2014-5-12
 * @version
 */
public class UidUtil {
    
    /**
     * 根据UID类生成一个基于HOST和时间的唯一字符串
     * 
     * @return
     */
    public static String getUID() {
        UID uid = new UID();
        String temp = uid.toString();
        Digest dg = new Digest(Digest.ALGORITHM_MD5);
        try {
            temp = CipherTool.byteToString(dg.getDigest(temp), false);
        } catch (CipherException cE) {
        }
        return temp;
    }
    
    public static String getRandomNum(){
        Random r = new Random();
        int pwd=r.nextInt(900000)+100000;
        return String.valueOf(pwd);
        }
}
