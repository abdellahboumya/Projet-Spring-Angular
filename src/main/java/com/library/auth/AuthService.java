package com.library.auth;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.auth.entities.AuthRequest;
import com.library.auth.entities.AuthResponse;
import com.library.auth.entities.RegisterRequest;
import com.library.entities.Role;
import com.library.entities.User;
import com.library.repositories.UserRepository;
import com.library.utils.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthResponse register(RegisterRequest request) {
		User user = new User(null, request.getFirstName(), request.getLastName(), request.getEmail(),
				passwordEncoder.encode(request.getPassword()), Role.ROLE_STUDENT, null);
		userRepository.save(user);
		String jwtToken = jwtUtils.generateToken(user);
		return new AuthResponse(jwtToken);
	}

	public AuthResponse authenticate(AuthRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		String jwtToken = jwtUtils.generateToken(user);
		return new AuthResponse(jwtToken);
	}

	public AuthResponse logout(String token) {
		String tokenStr = token.substring(7);
		return new AuthResponse(jwtUtils.invalidateToken(tokenStr));
	}

}
