package br.ufma.lsdi.neurodailyweb.model.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND16_NOTA_AVALIACAO" )
@SequenceGenerator(name = "ND16_NOTA_AVALIACAO_SEQ", sequenceName = "ND16_NOTA_AVALIACAO_SEQ", allocationSize = 1)
public class NotaAvaliacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND16_NOTA_AVALIACAO_SEQ")
    @Column (name = "ND16_COD_NOTA_AVALIACAO")
    private Long id;

    @Column (name = "ND16_NUMERO")
    private int numero;
}
