package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.ServiceProvider;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.CompanyRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ServiceProviderRepository;

@Controller
public class ServiceProviderController {


	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@GetMapping("/serviceProviders")
	public String prestadores(Model model) {

		List<ServiceProvider> serviceProviders = serviceProviderRepository.findAll();
		model.addAttribute("serviceProviders", serviceProviders);

		//o retorno de um metodo (spring) eh a pagina que é redirecionada
		//eh um .html
		return "indexServiceProvider";
	}

	@GetMapping("/serviceProviders/form")
	public String serviceProvidersForm(@ModelAttribute("serviceProvider")  ServiceProvider serviceProvider) {

		return "serviceProvider_form";
	}


	@PostMapping("/serviceProviders/new")
	public String serviceProviderNew(@Valid
			@ModelAttribute ServiceProvider serviceProvider, 
			BindingResult bidinBindingResult) {

		if(bidinBindingResult.hasErrors()) {

			return "serviceProvider_form";
		}


		serviceProviderRepository.save(serviceProvider);

		return "redirect:/serviceProviders";
	}

	@GetMapping("/serviceProviders/update{id}")
	public String serviceProviderUpdate(@PathVariable("id")
	Integer id, Model model) {

		Optional<ServiceProvider> optServiceProvider  = serviceProviderRepository.findById(id);

		if(optServiceProvider.isPresent()) {
			//gera erro

		}

		ServiceProvider serviceProvider = optServiceProvider.get();

		model.addAttribute("serviceProvider", serviceProvider);

		return "serviceProvider_form";
	}


	@GetMapping("/serviceProviders/delete{id}")
	public String serviceProvidersDelete(@PathVariable("id")
	Integer id, Model model) {

		Optional<ServiceProvider> optServiceProviders  = serviceProviderRepository.findById(id);

		if(optServiceProviders.isPresent()) {
			//gera erro


		}

		ServiceProvider serviceProvider = optServiceProviders.get();

		serviceProviderRepository.delete(serviceProvider);

		return "redirect:/serviceProviders";
	}

}
