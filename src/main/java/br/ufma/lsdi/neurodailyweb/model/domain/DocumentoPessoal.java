package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "ND02_DOCUMENTO_PESSOAL")
@NoArgsConstructor
@SequenceGenerator(name = "ND02_DOCUMENTO_PESSOAL_SEQ", sequenceName = "ND02_DOCUMENTO_PESSOAL_SEQ", allocationSize = 1)
public class DocumentoPessoal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND02_DOCUMENTO_PESSOAL_SEQ")
    @Column(name = "ND02_COD_DOCUMENTO_PESSOAL")
    private Long id;

    @Column(name = "ND02_CPF")
    private String cpf;

    @Column(name = "ND02_RG")
    private String rg;

    @Column(name = "ND02_SUS")
    private String sus;

    @Column(name = "ND02_DATA_EXPEDICAO")
    @Temporal(TemporalType.DATE)
    private Date data;

}
