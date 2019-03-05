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
	
//*************************************************************************************
	// 쿨톤 상품 리스트
	@RequestMapping("/CoolproductList")
	@ResponseBody
	public Map<String, List<ProductDTO>> CoolproductList() {

		return productService.CoolproductList();
	}

	// 웜톤 상품 리스트
	@RequestMapping("/WarmproductList")
	@ResponseBody
	public Map<String, List<ProductDTO>> WarmproductList() {

		return productService.WarmproductList();
	}

	// 조회수 상품 리스트
	@RequestMapping("/CountproductList")

	@ResponseBody
	public Map<String, List<ProductDTO>> CountproductList() {

		return productService.CountproductList();
	}
//*************************************************************************************
	
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

	// 사용자 선호 가격범위 내 제품 리스트
	@RequestMapping("/preferPriceProduct")
	public Map<String, List<ProductDTO>> preferPriceProduct(HttpServletRequest request) {

		return productService.preferPriceProduct(request);
	}

}
