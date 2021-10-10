package com.clientControl.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientControl.domain.Cliente;

@Repository
public interface ClientDAO extends JpaRepository<Cliente, Integer>{

}
