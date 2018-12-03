package NikeAdminDB;

public class NikeAdminDTO {
	private int ITEMNUM;
	private String TITLE;
	private int PRICE;
	private String BOARD;
	private int NUM;
	private String PIC1;
	private String PIC2;
	private String CONTENT;
	private String CATEGORY;
	
	public NikeAdminDTO() {
		// TODO Auto-generated constructor stub
	}
	
	// 신발 리스트
	public NikeAdminDTO(int ITEMNUM, String TITLE, int PRICE, String BOARD, int NUM, String PIC1, String PIC2, String CONTENT, String CATEGORY) {
		this.ITEMNUM = ITEMNUM;
		this.TITLE = TITLE;
		this.PRICE = PRICE;
		this.BOARD = BOARD;
		this.NUM = NUM;
		this.PIC1 = PIC1;
		this.PIC2 = PIC2;
		this.CONTENT = CONTENT;
		this.CATEGORY = CATEGORY;
	}
	
	public int getITEMNUM() {
		return ITEMNUM;
	}
	public void setITEMNUM(int iTEMNUM) {
		ITEMNUM = iTEMNUM;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public int getPRICE() {
		return PRICE;
	}
	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}
	public String getBOARD() {
		return BOARD;
	}
	public void setBOARD(String bOARD) {
		BOARD = bOARD;
	}
	public int getNUM() {
		return NUM;
	}
	public void setNUM(int nUM) {
		NUM = nUM;
	}
	public String getPIC1() {
		return PIC1;
	}
	public void setPIC(String pIC1) {
		PIC1 = pIC1;
	}
	public String getPIC2() {
		return PIC2;
	}
	public void setPIC2(String pIC2) {
		PIC2 = pIC2;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	
}
