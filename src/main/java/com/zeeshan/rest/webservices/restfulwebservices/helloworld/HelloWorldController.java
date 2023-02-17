package com.zeeshan.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	// Return hello world back on going to url /hello-world
	// We can use value="/hello-world" instead of path
	@RequestMapping(path="/hello-world", method=RequestMethod.GET)
	public String helloWorld() {
		return "hello World!";
	}

}
