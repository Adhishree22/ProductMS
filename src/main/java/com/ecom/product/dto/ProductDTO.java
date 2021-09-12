package com.ecom.product.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ecom.product.entity.Product;

public class ProductDTO {

	String prodId;
	@NotNull
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "Name should only contain alphabets and spaces")
	String productName;
	@NotNull
	@Min(200)
	Double price;
	@Min(10)
	Integer stock;
	@Size(min=1,max=500)
	String description;
	@Pattern(regexp = "([^\\s]+(\\.(?i)(jpeg|png|jpg))$)", message = "Image should be in jpeg or png or jpg format only")
	String image;
	String sellerId;
	String category;
	String subcategory;
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

	
	
	@Override
	public String toString() {
		return "ProductDTO [prodId=" + prodId + ", productName=" + productName + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", image=" + image + ", sellerId=" + sellerId + ", category="
				+ category + ", subcategory=" + subcategory + ", productrating=" + productrating + "]";
	}

	// Converts Entity into DTO
	public static ProductDTO valueOf(Product prod) {
		ProductDTO prodDTO = new ProductDTO();
		prodDTO.setProdId(prod.getProdId());
		prodDTO.setProductName(prod.getProductName());
		prodDTO.setPrice(prod.getPrice());
		prodDTO.setStock(prod.getStock());
		prodDTO.setDescription(prod.getDescription());
		prodDTO.setImage(prod.getImage());
		prodDTO.setSellerId(prod.getSellerId());
		prodDTO.setCategory(prod.getCategory());
		prodDTO.setSubcategory(prod.getSubcategory());
		prodDTO.setProductrating(prod.getProductrating());
						
		return prodDTO;
	}
	
	// Converts DTO into Entity
	public Product createProduct() {
		Product prod = new Product();
		prod.setProdId(this.getProdId());
		prod.setProductName(this.getProductName());
		prod.setPrice(this.getPrice());
		prod.setStock(this.getStock());
		prod.setDescription(this.getDescription());
		prod.setImage(this.getImage());
		prod.setSellerId(this.getSellerId());
		prod.setCategory(this.getCategory());
		prod.setSubcategory(this.getSubcategory());
		prod.setProductrating(this.getProductrating());
		return prod;
	}

}
