package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "ND12_PROFISSIONAL")
@SequenceGenerator(name = "ND12_PROFISSIONAL_SEQ", sequenceName = "ND12_PROFISSIONAL_SEQ", allocationSize = 1)
public class Profissional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND12_PROFISSIONAL_SEQ")
    @Column(name = "ND12_COD_PROFISSIONAL")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ND12_DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "ND12_MATRICULA")
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "FKND12ND13_COD_PROFISSAO")
    private Profissao profissao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKND12ND01_COD_PESSOA")
    private Pessoa pessoa;

    public Profissional() {
        pessoa = new Pessoa();
    }
}
