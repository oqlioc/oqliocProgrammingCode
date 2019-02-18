package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ProductDTO;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	@Autowired
	ProductService productService;

	// 전체 상품 리스트
	@RequestMapping("/productList")
	@ResponseBody
	public Map<String, List<ProductDTO>> productList() {

		return productService.productList();
	}

	// 사용자 톤에 맞는 제품 리스트
	@RequestMapping("/userToneProductList")
	@ResponseBody
	public Map<String, List<ProductDTO>> userToneProductList(HttpServletRequest request) {

		return productService.userToneProductList(request);
	}

	// 상품을 조회 사용자의 톤에 따라 상품 조회 수 카운트 - 사용자의 톤에 따라 상품 조회 수 증가 컬럼 다름
	@RequestMapping("/countHits")
	public int countHits(HttpServletRequest request) {
		
		return productService.countHits(request); // 성공 1, 실패 0 
	}
	
	// 사용자와 같은 톤의 다른 사용자가 많이 조회한 순 리스트
	

	// 사용자 선호 가격범위 내 제품 리스트

	// 사용자 선호 색상범위 내 제품 리스트

	

	// 4가지 톤별 제품 리스트
	// 브랜드 별 제품 리스트
	// 총 조회수 기준으로 제품 리스트

}
