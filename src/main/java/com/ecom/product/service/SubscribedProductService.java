package com.ecom.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecom.product.dto.SubscribedProductDTO;
import com.ecom.product.entity.SubscribedProduct;
import com.ecom.product.repository.SubscribedProductRepository;


@Service
public class SubscribedProductService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SubscribedProductRepository subProdRepo;

	// Fetches subscribed product details by buyerId
	public List<SubscribedProductDTO> getByBuyerId(@PathVariable String buyerId) throws Exception {


		List<SubscribedProduct> subprod = subProdRepo.getByBuyerId(buyerId);
		List<SubscribedProductDTO> subprodDTO = new ArrayList<SubscribedProductDTO>();

		for (SubscribedProduct subs : subprod) {
			subprodDTO.add(SubscribedProductDTO.valueOf(subs));
		}
		if(subprodDTO.isEmpty())
			throw new Exception("Service.EMPTY_SUBSCRIBED_PRODUCTS");
		logger.info("Productname for product : {}", subprod);

		return subprodDTO;
	}
	
	//Add Subscription for buyer
	public String addSubProduct(SubscribedProductDTO subpro) throws Exception {
		
		SubscribedProduct subproEntity = subpro.createSubProduct();
		Optional<SubscribedProduct> subprod = subProdRepo.findByBuyerIdAndProdId(subproEntity.getBuyerId(),subproEntity.getProdId());
		if(subprod.isPresent()) {
			throw new Exception("Product Already Subscribed");
		}
		subProdRepo.save(subproEntity);
		return subproEntity.getBuyerId();
		
	}

	/*
	// Fetches all subscribed product details 
	public List<SubscribedProductDTO> getAllSubProduct() {

		List<SubscribedProduct> subprod = subProdRepo.findAll();
		List<SubscribedProductDTO> subprodDTOs = new ArrayList<>();

		for (SubscribedProduct subs : subprod) {
			SubscribedProductDTO subscribedprodDTO = SubscribedProductDTO.valueOf(subs);
			subprodDTOs.add(subscribedprodDTO);
		}

		logger.info("Product Details : {}", subprodDTOs);
		return subprodDTOs;
	}*/

}
