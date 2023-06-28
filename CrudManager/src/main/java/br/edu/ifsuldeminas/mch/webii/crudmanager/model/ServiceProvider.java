package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "prestadoras")
public class ServiceProvider {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "nome não pode estar vazio")
	private String name;
	
	@NotBlank(message = "email não pode estar vazio")
	@Email(message = "email invalido")
	private String email;
	@NotBlank(message = "telefone não pode estar vazio")
	private String phone;
	@NotBlank(message = "endereco não pode estar vazio")
	private String address;
	
	
	public ServiceProvider() {
		setName("");
		setEmail("");
		setPhone("");
		setAddress("");
		
	}
	
	public ServiceProvider(Integer id) {
		
		this.id=id;
		setName("");
		setEmail("");
		setPhone("");
		setAddress("");
		
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
			
}
