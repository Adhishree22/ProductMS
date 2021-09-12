package com.ecom.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecom.product.dto.ProductDTO;
import com.ecom.product.service.ProductService;

import org.springframework.core.env.Environment;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	
	@Autowired
	private Environment environment;

	
	// Fetches all products -1
	@GetMapping(value = "/products",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getAllProduct() throws Exception {
		try {
			List<ProductDTO> prodDTO = productService.getAllProducts();
			return new ResponseEntity<>(prodDTO, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
	// Fetches products by name -2
	@GetMapping(value = "/product/{productName}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable String productName) throws Exception {
		try {
			List<ProductDTO> prodDTO = productService.getProductByName(productName);
			return new ResponseEntity<>(prodDTO, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
		
	// Fetches products by category -3
	@GetMapping(value = "/products/{category}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getProductBycategory(@PathVariable String category) throws Exception {
		try {
			List<ProductDTO> prodDTO = productService.getProductByCategory(category);
			return new ResponseEntity<>(prodDTO, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
	// Fetches product by productId -4
	@GetMapping(value = "/productid/{prodId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> getProductByProdId(@PathVariable String prodId) throws Exception {
		try {
			ProductDTO productDTO = productService.getProductByProdId(prodId);
			return new ResponseEntity<>(productDTO, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
	//Add Product -5
	@PostMapping(value = "/product",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@Valid @RequestBody ProductDTO productDTO) throws Exception {
		try {
			String prodId = productService.addProduct(productDTO);
			String successMessage = environment.getProperty("API.INSERT_SUCCESS") + prodId;
			return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}

	
	//Update product by productId -6
	@PutMapping(value = "/uproduct/{prodId}")
	public ResponseEntity<String> updateProductStock(@Valid @PathVariable String prodId ,@RequestBody ProductDTO product) throws Exception {
		try {
			productService.updateProductStock(prodId,product.getStock());
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
		
	//Delete Product -7
	@DeleteMapping(value = "/dproduct/{prodId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String prodId) throws Exception {
		try {
			productService.deleteProduct(prodId);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
}
