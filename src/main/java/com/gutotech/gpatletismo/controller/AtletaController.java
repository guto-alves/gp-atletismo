package com.gutotech.gpatletismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gutotech.gpatletismo.model.Atleta;
import com.gutotech.gpatletismo.service.AtletaService;
import com.gutotech.gpatletismo.service.PaisService;
import com.gutotech.gpatletismo.service.ProvaService;

@Controller
@RequestMapping("atletas")
public class AtletaController {
	@Autowired
	AtletaService atletaService;

	@Autowired
	PaisService paisService;

	@Autowired
	ProvaService provaService;

	@GetMapping({"", "lista"})
	public String showListaAtletas(Model model) {
		model.addAttribute("atletas", atletaService.findAll());
		return "atletas-list";
	}

	@GetMapping("registrar")
	public String showAtletaForm(Model model) {
		model.addAttribute("atleta", new Atleta());
		model.addAttribute("paises", paisService.findAll());
		model.addAttribute("provas", provaService.findAll());
		return "atleta-form";
	}

	@PostMapping("save")
	public String saveAtleta(@ModelAttribute("atleta") Atleta atleta) {
		atletaService.save(atleta);
		return "redirect:/atletas/registrar";
	}

}
