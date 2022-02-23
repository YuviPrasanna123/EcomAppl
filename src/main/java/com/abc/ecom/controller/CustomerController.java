package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	@ApiOperation(value = "Save Customer by customerId", response = Customer.class, tags = "save Customer")
	@PostMapping("/save")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
	 @ApiOperation(value = "Get list of all customers", response = Iterable.class, tags = "getAllCustomers")
	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {
		
		List<Customer> customers =customerService.getAllCustomers();
		
		return customers;
	}
	 @ApiOperation(value = "Get specific Customer by customerId", response = Customer.class, tags = "getCustomer")
	@GetMapping("/get/{pid}")
	public ResponseEntity<?> fetchCustomerDetails(@PathVariable("pid") int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	 @ApiOperation(value = "Delete Customer by customerId", response = Customer.class, tags = "deleteCustomer")
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("pid") int customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>("Customer Deleted with id: "+customerId, HttpStatus.OK);
	}
	
	 
	 @ApiOperation(value = "Update specific Customer by customerId", response = Customer.class, tags = "modifyCustomer")
	@PutMapping("/update")
	public ResponseEntity<Customer> modifyCustomer(@RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	

}
