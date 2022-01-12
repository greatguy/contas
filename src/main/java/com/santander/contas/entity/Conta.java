package com.santander.contas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="conta")
public class Conta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3611074033680379636L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="agencia")
	private String agencia;
	
	@Column(name="conta")
	private String conta;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

}
