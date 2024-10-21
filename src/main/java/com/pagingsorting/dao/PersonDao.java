package com.pagingsorting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagingsorting.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

	
}
