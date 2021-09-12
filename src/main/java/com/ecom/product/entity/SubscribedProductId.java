package com.ecom.product.entity;

import java.io.Serializable;

public class SubscribedProductId implements Serializable  {

	private static final long serialVersionUID = 1L;
	String buyerId;
	String prodId;
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	
}
