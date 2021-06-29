package com.briefing.webclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briefing.webclient.response.DocketCertidaoResponse;

@FeignClient(value = "docket", url = "https://docketdesafiobackend.herokuapp.com/api/v1")
public interface DocketWebClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/certidoes")
    List<DocketCertidaoResponse> getCertidoes();

}
