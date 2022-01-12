package com.santander.contas.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.santander.contas.dto.ClienteDto;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5743839151741925058L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome")
	@NotNull @NotBlank
	private String nome;
	
	@Column(name="idade")
	@NotNull
	private Integer idade;
	
	@Column(name="cpf")
	@NotNull @NotBlank
	private String cpf;
	
	@Column(name="rg")
	@NotNull @NotBlank
	private String rg;
	
	@Column(name="data_nasc")
	@NotNull 
	private Date dataNascimento;
	
	@Column(name="sexo")
	@NotNull @NotBlank
	private String sexo;
	
	@Column(name="mae")
	@NotNull @NotBlank
	private String mae;
	
	@Column(name="pai")
	@NotNull @NotBlank
	private String pai;
	
	@Column(name="cep")
	@NotNull @NotBlank
	private String cep;
	
	@Column(name="endereco")
	@NotNull @NotBlank
	private String endereco;
	
	@Column(name="numero")
	@NotNull
	private Integer numero;
	
	@Column(name="bairro")
	@NotNull @NotBlank
	private String bairro;
	
	@Column(name="cidade")
	@NotNull @NotBlank
	private String cidade;
	
	@Column(name="estado")
	@NotNull @NotBlank
	private String estado;
	
	@Column(name="telefone")
	@NotNull @NotBlank
	private String telefone;
	
	@Column(name="celular")
	@NotNull @NotBlank
	private String celular;
	
	@Column(name="salario")
	@NotNull 
	private Double salario;
	
	@JsonManagedReference
	@OneToMany(targetEntity=Conta.class, mappedBy="cliente",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Conta> contas;
	
	
	public Cliente() {}
	
	public Cliente(ClienteDto clienteDto) {
		super();
		this.id = clienteDto.getId();
		this.nome = clienteDto.getNome();
		this.idade = clienteDto.getIdade();
		this.cpf = clienteDto.getCpf();
		this.rg = clienteDto.getRg();
		this.dataNascimento = clienteDto.getDataNascimento();
		this.sexo = clienteDto.getSexo();
		this.mae = clienteDto.getMae();
		this.pai = clienteDto.getPai();
		this.cep = clienteDto.getCep();
		this.endereco = clienteDto.getEndereco();
		this.numero = clienteDto.getNumero();
		this.bairro = clienteDto.getBairro();
		this.cidade = clienteDto.getCidade();
		this.estado = clienteDto.getEstado();
		this.telefone = clienteDto.getTelefone();
		this.celular = clienteDto.getCelular();
		this.salario = clienteDto.getSalario();
		this.contas = clienteDto.getContas();
	}
	
}