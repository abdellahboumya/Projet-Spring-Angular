package com.library.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class DemoController {
	
	@GetMapping("/hi")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello from the demo controller");
	}
}
