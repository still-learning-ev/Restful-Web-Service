package com.zeeshan.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	// Return hello world back on going to url /hello-world
	// Get mapping instead of RequestMapping()
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "hello World!";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HelloWorld");
	}
	
	// The method varibale will be able to capture the url with name
	// /hello-world/path-variable/zeeshan
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello there, %s", name));
	}

}
