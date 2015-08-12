package model;

import java.math.BigDecimal;

public class PurchaseOrder {
	private String name;
	private BigDecimal price;
	private int amount;
	
	
	public PurchaseOrder(String name, BigDecimal price, int amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

	@Override
	public String toString() {
		return "PurchaseOrder [name=" + name + ", price=" + price + ", amount="
				+ amount + "]";
	}
}
