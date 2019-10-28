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
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "codigo_de_barras")
    private String codigoDeBarras;
    
    private String nome;
    private String descricao;
    private String categoria;
    private Integer quantidade;

    @CreationTimestamp
    private Date criacao;

    @UpdateTimestamp
    private Date atualizacao;
  
}

