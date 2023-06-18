package com.pinaki.springboot.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

	@RequestMapping("hello")
	public String sayHello() {

		return "Hello!Whatsup";
	}

	@RequestMapping("hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer sb = new StringBuffer();
				
				sb.append("<html>");
						sb.append("<head>");
								sb.append("<title>My First HTML Page</title>");
										sb.append("</head>");
												sb.append("<body>");
						sb.append("Hi Pinaki Its HTML Page");
			sb.append("</body>");
				
		
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}

}
