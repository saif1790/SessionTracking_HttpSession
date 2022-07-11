package servlet;

import java.util.Base64;
import java.util.Base64.Decoder;

public class DecryptPassword {

	public static String getDecryptedPassword(String encryptPass) {
		
		System.out.println("encrypted password???????"+ encryptPass);
		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(encryptPass);

		String decryptedPassword = new String(bytes);

		System.out.println("Decrypted Value :: " + decryptedPassword);
		return decryptedPassword;
	}
}
