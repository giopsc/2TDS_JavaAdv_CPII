package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AbstractRequest {

    @Positive
    @NotNull(message = "O id é obrigatório")
    Long id;
}
