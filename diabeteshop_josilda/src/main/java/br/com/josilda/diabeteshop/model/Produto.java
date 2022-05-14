package br.com.josilda.diabeteshop.model;

import java.io.Serializable;

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
@Table(name = "produtos")

public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long codigo;
    private String nome;
    private String marca;
    private Float altura;
    private Float largura;
    private Float profundidade;
    private Float volume;
    private Float peso;
    private Float precocompra;
    private Float precovenda;
    private String datacadastro;

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Float getAltura() {
        return this.altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getLargura() {
        return this.largura;
    }

    public void setLargura(Float largura) {
        this.largura = largura;
    }

    public Float getProfundidade() {
        return this.profundidade;
    }

    public void setProfundidade(Float profundidade) {
        this.profundidade = profundidade;
    }

    public Float getVolume() {
        return this.volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getPeso() {
        return this.peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getPrecocompra() {
        return this.precocompra;
    }

    public void setPrecocompra(Float precocompra) {
        this.precocompra = precocompra;
    }

    public Float getPrecovenda() {
        return this.precovenda;
    }

    public void setPrecovenda(Float precovenda) {
        this.precovenda = precovenda;
    }

    public String getDatacadastro() {
        return this.datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

}
