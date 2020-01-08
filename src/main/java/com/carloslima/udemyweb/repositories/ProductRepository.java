package com.carloslima.udemyweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carloslima.udemyweb.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
