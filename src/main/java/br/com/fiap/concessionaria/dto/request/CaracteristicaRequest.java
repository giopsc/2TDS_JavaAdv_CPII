package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CaracteristicaRequest {


    @Size(min=3, max = 30, message = "Nome inválido!")
    @NotNull(message = "Nome não pode ser nulo!")
    //30 digitos
    private String nome;

    @Size(min=3, max = 20, message = "Descrição inválida!")
    @NotNull(message = "Descrição não pode ser nulo!")
    //20 digitos
    private String descricao;


    @NotNull(message = "Veiculo não pode ser nulo!")
    private AbstractRequest veiculo;


}
