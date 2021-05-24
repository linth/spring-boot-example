package com.nr.first_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
}


@RestController
class FirstRestApi {
	@GetMapping("/hello")
	public String hello() {
		return "Hello world.";
	}

	@GetMapping("/")
	public String helloworld() {
		return "Hello world, everyone.";
	}

	@GetMapping("/test")
	public String test() {
		return "This is a test.";
	}
}

@RestController
class SecondRestApi {
	@GetMapping("/second1")
	public String second1() {
		return "second1.";
	}

	@GetMapping("/second2")
	public String second2() {
		return "second2.";
	}

	@GetMapping("/second3")
	public String second3() {
		return "second3.";
	}
}