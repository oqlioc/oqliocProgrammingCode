package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO,String>{
	
	public static final String FIND_ALL_LIST="Select * From Product";
	public static final String FIND_BY_TONE="Select * From Product Where Ptone = :selfT";
	public static final String FIND_BY_PCODE="Select * From Product Where Pcode= :pcode";
	public static final String UPDATE_SW_HITS="Update Product p Set p.SW_HITS = p.SW_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	public static final String UPDATE_AW_HITS="Update Product p Set p.AW_HITS = p.AW_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	public static final String UPDATE_SC_HITS="Update Product p Set p.SC_HITS = p.SC_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	public static final String UPDATE_WC_HITS="Update Product p Set p.WC_HITS = p.WC_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	
	@Query(value=FIND_ALL_LIST, nativeQuery=true)
	public List<ProductDTO> findAllList();
	
	@Query(value=FIND_BY_TONE, nativeQuery=true)
	public List<ProductDTO> findByTone(@Param("selfT") String selfT);
	
	@Query(value=FIND_BY_PCODE, nativeQuery=true)
	public ProductDTO findByPcode(@Param("pcode") String pcode);
	
	@Transactional
	@Modifying
	@Query(value=UPDATE_SW_HITS, nativeQuery=true)
	public void updateSwHits(@Param("Pcode") String pcode);
	
	@Transactional
	@Modifying
	@Query(value=UPDATE_AW_HITS, nativeQuery=true)
	public void updateAwHits(@Param("Pcode") String pcode);
	
	@Transactional
	@Modifying
	@Query(value=UPDATE_SC_HITS, nativeQuery=true)
	public void updateScHits(@Param("Pcode") String pcode);
	
	@Transactional
	@Modifying
	@Query(value=UPDATE_WC_HITS, nativeQuery=true)
	public void updateWcHits(@Param("Pcode") String pcode);
}

