package com.briefing.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARTORIO")
public class CartorioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartorioId;

	private String nome;

	private String cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String numero;
	
	private String localidade;
	
	private String uf;

	 @OneToMany(mappedBy="cartorioId", cascade= {CascadeType.ALL})
	private List<CertidaoEntity> certidoes;

}
