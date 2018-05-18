/**   
 * @Title: EmailUtils.java 
 * @Package org.brilliance.web.verification 
 * @Description:     
 * @author Pie.Li   
 * @date 2013-12-15 下午4:51:43 
 * @version V1.0         
 */
 
package org.brilliance.web.verification;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 
 * 
 * @author Pie.Li
 * 
 */
public class EmailUtils {

	/**
	 * 创建验证串
	 * 
	 * @param primaryKey
	 * @param para
	 *            可以加时间戳作为salt
	 * @return
	 */
	public String createVerificationString(int primaryKey, Object... para) {

		return null;

	}
	
	/**
	 * 
	 * @param title
	 * @param content
	 * @throws EmailException
	 */
	public static void sendHtmlEmail(String title, String content) throws EmailException {

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.addTo("82700793@qq.com", "John Doe");
		email.setFrom("haperkelu@gmail.com", "Me");
		email.setSubject("Test email with html");
		
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("haperkelu", "haperkelu_2013"));
		email.setSSL(true);
		
		email.setHtmlMsg("<html>The apache logo - <span>gggg</span></html>");
		email.setTextMsg("Your email client does not support HTML messages");

		email.send();

	}

}
