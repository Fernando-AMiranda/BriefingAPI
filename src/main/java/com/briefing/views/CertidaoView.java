package com.briefing.views;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.briefing.entities.CartorioEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertidaoView {

	private Long certidaoId;

	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	private CartorioEntity cartorioId;

}
