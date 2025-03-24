package com.va.Service_Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	 @Autowired
	    private RestTemplate restTemplate;

	    @GetMapping("/clientdetails")
	    public String consume(@RequestParam(defaultValue = "User") String name) {
	    	return restTemplate.getForObject("http://service-provider/backend?name=" + name, String.class);

	    }
}
