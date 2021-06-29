package com.briefing.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briefing.entities.CartorioEntity;
import com.briefing.entities.CertidaoEntity;
import com.briefing.repositories.CartorioRepository;
import com.briefing.views.CartorioView;

@Service
public class CartorioService {
	
	@Autowired
	private CartorioRepository repository;
	
	public String save(CartorioView view) {
		
		List<CertidaoEntity> listCertidao = new ArrayList<CertidaoEntity>();
		CartorioEntity cartorioEntity = new CartorioEntity();
		cartorioEntity.setNome(view.getNome());
		cartorioEntity.setLogradouro(view.getLogradouro());
		cartorioEntity.setBairro(view.getBairro());
		cartorioEntity.setNumero(view.getNumero());
		cartorioEntity.setLocalidade(view.getLocalidade());
		cartorioEntity.setCep(view.getCep());
		cartorioEntity.setUf(view.getUf());
		
		for (String certidao : view.getCertidoes()) {
			listCertidao.add(CertidaoEntity.builder()
					.nome(certidao)
					.cartorioId(cartorioEntity)
					.build()
					);
			
		}
		
		cartorioEntity.setCertidoes(listCertidao);
		
		
		repository.save(cartorioEntity);
		
		return "";
		
	}
	
	public Iterable<CartorioView> findAll() {
		Iterable<CartorioEntity> listaEntity = repository.findAll();
		List<CartorioView> listaView = new ArrayList<CartorioView>();
		
		for (CartorioEntity cartorioEntity : listaEntity) {
			listaView.add(CartorioView.builder()
					.cartorioId(cartorioEntity.getCartorioId())
					.nome(cartorioEntity.getNome())
					.logradouro(cartorioEntity.getLogradouro())
					.numero(cartorioEntity.getNumero())
					.bairro(cartorioEntity.getBairro())
					.localidade(cartorioEntity.getLocalidade())
					.uf(cartorioEntity.getUf())
					.cep(cartorioEntity.getCep())
					.build());
		}
		
		return listaView;
	}
	
	public CartorioView findId(Long id) {
		CartorioEntity entity = repository.findById(id).get();
		
		return CartorioView.builder()
				.cartorioId(entity.getCartorioId())
				.nome(entity.getNome())
				.logradouro(entity.getLogradouro())
				.numero(entity.getNumero())
				.bairro(entity.getBairro())
				.localidade(entity.getLocalidade())
				.uf(entity.getUf())
				.cep(entity.getCep())
				.build();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
