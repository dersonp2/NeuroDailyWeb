package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND14_USUARIO")
@SequenceGenerator(name = "ND14_USUARIO_SEQ", sequenceName = "ND14_USUARIO_SEQ", allocationSize = 1)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND14_USUARIO_SEQ")
    @Column(name = "ND14_COD_USUARIO")
    private Long id;

    @Column(name = "ND01_SENHA")
    private String senha;

    @Column(name = "ND01_ATIVO")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "FKND02ND01_COD_PESSOA")
    private Pessoa pessoa;
}
