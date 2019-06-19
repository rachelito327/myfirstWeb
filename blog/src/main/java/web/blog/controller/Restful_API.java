package web.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restful_API {

	@RequestMapping("/api")
	public String index() {
		return "restful api";
	}
}
