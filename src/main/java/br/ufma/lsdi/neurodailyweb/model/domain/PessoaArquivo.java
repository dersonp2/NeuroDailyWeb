package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND25_PESSOA_ARQUIVO" )
@SequenceGenerator(name = "ND25_PESSOA_ARQUIVO_SEQ", sequenceName = "ND25_PESSOA_ARQUIVO_SEQ", allocationSize = 1)
public class PessoaArquivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND25_PESSOA_ARQUIVO_SEQ")
    @Column (name = "ND25_COD_ARQUIVO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FKND25ND22_COD_ARQUIVO")
    private Arquivo arquivo;

    @OneToOne
    @JoinColumn(name = "FKND25ND01_COD_PESSOA")
    private Pessoa pessoa;
}
