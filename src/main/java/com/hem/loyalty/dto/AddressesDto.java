package com.hem.loyalty.dto;

import java.util.List;

import com.hem.loyalty.model.Address;

public class AddressesDto {
	public List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
	  if(addresses!=null && addresses.size()>0)
		  addresses.forEach(System.out::println);
		
		return "";
	}

}
