package com.briefing.webclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briefing.webclient.response.ViaCepResponse;

@FeignClient(value = "viacep", url = "viacep.com.br/ws/")
public interface ViaCepWebClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "{cep}/json")
	ViaCepResponse getCep(@PathVariable("cep") Long cep);

}
