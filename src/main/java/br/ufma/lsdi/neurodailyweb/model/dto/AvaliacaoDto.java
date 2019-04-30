package br.ufma.lsdi.neurodailyweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class AvaliacaoDto implements Serializable {

    private Long id;
    private Date dataAvaliacao;
    private String descricao;
    private String consideracao;
    private Integer nota;
    private Long profissionalId;
    private String profissional;
    private String profissao;
    private Long pacienteId;
}
