package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView view =new ModelAndView();
        view.setViewName("hello");
        view.addObject("name", "Hello1");     
        return  view;
    }

   @RequestMapping(value="/hello2")
   public ModelAndView hello() {
       ModelAndView view =new ModelAndView();
       view.setViewName("hello2");
       view.addObject("name", "Hello2");       
       return view;
   }
   
   @RequestMapping("/hello3")
   public String hello2(Model model) {
        model.addAttribute("name", "Hello3");       
       return "hello";
   }
}