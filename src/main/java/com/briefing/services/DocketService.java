package com.briefing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briefing.webclient.DocketWebClient;
import com.briefing.webclient.response.DocketCertidaoResponse;

@Service
public class DocketService {
	
	@Autowired
	private DocketWebClient client;
	
	public List<DocketCertidaoResponse> getCertidoes() {
		return client.getCertidoes();
	}

}
