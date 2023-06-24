package br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;

//UserRepository seria o UserDAO?

/*
 a anotação @Repository indica que a interface UserRepository
 é um repositório de dados para a entidade User,
 e a interface estende JpaRepository<User, Integer> 
 para herdar métodos predefinidos e fornecer operações
 de persistência relacionadas à entidade (classe) User.
 Integer é o tipo de dados esperado da entidade.Nesse exemplo, o unico dado
 inteiro se refere ao id do registro
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	
}
