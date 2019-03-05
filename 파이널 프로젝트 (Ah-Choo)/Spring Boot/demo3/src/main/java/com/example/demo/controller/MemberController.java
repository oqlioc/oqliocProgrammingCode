package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.MemberDTO;
import com.example.demo.service.MemberService;

@RestController
@RequestMapping("/")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// for Android

	// 로그인
	@RequestMapping(value = "/login", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<MemberDTO> login(HttpServletRequest request) {

		return memberService.login(request);

	}

	// 회원가입-아이디 중복검사
	@RequestMapping("/duplicationCheckId")
	public int duplicationCheckId(HttpServletRequest request) {

		return memberService.duplicationCheckId(request);
	}

	// 회원가입-닉네임 중복검사
	@RequestMapping("/duplicationCheckNick")
	public int duplicationCheckNick(HttpServletRequest request) {

		return memberService.duplicationCheckNick(request);
	}

	// 최종회원가입
	@RequestMapping(value = "/join", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int join(@RequestBody MemberDTO member) {

		return memberService.join(member);

	}

	// 회원 기본 정보 수정
	@RequestMapping(value = "/modify", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int modify(@RequestBody MemberDTO member) {

		return memberService.modify(member);

	}

	// 카메라 피부 결과값 넣기
	@RequestMapping(value = "/memberDetailT", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int memberDetailT(@RequestBody MemberDTO member) {
		return memberService.memberDetailT(member);

	}

	// 자가진단 결과 넣기
	@RequestMapping(value = "/setSelfTestResult", produces = "application/json; charset=UTF-8")
	public int setSelfTestResult(HttpServletRequest request) {

		return memberService.setSelfTestResult(request);
	}

	// 사용자 톤 알기
//	@RequestMapping(value = "/getSelfTestResult", produces = "application/json; charset=UTF-8")
//	public String getSelfTestResult(HttpServletRequest request) {
//		System.out.println(memberService.getSelfTestResult(request));
//		
//		return "{\"selfT\":\""+memberService.getSelfTestResult(request)+"\"}";
//		
//	}
	
	@RequestMapping(value="/getSelfTestResult")
	public Map<String,String> getSelfTestResult(HttpServletRequest request){
		
		
		return memberService.getSelfTestResult(request);
		
	}
	

	@RequestMapping(value = "/info_detailtest", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int info_detailtest(@RequestBody MemberDTO member) {
		int RGB = memberService.info_detailtest(member);
		System.out.println(RGB + "     111111111111111111111111");
		return RGB;
	}

	// 자가진단 결과 보기

	// 자가진단 수정

	// 상세진단 결과 저장

	// 상세진단 결과 보기
	// 상세진단 수정

	// for Web
//   @RequestMapping("/user")
//   public List<Member> findByUsername() {
//
//      return memberRepository.findAll();
//
//   }

}
