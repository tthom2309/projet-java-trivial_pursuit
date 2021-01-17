package utility;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * This class allows to crypt/decrypt a text.
 * @author Christophe Decroos
 *
 */
public class Encrypt {
	
	/**
	 * This method allows to crypt a String text using a String key.
	 * @author Christophe Decroos
	 * @param key
	 * @param textToCrypt
	 * @return String
	 */
	public static String encryptionString(String key,String textToCrypt)
	{
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(key);             
        textToCrypt = textEncryptor.encrypt(textToCrypt);
        return textToCrypt;
	}
	
	/**
	 * This method allows to decrypt a String text using the String key used to crypted the text.
	 * @author Christophe Decroos
	 * @param key
	 * @param textToDecrypt
	 * @return
	 */
	public static String decryptionString(String key,String textToDecrypt)
	{
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(key);
		textToDecrypt = textEncryptor.decrypt(textToDecrypt);
		return textToDecrypt;
	}
	
	
}
	
	
