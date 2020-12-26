package com.hem.loyalty.service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hem.auth.model.User;
import com.hem.common.util.SequenceGeneratorService;
import com.hem.exception.InActiveRecordFoundException;
import com.hem.exception.RecordNotFoundException;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Customer;
import com.hem.loyalty.model.CustomerLoyaltyInfo;
import com.hem.loyalty.model.Points;
import com.hem.loyalty.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private SequenceGeneratorService seqService;

	@Autowired
	ICompanyService companyService;
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Customer findById(Long s) {
		Optional<Customer> customer= customerRepo.findById(s);
		if(customer.isPresent()) return customer.get();
		return null;
	}

	@Override
	public boolean isExist(Long t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer create(Customer customer, User user) {
		companyService.validate(customer.getCompany().getId());
		Company company=companyService.findById(customer.getCompany().getId());
		customer.setCompany(company);
		customer.setId(seqService.generateSequence(Customer.SEQUENCE_NAME));
		customer.setUser(user);
		customer.setCreatedDate(OffsetDateTime.now());
		customer.setEnabled(true);
		CustomerLoyaltyInfo loyaltyInfo = new CustomerLoyaltyInfo();
		loyaltyInfo.setAvailablePoints(0);
		loyaltyInfo.setCompany(company);
		loyaltyInfo.setLastTransactionDate(null);
		loyaltyInfo.setTotalPointsEarned(0);
		loyaltyInfo.setTotalPointsRedeemed(0);
		//loyaltyInfo.setCustomer(customer);
		loyaltyInfo.setId(UUID.randomUUID().toString());
		customer.setCustomerLoyaltyInfo(loyaltyInfo);
		
		
		if(customer.getAddresses()!=null && customer.getAddresses().size()>0) {
			customer.getAddresses().forEach(address->{
				address.setId(seqService.generateSequence(Address.SEQUENCE_NAME));
				address.setCreatedDate(new Date());
				address.setUser(user);
				address.setEnabled(true);
			});
		}
		
	   customer= customerRepo.save(customer);
	   loyaltyInfo.setCustomer(customer);
	   mongoTemplate.save(loyaltyInfo);
	   return customer;
	}

	private void validate(Customer customer) {
		companyService.validate(customer.getCompany().getId());
		if((Objects.nonNull(customer.getId())) && !isExist(customer.getId())) throw new RecordNotFoundException("Customer not found");
		if(!isActive(customer.getId())) throw new InActiveRecordFoundException("Customer is Inactive");
	}
	@Override
	public Customer update(Customer t) {
		
		final Customer customer = findById(t.getId());
		if(customer!=null) {
			t.getAddresses().stream().forEach(address->{
				Address address_=customer.getAddresses().stream().filter(a->a.getId()==address.getId()).findFirst().orElse(null);
				address_.setArea(address.getArea());
				address_.setCity(address.getCity());
				address_.setPostcode(address.getPostcode());
				address_.setStreet1(address.getStreet1());
				address_.setStreet2(address.getStreet2());
				address_.setStreet3(address.getStreet3());
				address_.setState(address.getState());
				address_.setEnabled(true);
			});	
			
			
			customer.setFirstName(t.getFirstName());
			customer.setMiddleName(t.getMiddleName());
			customer.setLastName(t.getLastName());
			customer.setDob(t.getDob());
			customer.setAnniversary(t.getAnniversary());
			customer.setGender(t.getGender());
			customer.setMobileNo(t.getMobileNo());
			customer.setEmail(t.getEmail());
			
			return mongoTemplate.save(customer);
				
		}else {
			throw new RecordNotFoundException("Customer doesn't exist");
		}
		
	}

	@Override
	public boolean isActive(Long t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Page<Customer> getAllCustomers(String companyId,int pageNo,int limit){
		Page<Customer> customers=customerRepo.findAllByCompanySortByFirstName(companyId, PageRequest.of(pageNo-1, limit));
		return customers;
		
	}

	@Override
	public Customer findByMobileNo(String companyId, String mobileNo) {
		Optional<Customer> customerOptional=customerRepo.findByMobileNo(companyId, mobileNo);
		if(customerOptional.isPresent()) return customerOptional.get();				
		return null;
	}

	@Override
	public Customer findByEmail(String companyId, String email) {
		Optional<Customer> customerOptional=customerRepo.findByEmail(companyId, email);
		if(customerOptional.isPresent()) return customerOptional.get();				
		return null;
	}

	@Override
	public void savePointsToCustomer(Points points) {
		    Customer customer = customerRepo.findById(points.getCustomer().getId()).get();
		    CustomerLoyaltyInfo customerLoyaltyInfo=customer.getCustomerLoyaltyInfo();
		    customerLoyaltyInfo.setAvailablePoints(customerLoyaltyInfo.getAvailablePoints()+points.getPoints());
		    customerLoyaltyInfo.setLastTransactionDate(points.getCreatedDate());
		    customerLoyaltyInfo.setTotalPointsEarned(customerLoyaltyInfo.getTotalPointsEarned()+points.getPoints());
		    mongoTemplate.save(customerLoyaltyInfo);
		    
		
	}

}
