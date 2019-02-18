package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // @RestControll는 데이터반환
public class ViewController {

	   @RequestMapping("/hello")
	    public String index(Model model) {
		   model.addAttribute("name","SpringBlog from Milky");
	        return "hello2";
	    }
}
