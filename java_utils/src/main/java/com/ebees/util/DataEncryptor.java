package com.ebees.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class DataEncryptor {

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static void main(String args[]) {
		String randomCode = RandomCodeGenerator.randomString();
		System.out.println("RANDOM CODE - "+randomCode);
		System.out.println("ENCRYPTED CODE - "+getSaltyHash(randomCode));
	}

	public static String getSaltyHash(String password) {

		try {
			// Generate salt and hash password
			byte[] salt = generateSalt();
			byte[] encryptedPassword = getEncryptedPassword(password, salt);

			// logger.debug("password: " + password + "salt: " +
			// StringUtils.hexEncode(salt) + " : storedPassword: " +
			// StringUtils.hexEncode(encryptedPassword));
			// Concat salt and hash together so that we can retrieve salt later
			// on
			return bytesToHex(salt) + ":" + bytesToHex(encryptedPassword);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] generateSalt() throws NoSuchAlgorithmException {
		// VERY important to use SecureRandom instead of just Random
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

		// Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
		byte[] salt = new byte[8];
		random.nextBytes(salt);

		return salt;
	}

	public static byte[] getEncryptedPassword(String password, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
		// specifically names SHA-1 as an acceptable hashing algorithm for
		// PBKDF2
		String algorithm = "PBKDF2WithHmacSHA1";
		// SHA-1 generates 160 bit hashes, so that's what makes sense here
		int derivedKeyLength = 160;
		// Pick an iteration count that works for you. The NIST recommends at
		// least 1,000 iterations:
		// http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
		// iOS 4.x reportedly uses 10,000:
		// http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
		int iterations = 20000;

		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

		SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

		return f.generateSecret(spec).getEncoded();
	}

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
