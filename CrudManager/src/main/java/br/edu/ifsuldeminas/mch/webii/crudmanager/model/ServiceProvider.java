package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "prestadores")
public class ServiceProvider {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String role;
	//private Company company;
	
	public ServiceProvider() {
		setName("");
		setEmail("");
		setPhone("");
		setRole("");
		
	}
	
	public ServiceProvider(Integer id) {
		
		this.id=id;
		setName("");
		setEmail("");
		setPhone("");
		setRole("");
		
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	/*
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/
		

}
