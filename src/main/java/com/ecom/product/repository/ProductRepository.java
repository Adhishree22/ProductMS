package com.ecom.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	List<Product> getByProductName(String productName);
	List<Product> getByCategory(String category);
	Optional<Product> findByProdId(String prodId);
	

}
