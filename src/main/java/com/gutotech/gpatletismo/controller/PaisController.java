package com.gutotech.gpatletismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gutotech.gpatletismo.service.PaisService;

@Controller
public class PaisController {

	@Autowired
	private PaisService service;

	@GetMapping("paises")
	public String showPaises(Model model) {
		service.findAllAndCountTotalAtletas().forEach(pais -> {
			System.out.printf("%s %s%n", pais.getPais().getNome(), pais.getPais().getImagemUrl());
		});

		model.addAttribute("paises", service.findAllAndCountTotalAtletas());
		return "paises";
	}
	

	@GetMapping("test")
	public String test(Model model) {
		model.addAttribute("name", "Gustavo Alves");
		return "navtest";
	}

}
