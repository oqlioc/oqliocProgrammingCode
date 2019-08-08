package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Board1;
import com.example.demo.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;

	@Override
	public List<Board1> findAll() {
		return boardRepository.findAll();
	}

	@Override
	public void save(Board1 board1) {
		boardRepository.saveAndFlush(board1);
	}

	@Override
	public void delete(int id) {
		boardRepository.deleteById(id);
	}

	@Override
	public Board1 detail(int id) {
		return boardRepository.findByDetail(id);
	}

	@Override
	public void update(Board1 board1) {
		boardRepository.saveAndFlush(board1);
	}
}