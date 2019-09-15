package com.test.mvctest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.mvctest.model.UserModel;
import com.test.mvctest.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/")
	public String home(HttpSession session) {
		session.invalidate();
		return "home";
	}

	@RequestMapping(value = "/signin")
	public String signin(UserModel userModel, HttpServletRequest request) {
		if (loginService.login(userModel)) {
			System.out.println(" 로그인 성공 입니다. ");

			HttpSession session = request.getSession();
			session.setAttribute("userId", userModel.getId());

			return "signin_main";
		} else {
			System.out.println(" 아이디와 비밀번호를 다시 확인 하세요. ");
			return "redirect:/";
		}
	}

	@RequestMapping("logout")
	public String logout() {
		return "home";
	}

}
