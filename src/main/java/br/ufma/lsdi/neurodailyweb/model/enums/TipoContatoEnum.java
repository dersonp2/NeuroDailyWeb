package br.ufma.lsdi.neurodailyweb.model.enums;

import lombok.Getter;

public enum TipoContatoEnum {

    TELEFONE(1L),
    CELULAR(2L),
    EMAIL(3L);

    @Getter
    private Long value;

    TipoContatoEnum(Long value) {
        this.value = value;
    }
}
