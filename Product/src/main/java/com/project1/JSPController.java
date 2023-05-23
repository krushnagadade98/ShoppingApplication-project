package com.project1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}
	
	
	@RequestMapping("hi")
	public String hi() {
		return "hi";
	}
}
