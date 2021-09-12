package com.ecom.product.dto;

import com.ecom.product.entity.SubscribedProduct;

public class SubscribedProductDTO {
	
	String prodId;
	String buyerId;
	int quantity;
	
	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SubscribedProductDTO() {
		super();
	}

	@Override
	public String toString() {
		return "SubscribedProductDTO [prodId=" + prodId + ", buyerId=" + buyerId + ", quantity=" + quantity + "]";
	}

	// Converts Entity into DTO
	public static SubscribedProductDTO valueOf(SubscribedProduct subprod) {
		SubscribedProductDTO subprodDTO = new SubscribedProductDTO();
		subprodDTO.setProdId(subprod.getProdId());
		subprodDTO.setBuyerId(subprod.getBuyerId());
		subprodDTO.setQuantity(subprod.getQuantity());
						
		return subprodDTO;
	}
	
	// Converts DTO into Entity
	public SubscribedProduct createSubProduct() {
		SubscribedProduct subprod = new SubscribedProduct();
		subprod.setProdId(this.getProdId());
		subprod.setBuyerId(this.getBuyerId());
		subprod.setQuantity(this.getQuantity());
		
		return subprod;
	}
	
}