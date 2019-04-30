package br.ufma.lsdi.neurodailyweb.model.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND21_INSTITUICAO_ENDERECO" )
@SequenceGenerator(name = "ND21_INSTITUICAO_ENDERECO_SEQ", sequenceName = "ND21_INSTITUICAO_ENDERECO_SEQ", allocationSize = 1)
public class InstituicaoEndereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND21_INSTITUICAO_ENDERECO_SEQ")
    @Column (name = "ND21_COD_INSTITUICAO_ENDERECO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FKND21ND09_COD_ENDERECO")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "FKND21ND17_COD_INSTITUICAO")
    private Instituicao instituicao;
}
