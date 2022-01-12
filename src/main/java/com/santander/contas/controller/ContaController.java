package com.santander.contas.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.santander.contas.dto.ContaDetalheDto;
import com.santander.contas.dto.ContaDto;
import com.santander.contas.entity.Cliente;
import com.santander.contas.entity.Conta;
import com.santander.contas.repository.ClienteRepository;
import com.santander.contas.repository.ContaRepository;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ContaRepository contaRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ContaDto contaDto, UriComponentsBuilder uriBuilder) {
		
		
			Optional<Conta> contaBanco = contaRepository.findByConta(contaDto.getConta());
			
			if(contaBanco.isPresent()) {
				return new ResponseEntity<>("Número da Conta já existe", HttpStatus.BAD_REQUEST);
			}
		
			Cliente cliente = clienteRepository.getById(contaDto.getIdCliente());
			
			Conta conta = new Conta();
			
			conta.setAgencia(contaDto.getAgencia());
			conta.setConta(contaDto.getConta());
			conta.setCliente(cliente);
			
			contaRepository.save(conta);
			
			URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
			return ResponseEntity.created(uri).body(new ContaDto(conta));
	}
	
	
	@GetMapping("/{numeroConta}")
	public ResponseEntity<ContaDetalheDto> detalharConta(@PathVariable String numeroConta) {
		
		Optional<Conta> conta = contaRepository.findByConta(numeroConta);
		
		if(conta.isPresent()) { return ResponseEntity.ok(new ContaDetalheDto(conta.get())); }
		
		return ResponseEntity.notFound().build();
		
	}

}
