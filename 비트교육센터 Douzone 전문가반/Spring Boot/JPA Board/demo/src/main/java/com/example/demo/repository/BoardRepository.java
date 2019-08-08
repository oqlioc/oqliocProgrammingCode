package com.example.demo.repository;

import com.example.demo.model.Board1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board1, Integer>{

    public static final String FIND_BY_DETAIL="Select * From Board1 Where id = :id";

    @Query(value=FIND_BY_DETAIL, nativeQuery=true)
    public Board1 findByDetail(@Param("id") int id);
    
    // @Transactional
    // @Modifying
    // @Query(value=FIND_BY_UPDATE, nativeQuery=true)
    // public void update(@Param("id") int id);
}
