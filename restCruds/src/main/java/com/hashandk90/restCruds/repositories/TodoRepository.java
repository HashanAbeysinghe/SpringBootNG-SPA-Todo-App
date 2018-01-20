package com.hashandk90.restCruds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashandk90.restCruds.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

}
