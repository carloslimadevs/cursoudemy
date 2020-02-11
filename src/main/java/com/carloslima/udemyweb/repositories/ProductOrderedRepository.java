package com.carloslima.udemyweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carloslima.udemyweb.domain.ProductOrdered;

@Repository
public interface ProductOrderedRepository extends JpaRepository<ProductOrdered, Integer>{

}
