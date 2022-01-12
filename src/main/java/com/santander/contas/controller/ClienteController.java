package com.santander.contas.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.santander.contas.dto.ClienteDto;
import com.santander.contas.entity.Cliente;
import com.santander.contas.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<ClienteDto> lista() {
		
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.converter(clientes);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> consultaCliente(@PathVariable Long id) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) { return ResponseEntity.ok(new ClienteDto(cliente.get())); }
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteDto clienteDto, UriComponentsBuilder uriBuilder) {
		
			Cliente cliente = clienteDto.converter();		
			clienteRepository.save(cliente);
			
			URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
			return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDto clienteDto) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
		
			cliente.get().setBairro(clienteDto.getBairro());
			cliente.get().setCelular(clienteDto.getCelular());
			cliente.get().setCep(clienteDto.getCep());
			cliente.get().setCidade(clienteDto.getCidade());
			cliente.get().setCpf(clienteDto.getCpf());
			cliente.get().setDataNascimento(clienteDto.getDataNascimento());
			cliente.get().setEndereco(clienteDto.getEndereco());
			cliente.get().setEstado(clienteDto.getEstado());
			cliente.get().setIdade(clienteDto.getIdade());
			cliente.get().setMae(clienteDto.getMae());
			cliente.get().setNome(clienteDto.getNome());
			cliente.get().setNumero(clienteDto.getNumero());
			cliente.get().setPai(clienteDto.getPai());
			cliente.get().setRg(clienteDto.getRg());
			cliente.get().setSalario(clienteDto.getSalario());
			cliente.get().setSexo(clienteDto.getSexo());
			cliente.get().setTelefone(clienteDto.getTelefone());
			
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		
		} 
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> excluir(@PathVariable Long id) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} 
		
		return ResponseEntity.notFound().build();
		
	}

}
