package com.lit.consulting.pruebatecnica.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lit.consulting.pruebatecnica.model.Customer;
import com.lit.consulting.pruebatecnica.service.CustomerService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getPromotion() throws Exception {
		return new ResponseEntity<List<Customer>>(customerService.findAll(),HttpStatus.OK);
		
	}                  
	
	@PostMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer  customer) throws Exception {
		return new ResponseEntity<Customer>(customerService.save(customer),HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{id}",produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable Long id) throws Exception {
		return new ResponseEntity<Customer>(customerService.update(customer, id),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteCustomer(@PathVariable Long id) throws Exception {
	 customerService.deleteById(id);
	}
}
