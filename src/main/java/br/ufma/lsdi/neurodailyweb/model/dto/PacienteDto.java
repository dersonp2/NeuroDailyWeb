package br.ufma.lsdi.neurodailyweb.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class PacienteDto implements Serializable {

    private Long id;
    private String dataCadastro;
    private String matricula;

    private Long idPessoaPaciente;
    private String nomePaciente;
    private Date nascimentoPaciente;
    private Long sexoPacienteId;
    private Long idDocumentoPaciente;
    private String cpfPaciente;
    private String rgPaciente;
    private String susPaciente;
    private Date dataRgPaciente;

    private Long idPessoaResponsavel;
    private String nomeResponsavel;
    private Date nascimentoResponsavel;
    private Long sexoResponsavelId;
    private Long idDocumentoResponsavel;
    private String cpfResponsavel;
    private String rgResponsavel;
    private Date dataRgResponsavel;
    private Long idEndereco;
    private String rua;
    private String bairro;
    private String cep;
    private String complemento;
    private String numero;
    private Long idCidade;

    private Long idCelular;
    private String celular;

    private Long idTelefoner;
    private String telefone;

    private Long idEmail;
    private String email;

    public PacienteDto(Long id, String dataCadastro, String matricula, Long idPessoaPaciente, String nomePaciente,
                       Date nascimentoPaciente, Long sexoPacienteId, Long idDocumentoPaciente, String cpfPaciente,
                       String rgPaciente, String susPaciente, Date dataRgPaciente, Long idPessoaResponsavel,
                       String nomeResponsavel, Date nascimentoResponsavel, Long sexoResponsavelId,
                       Long idDocumentoResponsavel, String cpfResponsavel, String rgResponsavel, Date dataRgResponsavel,
                       Long idEndereco, String rua, String bairro, String cep, String complemento, String numero,
                       Long idCidade) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.matricula = matricula;
        this.idPessoaPaciente = idPessoaPaciente;
        this.nomePaciente = nomePaciente;
        this.nascimentoPaciente = nascimentoPaciente;
        this.sexoPacienteId = sexoPacienteId;
        this.idDocumentoPaciente = idDocumentoPaciente;
        this.cpfPaciente = cpfPaciente;
        this.rgPaciente = rgPaciente;
        this.susPaciente = susPaciente;
        this.dataRgPaciente = dataRgPaciente;
        this.idPessoaResponsavel = idPessoaResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.nascimentoResponsavel = nascimentoResponsavel;
        this.sexoResponsavelId = sexoResponsavelId;
        this.idDocumentoResponsavel = idDocumentoResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.rgResponsavel = rgResponsavel;
        this.dataRgResponsavel = dataRgResponsavel;
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.idCidade = idCidade;
    }
}
