package com.briefing.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.briefing.services.CartorioService;
import com.briefing.services.CertidaoService;
import com.briefing.views.CartorioView;
import com.briefing.webclient.ViaCepWebClient;
import com.briefing.webclient.response.ViaCepResponse;

@Controller
public class CartorioController {
	
	@Autowired
	private CartorioService service;
	
	@Autowired
	private CertidaoService certidaoService;
	
	@Autowired 
	private ViaCepWebClient cepClient;
	
	@RequestMapping("/create")
	public ModelAndView route() {
		ModelAndView tela = new ModelAndView("/create");
		
		tela.addObject("cartorio", new CartorioView());
		tela.addObject("cep", new CartorioView());
		
		List<String> certidoes = certidaoService.getCertidoes();
		tela.addObject("certidoes",certidoes);
		return tela;
	}
	
	@RequestMapping(value = "**/save", method = RequestMethod.POST)
	public ModelAndView save(CartorioView view) {
		service.save(view);
		return listaCartorios();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView listaCartorios() {
		
		ModelAndView tela = new ModelAndView("/home");
		
		Iterable<CartorioView> cartorios = service.findAll();
		tela.addObject("cartorios",cartorios);
		return tela;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		CartorioView cartorio = service.findId(id);
		ModelAndView tela = new ModelAndView("/create");
		List<String> certidoes = certidaoService.getCertidoes();
		tela.addObject("certidoes",certidoes);
		tela.addObject("cartorio", cartorio);
		tela.addObject("cep", new CartorioView());
		
		return tela;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "**/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cep")
	public ModelAndView getCep(Long cep) {
		ViaCepResponse infoCep = cepClient.getCep(cep);
		CartorioView infoCartorio = new CartorioView();
		infoCartorio.setLocalidade(infoCep.getLocalidade());
		infoCartorio.setLogradouro(infoCep.getLogradouro());
		infoCartorio.setNumero(infoCep.getNumero());
		infoCartorio.setBairro(infoCep.getBairro());
		infoCartorio.setCep(infoCep.getCep());
		infoCartorio.setUf(infoCep.getUf());
		
		ModelAndView tela = new ModelAndView("/create");
		
		tela.addObject("cartorio", infoCartorio);
		tela.addObject("cep", new CartorioView());
		
		List<String> certidoes = certidaoService.getCertidoes();
		tela.addObject("certidoes",certidoes);
		
		
		
		return tela;
	}
	
	

}
