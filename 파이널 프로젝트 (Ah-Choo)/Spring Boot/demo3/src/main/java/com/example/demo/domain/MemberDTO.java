package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Member")
public class MemberDTO {

	@Id
	@Column(name = "Id", unique = true)
	private String id;

	@Column(name = "Pw")
	private String pw;

	@Column(name = "Nick")
	private String nick;

	@Column(name = "Email")
	private String email;

	@Column(name = "SelfT")
	private String selfT;

	@Column(name = "DetailT")
	private String detailT;

	private int priceRange;

	private int colorRange;

	public MemberDTO() {

	}

	public MemberDTO(String id, String pw, String nick, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.email = email;

	}

	public MemberDTO(String id, String pw, String nick, String email, String selfT, String detailT, int priceRange,
			int colorRange) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.email = email;
		this.selfT = selfT;
		this.detailT = detailT;
		this.priceRange = priceRange;
		this.colorRange = colorRange;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSelfT() {
		return selfT;
	}

	public void setSelfT(String selfT) {
		this.selfT = selfT;
	}

	public String getDetailT() {
		return detailT;
	}

	public void setDetailT(String detailT) {
		this.detailT = detailT;
	}

	public int getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(int priceRange) {
		this.priceRange = priceRange;
	}

	public int getColorRange() {
		return colorRange;
	}

	public void setColorRange(int colorRange) {
		this.colorRange = colorRange;
	}

}
