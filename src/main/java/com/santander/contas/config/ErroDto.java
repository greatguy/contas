package com.santander.contas.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroDto {
	

	public ErroDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}
	
	private String campo;
	private String erro;

}
