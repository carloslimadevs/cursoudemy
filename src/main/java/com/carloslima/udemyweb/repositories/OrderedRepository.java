package com.carloslima.udemyweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carloslima.udemyweb.domain.Ordered;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Integer>{

}
