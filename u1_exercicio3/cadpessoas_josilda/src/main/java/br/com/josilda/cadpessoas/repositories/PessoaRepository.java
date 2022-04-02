package br.com.josilda.cadpessoas.repositories; 

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
 
import br.com.josilda.cadpessoas.model.Pessoa; 
 
@Repository 
public interface PessoaRepository extends JpaRepository <Pessoa, Long>{ 
     
}