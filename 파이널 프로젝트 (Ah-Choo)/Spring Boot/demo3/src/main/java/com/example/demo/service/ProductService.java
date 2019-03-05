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
//*************************************************************************************
	public Map<String, List<ProductDTO>> CoolproductList() {

		result = new HashMap<>();
		result.put("ProductDTO", productRepository.findCoolList());

		return result;
	}
	
	public Map<String, List<ProductDTO>> WarmproductList() {

		result = new HashMap<>();
		result.put("ProductDTO", productRepository.findWarmList());

		return result;
	}
	
	public Map<String, List<ProductDTO>> CountproductList() {

		result = new HashMap<>();
		result.put("ProductDTO", productRepository.findCountList());

		return result;
	}
//*************************************************************************************
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

		System.out.println(id + " " + pcode + " " + selfT);
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

	public Map<String, List<ProductDTO>> preferPriceProduct(HttpServletRequest request) {

		String nick = request.getParameter("id");
		int price = memberRepository.findPriceById(nick);
		System.out.println(" 가격대~~~~~" + price);

		result = new HashMap<>();
		
		switch (price) {
		case 1:
			result.put("ProductDTO",productRepository.findByPrice("0원", "10,000원"));
			return result;
		case 2:
			result.put("ProductDTO",productRepository.findByPrice("10,000원", "20,000원"));
			return result;
		case 3:
			result.put("ProductDTO",productRepository.findByPrice("20,000원", "30,000원"));
			return result;
		case 4:
			result.put("ProductDTO",productRepository.findByPrice("30,000원", "40,000원"));
			return result;
		case 5:
			result.put("ProductDTO",productRepository.findByPrice("40,000원", "50,000원"));
			return result;
		case 6:
			result.put("ProductDTO",productRepository.findByPrice("50,000원", "10,0000원"));
			return result;
		default:
			result.put("ProductDTO",productRepository.findByPrice("0원", "100,000원"));
			return result;

		}

	}

}
