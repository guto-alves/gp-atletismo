package com.gutotech.gpatletismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gutotech.gpatletismo.service.ProvaService;

@Controller
public class ProvaController {
	@Autowired
	private ProvaService provaService;

	@GetMapping("provas")
	public String getProvas(Model model) {
		model.addAttribute("provas", provaService.findAll());
		return "provas";
	}

}
