package com.gutotech.gpatletismo.controller;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gutotech.gpatletismo.model.Prova;
import com.gutotech.gpatletismo.model.Resultado;
import com.gutotech.gpatletismo.service.ProvaService;

// TODO uma forma de cadastrar a fase prelimiar e final
// TODO mostrar os 8 melhores da fase preliminar e os 3 (medalhas) final
// TODO consulta geral de todas as provas

@Controller
@RequestMapping("resultados")
public class ResultadoController {
	@Autowired
	private ProvaService provaService;

	@GetMapping("registrar")
	public String displayResultadoForm(Model model) {
		model.addAttribute("provas", provaService.findAll());
		model.addAttribute("resultado", new Resultado());
		return "resultado-form";
	}

	@GetMapping
	public String showResultados(@RequestParam("provaId") long provaId, Model model) {
		Prova prova = provaService.findById(provaId);
		
		Comparator<Resultado> comparator = (r1, r2) -> {
			if (prova.getTipo().equals("Tempo")) {
				if (r1.getTempo().before(r2.getTempo())) {
					return -1;
				} else if (r1.getTempo().after(r2.getTempo())) {
					return 1;
				}
			} else {
				double maxR1 = r1.getMelhorMarca();
				double maxR2 = r2.getMelhorMarca();
				
				if (maxR1 < maxR2) {
					return -1;
				} else if (maxR1 > maxR2) {
					return 1;
				}
			}
			
			return 0;
		};
		
		prova.getFases().get(0).getResultados().sort(comparator);
		prova.getFases().get(1).getResultados().sort(comparator);
		
		model.addAttribute("prova", prova);
		return "resultados";
	}

	@PostMapping("save")
	public String saveResultado(@RequestParam("resultado") Resultado resultado) {
		return "redirect:/resultado-form";
	}

}
