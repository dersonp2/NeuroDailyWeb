package br.ufma.lsdi.neurodailyweb.model.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND22_ARQUIVO" )
@SequenceGenerator(name = "ND22_ARQUIVO_SEQ", sequenceName = "ND22_ARQUIVO_SEQ", allocationSize = 1)
public class Arquivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND22_ARQUIVO_SEQ")
    @Column (name = "ND22_COD_ARQUIVO")
    private Long id;

    @Column (name = "ND22_PATH")
    private String path;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column (name = "ND22_DATA_CADASTRO")
    private String dataCadastro;

    @ManyToOne
    @JoinColumn (name = "FKND22ND24_COD_TIPO_ARQUIVO")
    private TipoArquivo tipoArquivo;

}
