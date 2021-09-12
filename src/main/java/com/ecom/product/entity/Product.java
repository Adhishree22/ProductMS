package com.ecom.product.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "prod_id", nullable = false,length = 10)
	String prodId;
	@Column(name = "product_name",nullable = false, length = 100)
	String productName;
	@Column(nullable = false)
	Double price;
	@Column(nullable = false)
	Integer stock;
	@Column(nullable = false, length = 500)
	String description;
	@Column(nullable = false, length = 100)
	String image;
	@Column(name = "seller_id",nullable = false,length = 10)
	String sellerId;
	@Column(nullable = false, length = 50)
	String category;
	@Column(nullable = false, length = 50)
	String subcategory;
	@Column(nullable = false)
	Double productrating;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Double getProductrating() {
		return productrating;
	}

	public void setProductrating(Double productrating) {
		this.productrating = productrating;
	}

	public Product() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, image, price, prodId, productName, productrating, sellerId, stock,
				subcategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(image, other.image) && Objects.equals(price, other.price)
				&& Objects.equals(prodId, other.prodId) && Objects.equals(productName, other.productName)
				&& Objects.equals(productrating, other.productrating) && Objects.equals(sellerId, other.sellerId)
				&& stock == other.stock && Objects.equals(subcategory, other.subcategory);
	}
	
	
	
}