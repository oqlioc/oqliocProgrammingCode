package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductDTO {

	@Id
	private String Pcode;
	private String Pbrand;
	private String Pname;
	private String Pcolor;
	private String Pprice;
	private String Pimg;
	private String Ptone;
	private String PcolorCode;
	private int swHits;
	private int awHits;
	private int scHits;
	private int wcHits;
	private int totalHits;
	
	public ProductDTO() {
	}

	public ProductDTO(String pcode, String pbrand, String pname, String pcolor, String pprice, String pimg,
			String ptone, String pcolorCode, int swHits, int awHits, int scHits, int wcHits, int totalHits) {
		super();
		Pcode = pcode;
		Pbrand = pbrand;
		Pname = pname;
		Pcolor = pcolor;
		Pprice = pprice;
		Pimg = pimg;
		Ptone = ptone;
		PcolorCode = pcolorCode;
		this.swHits = swHits;
		this.awHits = awHits;
		this.scHits = scHits;
		this.wcHits = wcHits;
		this.totalHits = totalHits;
	}

	public String getPcode() {
		return Pcode;
	}

	public void setPcode(String pcode) {
		Pcode = pcode;
	}

	public String getPbrand() {
		return Pbrand;
	}

	public void setPbrand(String pbrand) {
		Pbrand = pbrand;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public String getPcolor() {
		return Pcolor;
	}

	public void setPcolor(String pcolor) {
		Pcolor = pcolor;
	}

	public String getPprice() {
		return Pprice;
	}

	public void setPprice(String pprice) {
		Pprice = pprice;
	}

	public String getPimg() {
		return Pimg;
	}

	public void setPimg(String pimg) {
		Pimg = pimg;
	}

	public String getPtone() {
		return Ptone;
	}

	public void setPtone(String ptone) {
		Ptone = ptone;
	}

	public String getPcolorCode() {
		return PcolorCode;
	}

	public void setPcolorCode(String pcolorCode) {
		PcolorCode = pcolorCode;
	}

	public int getSwHits() {
		return swHits;
	}

	public void setSwHits(int swHits) {
		this.swHits = swHits;
	}

	public int getAwHits() {
		return awHits;
	}

	public void setAwHits(int awHits) {
		this.awHits = awHits;
	}

	public int getScHits() {
		return scHits;
	}

	public void setScHits(int scHits) {
		this.scHits = scHits;
	}

	public int getWcHits() {
		return wcHits;
	}

	public void setWcHits(int wcHits) {
		this.wcHits = wcHits;
	}

	public int getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(int totalHits) {
		this.totalHits = totalHits;
	}


	

}
