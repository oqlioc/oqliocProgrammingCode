package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.LikeProductDTO;


public interface LikeProductRepository extends JpaRepository<LikeProductDTO,String> {
	
	public static final String FIND_LIST="Select * From Like_Product Where Member_Id = :memberId";
	public static final String DELETE="Delete From Like_Product Where Member_Id = :memberId";
	public static final String FIND_DUPLI="Select * from Like_Product where Member_Id =:memberId and Pcode =:pcode";
	
	
	@Query(value=FIND_LIST, nativeQuery=true)
	public List<LikeProductDTO> findLikeProduct(@Param("memberId") String memberId);
	
	@Query(value=DELETE,nativeQuery=true)
	public void deleteLikeProduct (@Param("memberId") String memberId);
	
	@Query(value=FIND_DUPLI, nativeQuery=true)
	public LikeProductDTO findDupli(@Param("memberId") String memberId, @Param("pcode") String pcode);
}
