package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "ND01_PESSOA")
@SequenceGenerator(name = "ND01_PESSOA_SEQ", sequenceName = "ND01_PESSOA_SEQ", allocationSize = 1)
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND01_PESSOA_SEQ")
    @Column(name = "ND01_COD_PESSOA")
    private Long id;

    @Column(name = "ND01_NOME")
    private String nome;

    @Column(name = "ND01_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Column(name = "ND01_CELULAR")
    private String celular;

    @Column(name = "ND01_TELEFONE")
    private String telefone;

    @Column(name = "ND01_EMAIL")
    private String email;

    @OneToOne
    @JoinColumn(name = "FKND01ND11_COD_SEXO")
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKND01ND02_COD_DOCUMENTO_PESSOAL")
    private DocumentoPessoal documentoPessoal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKND01ND09_COD_ENDERECO")
    private Endereco endereco;

    public Pessoa() {
        this.sexo = new Sexo();
        this.documentoPessoal = new DocumentoPessoal();
    }
}
