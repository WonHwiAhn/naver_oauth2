/*package com.boot.blog.application.configuration.security.auth;

import java.security.MessageDigest;

public class Sha2PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder{
	
	private String charset = "UTF-8";
	public Sha2PasswordEncoder(){}
	public Sha2PasswordEncoder(String charset) {
		this.charset = charset;
	}
	
	
	@Override
	public String encode(CharSequence org) {
		StringBuffer hexString = new StringBuffer();
		try{
			 
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(org.toString().getBytes(charset));//"UTF-8"
 
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
 
            //출력
            System.out.println(hexString.toString());
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
        	hexString = null;
        }
	}
	
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(encode(rawPassword));
	}

}
*/