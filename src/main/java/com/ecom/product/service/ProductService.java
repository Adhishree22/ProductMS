package com.ecom.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecom.product.dto.ProductDTO;
import com.ecom.product.entity.Product;
import com.ecom.product.repository.ProductRepository;

@Service
public class ProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepository productRepo;

	
	// Fetches all product details
	public List<ProductDTO> getAllProducts() throws Exception{

		List<Product> products = productRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}

			logger.info("Product details : {}", productDTOs);
			if (productDTOs.isEmpty()){
				throw new Exception("Service.PRODUCTS_NOT_FOUND");
			}
			return productDTOs;
		}
		
	// Fetches product details by category
	public List<ProductDTO> getProductByCategory(@PathVariable String category) throws Exception{

		List<Product> products = productRepo.getByCategory(category);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}
		
		logger.info("Product details by category : {}", productDTOs);
		if (productDTOs.isEmpty()){
			throw new Exception("Service.PRODUCTS_NOT_FOUND");
		}
		return productDTOs;
	}
	
	// Fetches  product details by name 
	public List<ProductDTO> getProductByName(@PathVariable String productName) throws Exception{

		List<Product> products = productRepo.getByProductName(productName);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}
		
		logger.info("Product details by name : {}", productDTOs);
		if (productDTOs.isEmpty()){
			throw new Exception("Service.PRODUCTS_NOT_FOUND");
		}
		return productDTOs;
	}
	
	// Fetches  product details by ProductId 
	public ProductDTO getProductByProdId(@PathVariable String prodId) throws Exception{
		Optional<Product> products = productRepo.findByProdId(prodId);
		Product product = products.orElseThrow(() -> new Exception("Service.PRODUCT_NOT_FOUND"));
		ProductDTO productDTO =ProductDTO.valueOf(product); 
		return productDTO;
	}

	//Update Product by product Id
	public void updateProductStock(@Valid String prodId,@Valid Integer stock) throws Exception {
        Optional<Product> products = productRepo.findByProdId(prodId);
		Product product1 = products.orElseThrow(() -> new Exception("Service.PRODUCT_NOT_FOUND"));
		if(stock>10) {
			product1.setStock(stock);
		}else {
			throw new Exception("Stock Should be more than 10");
		}
		productRepo.save(product1);
    }

	//Add new Product
	public String addProduct(ProductDTO productDTO) throws Exception {
			Product productEntity = productDTO.createProduct();
			Optional<Product> product = productRepo.findByProdId(productEntity.getProdId());
			if(product.isPresent()) {
				throw new Exception("Product Already Exists");
			}
			productRepo.save(productEntity);
			return productEntity.getProdId();
	}

	//Delete Product
	public void deleteProduct(String productId) throws Exception {
		Optional<Product> product = productRepo.findByProdId(productId);
		product.orElseThrow(() -> new Exception("Service.PRODUCT_NOT_FOUND"));
		productRepo.deleteById(productId);	
	}
	
}
