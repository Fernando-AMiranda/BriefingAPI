package com.briefing.webclient.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViaCepResponse {
	
	private String cep;

	private String logradouro;

	private String bairro;

	private String uf;
	
	private String numero;
	
	private String localidade;

}
