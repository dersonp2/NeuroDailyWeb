package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND11_SEXO")
@NoArgsConstructor
@SequenceGenerator(name = "ND11_SEXO_SEQ", sequenceName = "ND11_SEXO_SEQ", allocationSize = 1)
public class Sexo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND11_SEXO_SEQ")
    @Column(name = "ND11_COD_SEXO")
    private Long id;

    @Column(name = "ND11_DESCRICAO")
    private String descricao;

    public Sexo(Long id) {
        this.id = id;
    }
}
