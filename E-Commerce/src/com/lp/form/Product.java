package com.lp.form;

public class Product
{

	private int Id;
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", price=" + price
				+ ", manifatcuredName=" + manifatcuredName + ", category="
				+ category + ", description=" + description + "]";
	}
	private String name;
	private float price;
	private String manifatcuredName;
	private String category;	
	private String description;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getManifatcuredName() {
		return manifatcuredName;
	}
	public void setManifatcuredName(String manifatcuredName) {
		this.manifatcuredName = manifatcuredName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}