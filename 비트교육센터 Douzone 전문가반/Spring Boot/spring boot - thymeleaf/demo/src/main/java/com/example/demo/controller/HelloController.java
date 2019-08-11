package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import com.example.demo.modle2.Hoge;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view =new ModelAndView();
        view.setViewName("hello1");
        view.addObject("name", "안녕1");     
        return  view;
    }

    @RequestMapping(value = "/hello2", method=RequestMethod.GET)
    public String hello2(Model model) {
        Hoge hoge = new Hoge(); 
        hoge.id = 10; 
        hoge.value = "hoge"; 
        model.addAttribute("myData", hoge); 
        return "hello2";
    }

    @RequestMapping(value = "/hello3", method=RequestMethod.GET)
    public String hello3(Model model) {
        List<Hoge> list = Arrays.asList( 
                                            new Hoge() {{ 
                                                id = 10; 
                                                value = "hoge"; 
                                            }}, 
                                            new Hoge() {{ 
                                                id = 20; 
                                                value = "fuga"; 
                                            }}, 
                                            new Hoge() {{ 
                                                id = 30; 
                                                value = "piyo"; 
                                            }}
                                        ); 
        model.addAttribute("hogeList", list); 
        return "hello3";

    }
}