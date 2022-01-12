package com.santander.contas.dto;

import java.text.NumberFormat;

import com.santander.contas.entity.Conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDetalheDto {
	
	
	
	String nome;
	String agencia;
	String conta;
	Double salario;
	Double limite;
	
	String mensagem;
	
	public ContaDetalheDto() {}
	
	public ContaDetalheDto(Conta conta) {

		this.nome = conta.getCliente().getNome();
		this.agencia = conta.getAgencia();
		this.conta = conta.getConta();
		this.salario = conta.getCliente().getSalario();
		this.limite = conta.getCliente().getSalario() * 0.3;
		
		this.mensagem = "Se seu salário é de R$ " + NumberFormat.getCurrencyInstance().format(this.salario) + ", por exemplo, o limite do cartão deve ser de até R$ " + NumberFormat.getCurrencyInstance().format(this.limite) + ".";
	
	}
	

}
