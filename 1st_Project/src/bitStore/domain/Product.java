package bitStore.domain;

public class Product {
	private String pName; //��ǰ��
	private int pNo; //��ǰ ��ȣ
	private int stock; //��� ����
	private int price; //��ǰ ����
	private String exprtDate; //�������
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
