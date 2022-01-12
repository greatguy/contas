package com.santander.contas.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.santander.contas.entity.Cliente;
import com.santander.contas.entity.Conta;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClienteDto {
	
	
	private Long id;
	private String nome;
	private Integer idade;
	private String cpf;
	private String rg;
	private Date dataNascimento;
	private String sexo;
	private String mae;
	private String pai;
	private String cep;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String celular;
	private Double salario;
	
	private List<Conta> contas;
	
	public ClienteDto() {}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.idade = cliente.getIdade();
		this.cpf = cliente.getCpf();
		this.rg = cliente.getRg();
		this.dataNascimento = cliente.getDataNascimento();
		this.sexo = cliente.getSexo();
		this.mae = cliente.getMae();
		this.pai = cliente.getPai();
		this.cep = cliente.getCep();
		this.endereco = cliente.getEndereco();
		this.numero = cliente.getNumero();
		this.bairro = cliente.getBairro();
		this.cidade = cliente.getCidade();
		this.estado = cliente.getEstado();
		this.telefone = cliente.getTelefone();
		this.celular = cliente.getCelular();
		this.salario = cliente.getSalario();
		this.contas = cliente.getContas();
		
	}
	
	
	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	} 
	
	public Cliente converter() {
		return new Cliente(this);
	}
	

}
