package afferolab.chalenge.papelaria.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "produto", schema = "afferolabpapelaria")

public class Produto {
	
	
	public  Produto() {
		
	}
	
	public  Produto(String nome, String descricao, String categoria, String codigoDeBarras, int quantidade) {
		this.nome=nome;
		this.descricao=descricao;
		this.categoria=categoria;
		this.codigoDeBarras=codigoDeBarras;
		this.quantidade=quantidade;
	}
	
	public  Produto(Long id, String nome, String descricao, String categoria, String codigoDeBarras, int quantidade) {
		this.id=id;
		this.nome=nome;
		this.descricao=descricao;
		this.categoria=categoria;
		this.codigoDeBarras=codigoDeBarras;
		this.quantidade=quantidade;
	}
	
	
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "codigo_de_barras",length=13)
    private String codigoDeBarras;
    
    @Column(length=50)
    private String nome;
    
    @Column(length=150)
    private String descricao;
    
    @Column(length=50)
    private String categoria;
    
    private Integer quantidade;

    @CreationTimestamp
    private Date criacao;

    @UpdateTimestamp
    private Date atualizacao;
}