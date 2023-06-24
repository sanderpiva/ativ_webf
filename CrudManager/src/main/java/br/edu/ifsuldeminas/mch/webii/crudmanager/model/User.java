package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/*
@Entity: Essa anotação indica que a classe User é uma entidade persistente.
Ela é usada pelo Hibernate (framework usado para fazer o crud: banco dados)
para reconhecer que essa classe deve ser mapeada para uma tabela no banco de dados.

@Table(name = "usuarios"): Essa anotação especifica o nome da tabela 
no banco de dados em que a entidade User será armazenada. No caso, o nome da tabela é "usuarios".

@Id: Essa anotação indica que o atributo id é a chave primária da tabela. 
O Hibernate utilizará esse atributo para identificar de forma única cada registro da tabela.

@GeneratedValue(strategy = GenerationType.AUTO): 
Essa anotação define a estratégia de geração de valores para a chave primária. 
Nesse caso, está sendo utilizada a estratégia "AUTO", 
que permite que o banco de dados determine automaticamente o valor da chave primária ao inserir um novo registro.
 */

@Entity
@Table(name = "usuarios")
public class User {
	//chave primaria da tabela
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String gender;
	
	public User() {
		setName("");
		setEmail("");
		setGender("");
	}
	
	public User(Integer id) {
		
		this.id=id;
		setName("");
		setEmail("");
		setGender("");
	}
	
	@OneToOne(optional=false)
	private ServiceProvider serviceProvider;
	
	
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
