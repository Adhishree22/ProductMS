package com.ecom.product.repository;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.product.entity.SubscribedProduct;

@Repository
public interface SubscribedProductRepository extends JpaRepository<SubscribedProduct, String>{

	List<SubscribedProduct> getByBuyerId(String buyerId);

	Optional<SubscribedProduct> findByBuyerIdAndProdId(String buyerId, String prodId);

}
