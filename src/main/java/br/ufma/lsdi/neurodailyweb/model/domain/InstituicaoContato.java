package br.ufma.lsdi.neurodailyweb.model.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND20_INSTITUICAO_CONTATO" )
@SequenceGenerator(name = "ND20_INSTITUICAO_CONTATO_SEQ", sequenceName = "ND20_INSTITUICAO_CONTATO_SEQ", allocationSize = 1)
public class InstituicaoContato implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND20_INSTITUICAO_CONTATO_SEQ")
    @Column (name = "ND21_COD_INSTITUICAO_CONTATO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FKND20ND07_COD_CONTATO")
    private Contato contato;

    @OneToOne
    @JoinColumn(name = "FKND20ND17_COD_INSTITUICAO")
    private Instituicao instituicao;
}
