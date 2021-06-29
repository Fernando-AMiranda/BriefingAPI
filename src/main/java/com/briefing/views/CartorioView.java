package com.briefing.views;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartorioView {
	
	private Long cartorioId;
	
	private String nome;
	
	private String cep;

	private String logradouro;

	private String bairro;

	private String uf;
	
	private String numero;
	
	private String localidade;
	
	private List<String> certidoes;
}
