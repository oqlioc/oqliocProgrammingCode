package com.example.demo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.MemberDTO;

public interface MemberRepository extends JpaRepository<MemberDTO, String> {

	public static final String FIND_SELFT_BY_ID = "Select SelfT From Member Where Nick= :id";
	public static final String FIND_FIRST_LOGIN = "Select Id From Member Where SelfT IS NULL And Id= :id";
	public static final String UPDATE_SELFT = "Update Member Set SelfT= :selfT Where nick= :nick";
	public static final String UPDATE_DETAILT = "Update Member Set DetailT= :detailT Where Id= :id";
	public static final String FIND_INFO_DETAILTEST = "Select DetailT From Member Where Id= :id";

	MemberDTO findByIdAndPw(String id, String pw);

	Optional<MemberDTO> findById(String id);

	MemberDTO findByNick(String nick);

	@Query(value = FIND_SELFT_BY_ID, nativeQuery = true)
	String findSelfTById(String id);

	@Query(value = FIND_FIRST_LOGIN, nativeQuery = true)
	String findFirstOrNot(@Param("id") String id);

	@Transactional
	@Modifying
	@Query(value = UPDATE_SELFT, nativeQuery = true)
	public void updateSelfT(@Param("selfT") String selfT, @Param("nick") String nick);

	// 카메라 피부 결과값 넣기
	// ===================================================추가
	@Transactional
	@Modifying
	@Query(value = UPDATE_DETAILT, nativeQuery = true)
	public void memberDetailT(@Param("id") String id, @Param("detailT") String detailT);

	// 카메라 피부 결과값 들고오기
	// ===================================================
	@Query(value = FIND_INFO_DETAILTEST, nativeQuery = true)
	String info_detailtest(String id);
}
