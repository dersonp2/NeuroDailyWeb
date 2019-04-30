package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ND03_PAIS")
@SequenceGenerator(name = "ND03_PAIS_SEQ", sequenceName = "ND03_PAIS_SEQ", allocationSize = 1)
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND03_PAIS_SEQ")
    @Column(name = "ND03_COD_PAIS")
    private Long id;

    @Column(name = "ND03_DESCRICAO")
    private String descricao;

    @Column(name = "ND03_SIGLA")
    private String sigla;

}
