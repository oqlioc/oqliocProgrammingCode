package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ProductDTO;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	MemberRepository memberRepository;

	private Map<String, List<ProductDTO>> result;

	public Map<String, List<ProductDTO>> productList() {

		result = new HashMap<>();
		result.put("ProductDTO", productRepository.findAllList());

		return result;
	}

	public Map<String, List<ProductDTO>> userToneProductList(HttpServletRequest request) {

		String selfT = request.getParameter("selfT");
		result = new HashMap<>();
		System.out.println(selfT);
		result.put("ProductDTO", productRepository.findByTone(selfT));
		return result;
	}

	public int countHits(HttpServletRequest request) {

		
		String id = request.getParameter("id"); // 조회한 사용자의 아이디
		String selfT = memberRepository.findSelfTById(id); // 사용자의 톤
		String pcode = request.getParameter("pcode"); // 상품코드

		System.out.println(id + " "+pcode + " " +selfT);
		switch (selfT) {
		case "sw":
			productRepository.updateSwHits(pcode);
			return 1; 

		case "aw":
			productRepository.updateAwHits(pcode);
			return 1;

		case "sc":
			productRepository.updateScHits(pcode);
			return 1;

		case "wc":
			productRepository.updateWcHits(pcode);
			return 1;

		default:
			return 0; // 카운트 실패

		}
		
		
	}

}
