package models;

import java.io.Serializable;

public class Order implements Serializable {
	
	private String partNo;
	private int qty;
	
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
