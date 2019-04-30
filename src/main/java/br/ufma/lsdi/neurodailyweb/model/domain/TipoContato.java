package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND08_TIPO_CONTATO")
@NoArgsConstructor
@SequenceGenerator(name = "ND08_TIPO_CONTATO_SEQ", sequenceName = "ND08_TIPO_CONTATO_SEQ", allocationSize = 1)
public class TipoContato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND08_TIPO_CONTATO_SEQ")
    @Column(name = "ND08_COD_TIPO_CONTATO")
    private Long id;

    @Column(name = "ND08_DESCRICAO")
    private String descricao;

    public TipoContato(Long id) {
        this.id = id;
    }
}
