package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "ND10_PACIENTE")
@SequenceGenerator(name = "ND10_PACIENTE_SEQ", sequenceName = "ND10_PACIENTE_SEQ", allocationSize = 1)
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND10_PACIENTE_SEQ")
    @Column(name = "ND10_COD_PACIENTE")
    private Long id;

    @Column(name = "ND10_DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "ND10_MATRICULA")
    private String matricula;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKND10ND01_COD_PESSOA")
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKND10ND01_COD_PESSOA_RESPONSAVEL")
    private Pessoa responsavel;

//    public Paciente(Date dataCadastro, String matricula, Pessoa pessoa, Pessoa responsavel) {
//        this.dataCadastro = dataCadastro;
//        this.matricula = matricula;
//        this.pessoa = pessoa;
//        this.responsavel = responsavel;
//    }


    public Paciente() {
        pessoa = new Pessoa();
        responsavel = new Pessoa();
    }
}
