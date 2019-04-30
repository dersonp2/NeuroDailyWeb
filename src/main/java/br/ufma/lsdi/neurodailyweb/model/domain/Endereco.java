package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ND09_ENDERECO")
@SequenceGenerator(name = "ND09_ENDERECO_SEQ", sequenceName = "ND09_ENDERECO_SEQ", allocationSize = 1)
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND09_ENDERECO_SEQ")
    @Column(name = "ND09_COD_ENDERECO")
    private Long id;

    @Column(name = "ND09_RUA")
    private String rua;

    @Column(name = "ND09_BAIRRO")
    private String bairro;

    @Column(name = "ND09_CEP")
    private String cep;

    @Column(name = "ND09_COMPLEMENTO")
    private String complemento;

    @Column(name = "ND09_NUMERO")
    private String numero;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "FKND09ND05_COD_CIDADE")
    private Cidade cidade;

    public Endereco() {
        this.cidade = new Cidade();
    }
}
