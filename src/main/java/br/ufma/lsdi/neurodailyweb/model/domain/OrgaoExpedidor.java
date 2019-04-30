package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "ND06_ORGAO_EXPEDIDOR")
@Data
@SequenceGenerator(name = "ND06_ORGAO_EXPEDIDOR_SEQ", sequenceName = "ND06_ORGAO_EXPEDIDOR_SEQ", allocationSize = 1)
public class OrgaoExpedidor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND06_ORGAO_EXPEDIDOR_SEQ")
    @Column (name = "ND06_COD_ORGAO_EXPEDIDOR")
    private Long id;

    @Column (name = "ND06_DESCRICAO")
    private String descricao;

    @Column (name = "ND06_SIGLA")
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "FKND06ND04_COD_ESTADO")
    private Estado estado;
}
