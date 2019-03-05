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
	
	public static final String FIND_ALL="Select * From Product";
//*************************************************************************************
	public static final String FIND_COOL="Select * From Product Where Ptone Like 'SC' Or Ptone Like 'WC'";
	public static final String FIND_WARM="Select * From Product Where Ptone Like 'AW' Or Ptone Like 'SW'";
	public static final String FIND_Count="Select * From Product Order By Total_Hits DESC";
//*************************************************************************************
	public static final String FIND_BY_TONE="Select * From Product Where Ptone = :selfT";
	public static final String FIND_BY_PCODE="Select * From Product Where Pcode= :pcode";
	public static final String FIND_BY_PRICE="Select * From Product Where Pprice between :price1 and :price2";
	
	public static final String UPDATE_SW_HITS="Update Product p Set p.SW_HITS = p.SW_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	public static final String UPDATE_AW_HITS="Update Product p Set p.AW_HITS = p.AW_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	public static final String UPDATE_SC_HITS="Update Product p Set p.SC_HITS = p.SC_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	public static final String UPDATE_WC_HITS="Update Product p Set p.WC_HITS = p.WC_HITS + 1, p.TOTAL_HITS = p.TOTAL_HITS + 1 Where p.Pcode = :pcode";
	
	@Query(value=FIND_ALL, nativeQuery=true)
	public List<ProductDTO> findAllList();
	
//*************************************************************************************
	@Query(value=FIND_COOL, nativeQuery=true)
	public List<ProductDTO> findCoolList();
	
	@Query(value=FIND_WARM, nativeQuery=true)
	public List<ProductDTO> findWarmList();
	
	@Query(value=FIND_Count, nativeQuery=true)
	public List<ProductDTO> findCountList();
//*************************************************************************************
	
	@Query(value=FIND_BY_TONE, nativeQuery=true)
	public List<ProductDTO> findByTone(@Param("selfT") String selfT);
	
	@Query(value=FIND_BY_PCODE, nativeQuery=true)
	public ProductDTO findByPcode(@Param("pcode") String pcode);
	
	@Query(value=FIND_BY_PRICE, nativeQuery=true)
	public List<ProductDTO> findByPrice(@Param("price1") String price1, @Param("price2") String price2);
	
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

