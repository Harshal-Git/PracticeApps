/**
 * 
 */
package com.example.SpringBasic;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harshal-Git
 *
 */
@RestController
public class GreetingsController {

	// class level counter for number of greetings
	private final AtomicLong COUNTER = new AtomicLong();
	
	// message template
	private final String template = "Hello %s";
	
	@GetMapping("/greeting")
	public Greetings getGreetings(@RequestParam(value="name", defaultValue = "world...!") String name) {
		return new Greetings(COUNTER.incrementAndGet(), String.format(template, name));
	}
}
