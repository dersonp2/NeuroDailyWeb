package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND17_INSTITUICAO" )
@SequenceGenerator(name = "ND17_INSTITUICAO_SEQ", sequenceName = "ND17_INSTITUICAO_SEQ", allocationSize = 1)
public class Instituicao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND17_INSTITUICAO_SEQ")
    @Column (name = "ND17_COD_INSTITUICAO")
    private Long id;

    @Column (name = "ND17_NOME")
    private String nome;

    @Column (name = "ND17_NOME_FANTASIA")
    private String nomeFantasia;

    @Column (name = "ND17_CNPJ")
    private String cnpj;
}
