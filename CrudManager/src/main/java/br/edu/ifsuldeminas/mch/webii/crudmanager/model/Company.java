package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "empresas")
public class Company {
	//chave primaria da tabela
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "nome não pode estar vazio")
	private String name;
	@NotBlank(message = "cnpj não pode estar vazio")
	private String cnpj;
	@NotBlank(message = "endereco não pode estar vazio")
	private String address;
	@NotBlank(message = "telefone não pode estar vazio")
	private String phone;
	
	@OneToOne(optional=false)
	private ServiceProvider serviceProvider;
	
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Company() {
		setName("");
		setCnpj("");
		setAddress("");
		setPhone("");
		
	}
	
	public Company(Integer id) {
		
		this.id=id;
		setName("");
		setCnpj("");
		setAddress("");
		setPhone("");
		
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
			
}
