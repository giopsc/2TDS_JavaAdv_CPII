package br.com.fiap.concessionaria.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class FabricanteRequest {

    @Size(min=3, max = 30, message = "Nome inválido!")
    @NotNull(message = "Nome não pode ser nulo!")
    private String nome;

    @Size(min=3, max = 30, message = "Nome fantasia inválido!")
    @NotNull(message = "Nome fantasia não pode ser nulo!")
    private String nomeFantasia;



}
