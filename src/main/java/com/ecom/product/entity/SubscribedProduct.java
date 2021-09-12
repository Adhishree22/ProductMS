package com.ecom.product.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "subscribedproduct")
@IdClass(SubscribedProductId.class)
public class SubscribedProduct {

	@Id
	@Column(name = "buyer_id", nullable = false,length = 10)
	String buyerId;
	@Id
	@Column(name = "prod_id", nullable = false,length = 10)
	String prodId;
	@Column(nullable = false)
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

	public SubscribedProduct() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(buyerId, prodId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscribedProduct other = (SubscribedProduct) obj;
		return Objects.equals(buyerId, other.buyerId) && Objects.equals(prodId, other.prodId)
				&& quantity == other.quantity;
	}

}
