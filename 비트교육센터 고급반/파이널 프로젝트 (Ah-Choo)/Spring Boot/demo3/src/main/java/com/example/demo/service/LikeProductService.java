package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.LikeProductDTO;
import com.example.demo.domain.ProductDTO;
import com.example.demo.repository.LikeProductRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class LikeProductService {

	@Autowired
	LikeProductRepository likeProductRepository;

	@Autowired
	ProductRepository productRepository;

	// 관심 상품 추가
	public int addToCart(@RequestBody LikeProductDTO lproductDTO) {
		System.out.println(lproductDTO.getMemberId());
		if (likeProductRepository.findDupli(lproductDTO.getMemberId(), lproductDTO.getPcode()) == null) {

			likeProductRepository.saveAndFlush(lproductDTO);
			return 1; // 관심상품 추가 성공

		} else
			return 0; // 이미 관심상품에 추가함

	}

	// 관심 상품 존재 확인
	public Map<String, List<ProductDTO>> likeProductList(HttpServletRequest request) {

		String memberId = request.getParameter("id");

		List<LikeProductDTO> likeProductDTO = likeProductRepository.findLikeProduct(memberId);

		if (likeProductDTO == null) {

			return null;
		} else {

			Map<String, List<ProductDTO>> result = new HashMap<>();

			List<ProductDTO> list = new ArrayList<>();

			for (LikeProductDTO dto : likeProductDTO) {

				list.add(productRepository.findByPcode(dto.getPcode()));

			}

			result.put("ProductDTO", list);

			return result;

		}

	}

	public int deleteLikeProduct(HttpServletRequest request) {

		String memberId = request.getParameter("id");

		likeProductRepository.deleteLikeProduct(memberId);

		return 1; // 관심 상품 삭제 성공
	}
}
