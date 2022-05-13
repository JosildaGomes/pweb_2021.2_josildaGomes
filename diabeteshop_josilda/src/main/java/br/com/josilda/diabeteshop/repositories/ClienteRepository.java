package br.com.josilda.diabeteshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.josilda.diabeteshop.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository< Cliente, Long> {

    
}
     
    
