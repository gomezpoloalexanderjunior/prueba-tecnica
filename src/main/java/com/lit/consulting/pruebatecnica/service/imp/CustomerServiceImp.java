package com.lit.consulting.pruebatecnica.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lit.consulting.pruebatecnica.repository.CustomerRepository;

import com.lit.consulting.pruebatecnica.model.Customer;
import com.lit.consulting.pruebatecnica.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Customer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Customer> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

	@Transactional
	@Override
	public Customer save(Customer entity) throws Exception {
		return  customerRepository.save(entity);
	}

	@Transactional
	@Override
	public Customer update(Customer entity, Long id) throws Exception {
		Customer customerUpdate= customerRepository.findById(id).get();
		customerUpdate.setApellidoMaterno(entity.getApellidoMaterno());
		customerUpdate.setApellidoPaterno(entity.getApellidoPaterno());
		customerUpdate.setNombres(entity.getNombres());
		customerUpdate.setSexo(entity.getSexo());
		customerUpdate.setDireccion(entity.getDireccion());
		customerUpdate.setFechaNacimiento(entity.getFechaNacimiento());
		customerUpdate.setCorreo(entity.getCorreo());
		return  customerRepository.save(customerUpdate);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		customerRepository.deleteById(id);
	}

}
