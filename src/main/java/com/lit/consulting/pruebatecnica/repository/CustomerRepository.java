package com.lit.consulting.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lit.consulting.pruebatecnica.model.Customer;

@Repository
public interface CustomerRepository extends  JpaRepository<Customer,Long>{

}
