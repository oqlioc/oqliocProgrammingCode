package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Board1;

public interface BoardService {
	//게시판 리스트 보기
	public List<Board1> findAll();
	//게시판 글쓰기
	public void save(Board1 board1);

	public void delete(int id);

	public Board1 detail(int id);

	public void update(Board1 board1);
}
