package com.santander.contas.dto;

import com.santander.contas.entity.Conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDto {

	private Long idCliente;	
    private String agencia;	
	private String conta;	

	public ContaDto() {}
	
	public ContaDto(Conta conta) {
		super();
		this.idCliente = conta.getCliente().getId();
		this.agencia = conta.getAgencia();
		this.conta = conta.getConta();
	}
	

	
}
