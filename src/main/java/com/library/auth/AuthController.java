package com.library.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.auth.entities.AuthRequest;
import com.library.auth.entities.AuthResponse;
import com.library.auth.entities.RegisterRequest;

@CrossOrigin
@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("/api/v1/auth/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/api/v1/auth/authenticate")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request){
		return ResponseEntity.ok(authService.authenticate(request));
	}
	
	@PostMapping("/api/v1/logout")
	public ResponseEntity<AuthResponse> logout(@RequestBody String token){
		return ResponseEntity.ok(authService.logout(token));
	}
	
	@GetMapping("/api/v1/demo-controller")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello from the demo controller");
	}
}
