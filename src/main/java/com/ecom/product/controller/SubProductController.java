package com.ecom.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ecom.product.dto.BuyerDTO;
import com.ecom.product.dto.SubscribedProductDTO;
import com.ecom.product.service.SubscribedProductService;

import org.springframework.core.env.Environment;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class SubProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SubscribedProductService subprodService;
	
	@Autowired
	private Environment environment;
	
	@Value("${buyer.uri}")
	String buyerUri;
	
	// Fetches subscribed products by buyerId -8
	@GetMapping(value = "/subscriptions/{buyerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubscribedProductDTO>> getByBuyerId(@PathVariable String buyerId) throws Exception {
		try {
			List<SubscribedProductDTO> subprodDTO = subprodService.getByBuyerId(buyerId);
			return new ResponseEntity<>(subprodDTO, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
	//Add Product -9
	@PostMapping(value = "/addsubproduct",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addSubProduct(@RequestBody SubscribedProductDTO subprodDTO) throws Exception {
		try {
			
			String Subprod = subprodService.addSubProduct(subprodDTO);			
			BuyerDTO buyerDTO = new RestTemplate().getForObject(buyerUri+subprodDTO.getBuyerId(), BuyerDTO.class);
			if(buyerDTO==null || buyerDTO.isIsprivileged()!=true) {
				throw new Exception("Not a Previledged Buyer");
			}		
			String successMessage = environment.getProperty("API.ADD_SUCCESS") + Subprod;
			return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}	


	/* NOT Needed
	 // Fetches all subscribed products
	@GetMapping(value = "/subscriptions", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SubscribedProductDTO> getAllSubProduct() {
		logger.info("Fetching all subscribed products");
		return subprodService.getAllSubProduct();
	}*/
}
