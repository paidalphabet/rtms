package com.rtms.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;


public class CommonUtils {
	
	final static String defaultPassword = "temp1234";
	
	public static String getUUID() {
        final UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
	
	public static String generateMD5(final String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if(null != md){
			if(null != password){
				md.update(password.getBytes());
			}else{
				md.update(defaultPassword.getBytes());
			}
			
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		}else{
			return "";
		}
	}
}
