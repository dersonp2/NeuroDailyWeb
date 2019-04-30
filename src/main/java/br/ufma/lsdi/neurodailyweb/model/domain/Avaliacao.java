package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "ND15_AVALIACAO")
@SequenceGenerator(name = "ND15_AVALIACAO_SEQ", sequenceName = "ND15_AVALIACAO_SEQ", allocationSize = 1)
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 7230655857148065753L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND15_AVALIACAO_SEQ")
    @Column(name = "ND15_COD_AVALIACAO")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ND15_DATA_AVALIACAO")
    private Date dataAvaliacao;

    @Column(name = "ND15_DESCRICAO")
    private String descricao;

    @Column(name = "ND15_CONSIDERACAO")
    private String consideracao;

    @Column(name = "ND15_NOTA")
    private Integer nota;

//    @ManyToOne
//    @JoinColumn(name = "FKND15ND16_COD_NOTA_AVALIACAO")
//    private NotaAvaliacao notaAvaliacao;

    @ManyToOne
    @JoinColumn(name = "FKND15ND12_COD_PROFISSIONAL")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "FKND15ND10_COD_PACIENTE")
    private Paciente paciente;

//    @ManyToOne
//    @JoinColumn(name = "FKND15ND21_COD_INSTITUICAO_ENDERECO")
//    private InstituicaoEndereco instituicaoEndereco;
}
