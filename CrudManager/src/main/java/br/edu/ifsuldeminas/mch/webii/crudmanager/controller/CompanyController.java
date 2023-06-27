package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Company;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.ServiceProvider;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.CompanyRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ServiceProviderRepository;

@Controller
public class CompanyController {
	
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	
	@GetMapping("/companies")
	public String empresas(Model model) {
		
		List<Company> companies = companyRepository.findAll();
		model.addAttribute("companies", companies);
		
		//o retorno de um metodo (spring) eh a pagina que é redirecionada
		//eh um .html
		return "indexCompany";
	}
	
	@GetMapping("/companies/form")
	public String companiesForm(@ModelAttribute("company")  Company company, Model model) {
		
		List<ServiceProvider> serviceProviders = serviceProviderRepository.findAll();
		model.addAttribute("serviceProviders", serviceProviders);
		
		
		return "company_form";
	}
	
	
	@PostMapping("/companies/new")
	public String companyNew(@Valid
			@ModelAttribute Company company, 
			BindingResult bidinBindingResult, 
			@RequestParam("spId")int id) {
		
		if(bidinBindingResult.hasErrors()) {
			
			return "company_form";
		}
		
		Optional<ServiceProvider> sp = serviceProviderRepository.findById(id);
		company.setServiceProvider(sp.get());
		companyRepository.save(company);
		
		return "redirect:/companies";

	}
	
	/*
	@PostMapping("/companies/new")
	public String companyNew(@ModelAttribute Company company) {
		
		companyRepository.save(company);
		
		return "redirect:/companies";
	}*/
	
	@GetMapping("/companies/update{id}")
	public String userUpdate(@PathVariable("id")
			Integer id, Model model) {
		
		Optional<Company> optCompany  = companyRepository.findById(id);
		
		if(optCompany.isPresent()) {
			//gera erro
			
		}
		
		Company company = optCompany.get();
		
		model.addAttribute("company", company);
		
		return "company_form";
	}
	
	
	@GetMapping("/companies/delete{id}")
	public String companiesDelete(@PathVariable("id")
			Integer id, Model model) {
		
		Optional<Company> optCompany  = companyRepository.findById(id);
		
		if(optCompany.isPresent()) {
			//gera erro
			
		}
		
		Company company = optCompany.get();
		
		companyRepository.delete(company);
		
		return "redirect:/companies";
	}

}
