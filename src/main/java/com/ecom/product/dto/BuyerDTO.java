package com.ecom.product.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class BuyerDTO {
	
	@NotNull
	String buyerId;
	@NotNull
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "Name should contain only alphabets and spaces")
	String name;
	@NotNull
	@Email(message = "Please provide a valid email address")
	String email;
	//@Size(@Min = 10,@Max= 10, message = "phoneNo should be exact 10 characters." )
	@Pattern(regexp="(^$|[0-9]{10})")
	String phoneNo;
	@NotNull
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@$%^&*]).{7,19}$", 
			message = "It should be 7 to 20 characters in length (both inclusive). It should contain at least one uppercase, at least one lowercase, at least one digit. "
					+ "It should also contain a special character amongst -! @, #, $, %, ^, &, *")
	String password;
	boolean isprivileged;
	int rewardpoints;
	boolean isactive;


	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsprivileged() {
		return isprivileged;
	}

	public void setIsprivileged(boolean isprivileged) {
		this.isprivileged = isprivileged;
	}

	public int getRewardpoints() {
		return rewardpoints;
	}

	public void setRewardpoints(int rewardpoints) {
		this.rewardpoints = rewardpoints;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	
	public BuyerDTO() {
		super();
	}

	@Override
	public String toString() {
		return "BuyerDTO [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", password=" + password + ", isprivileged=" + isprivileged + ", rewardpoints=" + rewardpoints
				+ ", isactive=" + isactive + "]";
	}
	
	

	/*// Converts Entity into DTO
	public static BuyerDTO valueOf(Buyer buyer) {
		BuyerDTO buyerDTO = new BuyerDTO();
		buyerDTO.setBuyerId(buyer.getBuyerId());
		buyerDTO.setName(buyer.getName());
		buyerDTO.setEmail(buyer.getEmail());
		buyerDTO.setPhoneNo(buyer.getPhoneNo());
		buyerDTO.setPassword(buyer.getPassword());
		buyerDTO.setIsprivileged(buyer.isIsprivileged());
		buyerDTO.setRewardpoints(buyer.getRewardpoints());
		buyerDTO.setIsactive(buyer.isIsactive());
						
		return buyerDTO;
	}
	
	// Converts DTO into Entity
	public Buyer createBuyer() {
		Buyer buyer = new Buyer();
		buyer.setBuyerId(this.getBuyerId());
		buyer.setName(this.getName());		
		buyer.setEmail(this.getEmail());
		buyer.setPhoneNo(this.getPhoneNo());
		buyer.setPassword(this.getPassword());
		buyer.setIsprivileged(this.isIsprivileged());
		buyer.setRewardpoints(this.getRewardpoints());
		buyer.setIsactive(this.isIsactive());
		
		return buyer;
	}*/
	
}