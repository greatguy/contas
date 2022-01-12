package com.santander.contas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.contas.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long> {

	Optional<Conta> findByConta(String numeroConta);

}
