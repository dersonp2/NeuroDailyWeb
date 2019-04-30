package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ND19_CONTATO" )
@NoArgsConstructor
@SequenceGenerator(name = "ND07_CONTATO_SEQ", sequenceName = "ND07_CONTATO_SEQ", allocationSize = 1)
public class PessoaContato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND07_CONTATO_SEQ")
    @Column (name = "ND07_COD_CONTATO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FKND19ND01_COD_PESSOA")
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FKND19ND07_COD_CONTATO")
    private Contato contato;

    public PessoaContato(Contato contato) {
        this.contato = contato;
    }
}
