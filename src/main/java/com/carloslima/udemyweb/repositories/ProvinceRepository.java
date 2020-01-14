package com.carloslima.udemyweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carloslima.udemyweb.domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer>{

}
