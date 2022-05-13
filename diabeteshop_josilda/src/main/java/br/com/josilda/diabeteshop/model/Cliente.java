package br.com.josilda.diabeteshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pessoas")


public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private Long codigo;
private String nome;
private String genero;
private String endereco;
private String email;
private String contato;


    
}
