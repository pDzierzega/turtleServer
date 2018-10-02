package com.pDzierzega.repository;

import com.pDzierzega.model.Turtle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TurtleRepository extends JpaRepository<Turtle,String> {
}
