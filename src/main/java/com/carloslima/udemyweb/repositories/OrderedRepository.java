package com.carloslima.udemyweb.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carloslima.udemyweb.domain.Customer;
import com.carloslima.udemyweb.domain.Ordered;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Integer>{
	
	@Transactional(readOnly=true)
	Page<Ordered> findByCustomer(Customer customer, Pageable pageRequest);
}
