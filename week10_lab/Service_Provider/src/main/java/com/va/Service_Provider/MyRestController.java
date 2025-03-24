package com.va.Service_Provider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
 
@RestController
public class MyRestController {

	 @GetMapping("/backend")
	    public String greeting(@RequestParam(defaultValue = "User") String name) {
	        return "Hi Welcome, " + name + "! Greetings from Service Provider.";
	    }
}
