package com.example.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LikeProduct")
public class LikeProductDTO {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "uuid")
	 * 
	 * @GenericGenerator(name = "uuid", strategy = "uuid2")
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "LikePcode", unique = true)
	private int likePcode;

	@Column(name = "MemberId")
	private String memberId;

	@Column(name = "Pcode")
	private String pcode;
	
	/*
	 * @OneToOne(cascade= {CascadeType.ALL})
	 * 
	 * @JoinColumn(name="Id") private ProductDTO ProductDTO;
	 */
	

	public LikeProductDTO() {
		
	}
	public int getLikePcode() {
		return likePcode;
	}

	public void setLikePcode(int likePcode) {
		this.likePcode = likePcode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

}
