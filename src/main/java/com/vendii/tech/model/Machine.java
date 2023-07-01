package com.vendii.tech.model;

public class Machine {
	
	public int stockLevel=0;
	private String id;
	
	public Machine(String id) {
		this.id=id;
	}
	public int getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
