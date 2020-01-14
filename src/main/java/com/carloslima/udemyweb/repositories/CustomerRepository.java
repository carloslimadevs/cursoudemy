package com.carloslima.udemyweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carloslima.udemyweb.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
