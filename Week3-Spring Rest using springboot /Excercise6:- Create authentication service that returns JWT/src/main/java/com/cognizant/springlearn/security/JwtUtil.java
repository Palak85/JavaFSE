package com.cognizant.springlearn.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class JwtUtil {
	private static final String SECRET = "super-secret-key-that-is-long-enough-for-hs256";

	public static String generateToken(String username) {
		try {
			// 1. Header
			String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
			String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(header.getBytes(StandardCharsets.UTF_8));

			// 2. Payload
			long now = System.currentTimeMillis() / 1000;
			long exp = now + 1200; // 20 minutes
			String payload = String.format("{\"sub\":\"%s\",\"iat\":%d,\"exp\":%d}", username, now, exp);
			String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes(StandardCharsets.UTF_8));

			// 3. Signature
			String signInput = encodedHeader + "." + encodedPayload;
			Mac sha256HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKey = new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
			sha256HMAC.init(secretKey);
			byte[] signatureBytes = sha256HMAC.doFinal(signInput.getBytes(StandardCharsets.UTF_8));
			String encodedSignature = Base64.getUrlEncoder().withoutPadding().encodeToString(signatureBytes);

			return signInput + "." + encodedSignature;
		} catch (Exception e) {
			throw new RuntimeException("Error generating JWT", e);
		}
	}
}
