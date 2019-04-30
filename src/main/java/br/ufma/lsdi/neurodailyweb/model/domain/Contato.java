package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ND07_CONTATO" )
@NoArgsConstructor
@SequenceGenerator(name = "ND07_CONTATO_SEQ", sequenceName = "ND07_CONTATO_SEQ", allocationSize = 1)
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND07_CONTATO_SEQ")
    @Column (name = "ND07_COD_CONTATO")
    private Long id;

    @Column (name = "ND07_DESCRICAO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "FKND07ND08_COD_TIPO_CONTATO")
    private TipoContato tipoContato;

    public Contato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }
}
