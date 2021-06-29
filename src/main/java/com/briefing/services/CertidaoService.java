package com.briefing.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briefing.webclient.response.DocketCertidaoResponse;

@Service
public class CertidaoService {
	
	@Autowired
	private DocketService docketService;
	
	public List<String> getCertidoes() {
		List<DocketCertidaoResponse> docketCertidoes = docketService.getCertidoes();
		List<String> certidoes = new ArrayList<String>();
		
		for (DocketCertidaoResponse response : docketCertidoes) {
			certidoes.add(response.getNome());
		}
		
		return certidoes;
	}

}
