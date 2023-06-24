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


/*
 @Component: Essa anotação marca a classe InitializeDataBase 
 como um componente gerenciado pelo Spring. 
 Um componente é uma classe que possui um papel específico
 na aplicação e pode ser injetado em outras classes
 através do mecanismo de injeção de dependência do Spring. 
 Essa anotação permite que o Spring detecte e gerencie a instância da classe InitializeDataBase.

 @transacional: p/ transações em banco de dados
 
 A classe InitializeDataBase implementa a interface CommandLineRunner, 
 que é uma interface do Spring Boot utilizada para executar tarefas após a inicialização da aplicação.
 O método run() é executado automaticamente quando a aplicação é iniciada.

 Dentro do método run(), há a criação de três instâncias da classe User
 com diferentes atributos (nome, email, gênero). 
 Esses objetos representam dados que serão salvos no banco de dados.

 O repositório UserRepository é injetado na classe através da anotação @Autowired,
 permitindo o acesso aos métodos de persistência do banco de dados.

 Em seguida, as instâncias de User são salvas no banco de dados utilizando o método save()
 do repositório userRepository. 
 Isso significa que os objetos emerson, luiza e le serão persistidos como registros na tabela de usuários do banco de dados.
 
 @component portanto: marca a classe InitializeDataBase 
 como um componente gerenciado pelo Spring.
 
 */

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner  {
	
	//repositorio é injetado: dependencias instanciadas pelo framework
	//nao tem acoplamento com classes, apenas com o repositorio
	//isso é bom
	@Autowired
	private UserRepository userRepository;
	private CompanyRepository companyRepository;
	private ServiceProviderRepository serviceProviderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User emerson = new User();
		emerson.setName("Emerson");
		emerson.setEmail("emerson@gmail.com");
		emerson.setGender("M");
		
		User luiza = new User();
		luiza.setName("Luiza");
		luiza.setEmail("lu@gmail.com");
		luiza.setGender("F");	
	
		User le = new User();
		le.setName("Luiza");
		le.setEmail("le@gmail.com");
		le.setGender("F");
		
		userRepository.save(emerson);
		userRepository.save(luiza);
		userRepository.save(le);
		
		//userRepository.delete(emerson);
		//userRepository.findAll();
		
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
		//c.setServiceProvider("Pedro");
		Company c2 = new Company();
		c2.setName("Rodia");
		c2.setCnpj("00001/280");
		c2.setAddress("Rua 4");
		

		List<Company> companies = companyRepository.findAll();
		
		for (Company company:companies) {
			
			System.err.println(company.getName());
			System.err.println(company.getCnpj());
			System.err.println(company.getAddress());
			System.err.println(company.getPhone());
			//empresa vinculada?
		}
		

		ServiceProvider s = new ServiceProvider();
		s.setName("Pedro");
		s.setEmail("p@gmail.com");
		s.setRole("Limpeza");
		//c.setServiceProvider("Pedro");
		ServiceProvider s2 = new ServiceProvider();
		s.setName("Lia");
		s.setEmail("lia@gmail.com");
		s.setRole("jardim");
		

		List<ServiceProvider> serviceProvider = serviceProviderRepository.findAll();
		
		for (ServiceProvider service:serviceProvider) {
			
			System.err.println(service.getName());
			System.err.println(service.getEmail());
			System.err.println(service.getPhone());
			System.err.println(service.getRole());
			//empresa vinculada?
		}

	}
	
}
