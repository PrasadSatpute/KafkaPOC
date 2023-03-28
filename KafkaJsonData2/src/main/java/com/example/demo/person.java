package com.example.demo;

public class person {
	private String Name;
	private int Price;
	private int id;
	
	public person(String name, int price, int id) {
		super();
		Name = name;
		Price = price;
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
