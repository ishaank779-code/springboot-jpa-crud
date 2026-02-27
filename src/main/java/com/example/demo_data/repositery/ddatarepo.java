package com.example.demo_data.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_data.model.Authdata;



@Repository
  public interface ddatarepo extends JpaRepository<Authdata, Integer>{
    Authdata findByEmail(String email);
  }

