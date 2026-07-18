package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.security.JwtUtil;

@RestController
public class AuthController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Starting authentication...");

		// Decode basic auth credentials from the Authorization header
		String base64Credentials = authHeader.substring("Basic ".length()).trim();
		byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
		String credentials = new String(decodedBytes);
		String[] values = credentials.split(":", 2);
		String username = values[0];

		LOGGER.info("Decoded username: {}", username);
		String token = JwtUtil.generateToken(username);

		LOGGER.info("Ending authentication...");

		Map<String, String> response = new HashMap<>();
		response.put("token", token);
		return response;
	}
}
