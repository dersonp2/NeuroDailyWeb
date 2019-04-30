package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ND04_ESTADO")
@SequenceGenerator(name = "ND04_ESTADO_SEQ", sequenceName = "ND04_ESTADO_SEQ", allocationSize = 1)
public class Estado implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND04_ESTADO_SEQ")
    @Column(name = "ND04_COD_ESTADO")
    private Long id;


    @Column(name = "ND04_DESCRICAO")
    private String descricao;

    @Column(name = "ND04_SIGLA")
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "FKND04ND03_COD_PAIS")
    private Pais pais;

}
