/**   
* @Title: Tester.java 
* @Package org.brilliance.test 
* @Description: TODO
* @author Pie.Li   
* @date 2013-12-17 下午10:46:18 
* @version V1.0   
*/
package org.brilliance.test;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.brilliance.security.EncryptionProvider;
import org.junit.Test;

/**
 * @author Pie.Li
 *
 */
public class Tester {

	
	@Test
	public void fn() throws Exception {
		
		String result = EncryptionProvider.encryptByAES("1312312321");
		System.out.println(result);
		String urlEncoded = java.net.URLEncoder.encode(result, "UTF-8");
		System.out.println("http://xxxxx?verify=" + urlEncoded);
		
		System.out.println(EncryptionProvider.descryptByAES(java.net.URLDecoder.decode(urlEncoded, "UTF-8")));
	}
	
}
