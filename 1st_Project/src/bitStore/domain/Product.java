package bitStore.domain;

public class Product {
	private String pName; //상품명
	private int pNo; //상품 번호
	private int stock; //재고 수량
	private int price; //상품 가격
	private String exprtDate; //유통기한
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExprtDate() {
		return exprtDate;
	}
	public void setExprtDate(String exprtDate) {
		this.exprtDate = exprtDate;
	}
	@Override
	public String toString() {
		return "ProductVO [pName=" + pName + ", pNo=" + pNo + ", stock=" + stock + ", price=" + price + ", exprtDate="
				+ exprtDate + "]";
	}
}
