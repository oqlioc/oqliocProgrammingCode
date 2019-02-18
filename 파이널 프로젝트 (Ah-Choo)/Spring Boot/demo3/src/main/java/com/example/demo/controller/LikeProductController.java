package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.LikeProductDTO;
import com.example.demo.domain.ProductDTO;
import com.example.demo.service.LikeProductService;

@RestController
public class LikeProductController {

	@Autowired
	LikeProductService likeProductService;
	
	// 관심상품 추가
	@RequestMapping(value = "/addToCart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int addToCart(@RequestBody LikeProductDTO lproductDTO) {

		return likeProductService.addToCart(lproductDTO);

	}
	
	// 관심상품 조회 
	@RequestMapping(value="/likeProductList")
	public Map<String, List<ProductDTO>> likeProductList(HttpServletRequest request) {

		return likeProductService.likeProductList(request);
	}

	// 관심 상품 삭제
	@RequestMapping(value="/deleteLikeProduct")
	public int deleteLikeProduct(HttpServletRequest request) {
		
		return likeProductService.deleteLikeProduct(request);
	}
}
