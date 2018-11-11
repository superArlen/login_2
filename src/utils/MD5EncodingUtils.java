package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;
/*
 * 使用Java MD5方式加密工具类
 */
public class MD5EncodingUtils {
	public static String EncodeByMD5(String str)
			throws NoSuchAlgorithmException,UnsupportedEncodingException{
		//确定计算方法
		MessageDigest md=MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		//使用指定的MD算法进行加密
		String newStr = base64en.encode(md.digest(str.getBytes("UTF-8")));
		//MD5的加密结果是一个24位长度的 以"= ="结尾的字符串
		return newStr;
	}
}





