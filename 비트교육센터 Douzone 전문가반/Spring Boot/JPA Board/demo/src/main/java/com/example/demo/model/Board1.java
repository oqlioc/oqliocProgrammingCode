package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
// 시퀀스의 시작값은 1
// 시퀀스의 기본 allocationSize는50, 번호가 50부터 생기므로 1로
@SequenceGenerator(name="BOARD_SEQ_GENERATOR1", sequenceName="BOARD_SEQ1", initialValue=1, allocationSize=1) 
public class Board1 {	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOARD_SEQ_GENERATOR1")    
	@Column(length=10)
	private int id;		
	
	@Column(length=4000)
	private String content;
	
	@Column(length=20)
	private String name;
	
	@Column(length=20)
	private String passwd;
	
	@Column(length=500)
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Board1 [content=" + content + ", id=" + id + ", name=" + name + ", passwd=" + passwd + ", title="
				+ title + "]";
	}
	
	

}
