package br.ufma.lsdi.neurodailyweb.model.enums;

import lombok.Getter;

public enum EstadoEnum {

    MARANHAO(10L);

    @Getter
    private Long value;

    EstadoEnum(Long value) {
        this.value = value;
    }
}
