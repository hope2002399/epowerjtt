package com.centit.app.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * Digest d = new Digest(Digest.ALGORITHM_MD5); String ret =
 * d.getDigest("fjadsfjalfd"); System.out.println(ret); String mg = "你好吗";
 * System.out.println(mg.getBytes());
 * System.out.println(String.valueOf(mg.getBytes())); byte[] retd =
 * mg.getBytes(); int nLength = retd.length; String retString = ""; for( int i =
 * 0; i < nLength; i++ ) { Byte b = new Byte(retd[i]); retString +=
 * b.toString(); } System.out.println(retString);
 * System.out.println(CipherTool.byteToString(retd));
 * </p>
 * 对给定的字符串生成一个唯一的摘要信息
 * 
 * @author jiangf
 * @version 1.0.0.0
 */
public class Digest
{
  private String algorithm = "";

  public final static String ALGORITHM_MD5 = "MD5";

  public final static String ALGORITHM_SHA = "SHA";

  /**
   * 以指定的算法名称构建摘要类；具体的算法名称见 {@link ALGORITHM_MD5 }{@link  ALGORITHM_SHA}
   * 
   * @param algorithm
   */
  public Digest(String algorithm)
  {
    this.algorithm = algorithm;
  }

  /**
   * 得到指定字符串的摘要信息
   * 
   * @param source
   *          指定的字符串
   * @return 摘要信息
   */
  public byte[] getDigest(String source) throws CipherException
  {
    MessageDigest digest = null;
    try
    {
      digest = MessageDigest.getInstance(this.algorithm);
    }
    catch(NoSuchAlgorithmException nsE)
    {
      throw new CipherException(nsE);
    }
    
    digest.update(source.getBytes());
    
    return digest.digest();
  }

  /**
   * 
   * @param source
   * @return
   * @throws CipherException
   */
  public static String md5(String source) throws CipherException
  {
    Digest dg = new Digest(Digest.ALGORITHM_MD5);
    
    return CipherTool.byteToString(dg.getDigest(source), false);
  }

  /**
   * 判断两个摘要信息是否一致
   * 
   * @param digest1
   *          摘要信息1
   * @param digest2
   *          摘要信息2
   * @return 如果一致，则返回true； 否则，返回false
   */
  public static boolean isEqual(byte[] digest1, byte[] digest2)
      throws CipherException
  {
    return MessageDigest.isEqual(digest1, digest2);
  }
}