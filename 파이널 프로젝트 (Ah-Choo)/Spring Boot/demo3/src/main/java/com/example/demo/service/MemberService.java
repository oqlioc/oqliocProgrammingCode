package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.MemberDTO;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	// 로그인
	public ResponseEntity<MemberDTO> login(HttpServletRequest request) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if (memberRepository.findById(id).isPresent()) {// 아이디 존재

			if (memberRepository.findByIdAndPw(id, pw) != null) {

				System.out.println("****** Login Success ******");

				MemberDTO member = memberRepository.findByIdAndPw(id, pw);

				String firstLogin = memberRepository.findFirstOrNot(id); // 최초 로그인한 아이디

				if (firstLogin != null) // 최초 로그인 시
				{

					return new ResponseEntity<MemberDTO>(member, HttpStatus.ACCEPTED); // 최초 로그인 성공,상태코드 201

				} else {

					return new ResponseEntity<MemberDTO>(member, HttpStatus.OK); // 로그인 성공,상태코드 200
				}

			} else {

				return new ResponseEntity<>(HttpStatus.FORBIDDEN); // 비밀번호가 일치하지 않음, 상태코드 403
			}
		} else {

			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // 아이디가 존재하지 않음,401
		}

	}

	// 아이디 중복검사
	public int duplicationCheckId(HttpServletRequest request) {

		String id = request.getParameter("id");
		if (memberRepository.findById(id).isPresent()) { // Optional 클래스가 감싸고 있음

			return 1; // 입력한 아이디가 이미 존재함
		} else {
			return 2; // 아이디 사용 가능

		}

	}

	// 닉네임 중복검사
	public int duplicationCheckNick(HttpServletRequest request) {

		String nick = request.getParameter("nick");
		if (memberRepository.findByNick(nick) != null) {
			return 1; // 입력한 닉네임이 이미 존재함

		} else {
			return 2; // 닉네임 사용 가능

		}
	}

	// 회원등록
	public int join(@RequestBody MemberDTO member) {

		if (memberRepository.findById(member.getId()).isPresent()) { // Optional 클래스가 감싸고 있음

			return 2; // 입력한 아이디가 이미 존재함
		} else {
			if (memberRepository.findByNick(member.getNick()) != null) {
				return 3; // 입력한 닉네임이 이미 존재함

			} else

				memberRepository.saveAndFlush(member);
			System.out.println("****** Join Success ******");
			return 1; // 회원가입 최종 성공

		}

	}

	// 회원 정보 수정
	public int modify(@RequestBody MemberDTO member) {

		if (memberRepository.findById(member.getId()).isPresent()) {

			return 2; // 입력한 아이디가 이미 존재함
		} else {
			if (memberRepository.findByNick(member.getNick()) != null) {
				return 3; // 입력한 닉네임이 이미 존재함

			} else

				memberRepository.saveAndFlush(member);
			System.out.println("****** modify Success ******");
			return 1; // 수정 성공

		}

	}

	// 카메라 피부 결과값 넣기
	// ===================================================추가
	public int memberDetailT(@RequestBody MemberDTO member) {

		memberRepository.memberDetailT(member.getId(), String.valueOf(member.getDetailT()));

		return 1;
	}

	// 자가진단 결과값 넣기
	public int setSelfTestResult(HttpServletRequest request) {
		String nick = request.getParameter("nick");
		String selfT = request.getParameter("selfT");

		System.out.println(nick + "  " + selfT);
		memberRepository.updateSelfT(selfT, nick);

		return 1;

	}

	// 카메라 피부 결과값 들고오기
	// ===================================================
	public int info_detailtest(@RequestBody MemberDTO member) {

		int info_detailtest = Integer.parseInt(memberRepository.info_detailtest(member.getId())); // 사용자의 톤

		return info_detailtest;
	}

}
