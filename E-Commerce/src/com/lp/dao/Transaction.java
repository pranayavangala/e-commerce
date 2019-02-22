package com.lp.dao;

public class Transaction {

	int id;
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userid=" + userid + ", productId="
				+ productId + "]";
	}
	String userid;
	int productId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}
