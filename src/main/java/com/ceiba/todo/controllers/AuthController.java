package com.ceiba.todo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.todo.controllers.dto.AuthDTO;
import com.ceiba.todo.persistence.entity.User;
import com.ceiba.todo.security.jwt.JwtTokenProvider;
import com.ceiba.todo.services.security.SecurityService;
import com.ceiba.todo.services.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<String> signin(@RequestBody AuthDTO auth) {
		try {
			String username = auth.getUsername();
			if (securityService.authenticate(username, auth.getPassword())) {
				String token = jwtTokenProvider.createToken(username);
				User current = userService.findUserByUserName(auth.getUsername());
				Map<Object, Object> model = new HashMap<>();
				model.put("userId", current.getUserId());
				model.put("username", username);
				model.put("token", token);
				return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(model));
			} else {
				System.out.println("ss");
			}
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody AuthDTO auth) {
		try {
			User user = new User();
			user.setUsername(auth.getUsername());
			user.setPassword(auth.getPassword());

			Map<Object, Object> model = new HashMap<>();
			if (userService.findUserByUserName(auth.getUsername()) != null) {
				model.put("message", "Username Exists");
			} else {
				User newUser = userService.create(user);
				if (newUser != null) {
					if (securityService.authenticate(auth.getUsername(), auth.getPassword())) {
						String token = jwtTokenProvider.createToken(auth.getUsername());
						model.put("userId", newUser.getUserId());
						model.put("username", auth.getUsername());
						model.put("token", token);
					}
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(model));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}
}
