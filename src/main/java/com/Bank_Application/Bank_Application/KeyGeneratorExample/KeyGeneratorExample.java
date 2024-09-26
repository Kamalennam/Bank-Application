package com.Bank_Application.Bank_Application.KeyGeneratorExample;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
public class KeyGeneratorExample {

	public static void main(String[] args) {
		 var key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	        System.out.println("Generated key: " + key.getEncoded());
	}

}
