/**   
* @Title: EncryptionProvider.java 
* @Package org.brilliance.security 
* @Description: TODO
* @author Pie.Li   
* @date 2013-12-15 下午5:01:41 
* @version V1.0   
*/
package org.brilliance.security;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author Pie.Li
 *
 */
public class EncryptionProvider {

	
	/**
	 *AES Default Value
	 */
	private static final String _AES_KEY_DEFAULT = "AES_2000_Key_!@#";
	
	
	/**
	 *AES IV
	 */
	private static final String _AES_IV = "1234567890888888";
	
	/**
	 * AES加密
	 * @param rawKey
	 * @param input
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 */
	public static String encryptByAES(byte[] rawKey, String input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException  {
		
		SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec(_AES_IV.getBytes());
		
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);  
        byte[] encrypted = cipher.doFinal(input.getBytes());  
		
        return Base64.encodeBase64String(encrypted);
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	public static String encryptByAES(String input) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		return encryptByAES(_AES_KEY_DEFAULT.getBytes(), input);
	}
	
	/**
	 * 
	 * @param rawKey
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static String descryptByAES(byte[] rawKey, String input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		
		SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");  
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
		IvParameterSpec iv = new IvParameterSpec(_AES_IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);  
        byte[] encrypted = cipher.doFinal(Base64.decodeBase64(input));  
        return new String(encrypted);
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	public static String descryptByAES(String input) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		return descryptByAES(_AES_KEY_DEFAULT.getBytes(), input);
	}
}
