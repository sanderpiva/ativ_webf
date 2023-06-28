package br.edu.ifsuldeminas.mch.webii.crudmanager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Company;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.ServiceProvider;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.CompanyRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.ServiceProviderRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.UserRepository;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner  {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
						
		ServiceProvider s = new ServiceProvider();
		s.setName("Pedro Limpezas Ltda");
		s.setEmail("p@gmail.com");
		s.setPhone("(35) 3295-0000");
		s.setAddress("Rua 12");
		
		ServiceProvider s2 = new ServiceProvider();
		s2.setName("Lia Jardinagens Ltda");
		s2.setEmail("lia@gmail.com");
		s2.setPhone("(35) 3295-0004");
		s2.setAddress("Rua 52");
		
		ServiceProvider s3 = new ServiceProvider();
		s3.setName("Liana Ferragens Ltda");
		s3.setEmail("lia@gmail.com");
		s3.setPhone("(35) 3295-0004");
		s3.setAddress("Rua 52");
		
		serviceProviderRepository.save(s);
		serviceProviderRepository.save(s2);
		serviceProviderRepository.save(s3);
		
		
		List<ServiceProvider> serviceProvider = serviceProviderRepository.findAll();
		
		for (ServiceProvider service:serviceProvider) {
			
			System.err.println(service.getName());
			System.err.println(service.getEmail());
			System.err.println(service.getPhone());
			System.err.println(service.getAddress());
			//empresa vinculada?
		}
			
		User emerson = new User();
		emerson.setName("Emerson");
		emerson.setEmail("emerson@gmail.com");
		emerson.setGender("M");
		
		User luiza = new User();
		luiza.setName("Luiza");
		luiza.setEmail("lu@gmail.com");
		luiza.setGender("F");	
		
		userRepository.save(emerson);
		userRepository.save(luiza);
		
		
		List<User> users = userRepository.findAll();
		
		for (User user:users) {
			
			System.err.println(user.getName());
			System.err.println(user.getEmail());
			System.err.println(user.getGender());
		}
		
		Company c = new Company();
		c.setName("Unilever");
		c.setCnpj("00001/200");
		c.setAddress("Rua 9");
		c.setPhone("(35) 3295-0010");
		
		
		Company c2 = new Company();
		c2.setName("Rodia");
		c2.setCnpj("00001/280");
		c2.setAddress("Rua 4");
		c2.setPhone("(35) 3295-0015");
	
		c.setServiceProvider(s);
		c2.setServiceProvider(s2);
		
		companyRepository.save(c);
		companyRepository.save(c2);

		List<Company> companies = companyRepository.findAll();
		
		for (Company company:companies) {
			
			System.err.println(company.getName());
			System.err.println(company.getCnpj());
			System.err.println(company.getAddress());
			System.err.println(company.getPhone());
			//empresa vinculada?
		}
				
	}
	
}
