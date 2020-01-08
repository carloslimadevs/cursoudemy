package com.carloslima.udemyweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carloslima.udemyweb.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
