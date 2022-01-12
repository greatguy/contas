package com.santander.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.contas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	

}
