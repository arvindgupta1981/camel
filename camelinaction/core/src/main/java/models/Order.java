package models;

import java.io.Serializable;

public class Order implements Serializable {
	
	private static final long serialVersionUID = -6443683364654020198L;
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
