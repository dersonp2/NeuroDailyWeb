package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table (name = "ND05_CIDADE")
@NoArgsConstructor
@SequenceGenerator(name = "ND05_CIDADE_SEQ", sequenceName = "ND05_CIDADE_SEQ", allocationSize = 1)
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND05_CIDADE_SEQ")
    @Column (name = "ND05_COD_CIDADE")
    private Long id;


    @Column (name = "ND05_DESCRICAO")
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "FKND05ND04_COD_ESTADO")
    private Estado estado;

    public Cidade(Long id) {
        this.id = id;
    }
}
