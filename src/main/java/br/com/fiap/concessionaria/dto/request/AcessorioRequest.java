package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AcessorioRequest {

    @Size(min=3, max = 255, message = "Nome inválido!")
    @NotNull(message = "Nome não pode ser nulo!")
    private String nome;

    @Positive
    @NotNull(message = "Preço não pode ser nulo!")
    private Double preco;

}
