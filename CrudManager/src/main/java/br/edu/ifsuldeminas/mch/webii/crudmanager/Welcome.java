package br.edu.ifsuldeminas.mch.webii.crudmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
	
	
	@RequestMapping("/welcome")
	public String chegada(Model model) {
		
		model.addAttribute("oi_chave", "Conteudo gerado de forma dinamica");
		
		return "bemvindo.html";
	}
}
