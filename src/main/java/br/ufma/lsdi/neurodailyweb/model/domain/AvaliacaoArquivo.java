package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND15_AVALIACAO" )
@SequenceGenerator(name = "ND15_AVALIACAO_SEQ", sequenceName = "ND15_AVALIACAO_SEQ", allocationSize = 1)
public class AvaliacaoArquivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND15_AVALIACAO_SEQ")
    @Column (name = "ND15_COD_AVALIACAO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FKND25ND22_COD_ARQUIVO")
    private Arquivo arquivo;

    @OneToOne
    @JoinColumn(name = "FKND25ND15_COD_AVALIACAO")
    private Avaliacao avaliacao;
}
