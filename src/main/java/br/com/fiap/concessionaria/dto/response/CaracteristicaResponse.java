package br.com.fiap.concessionaria.dto.response;


import lombok.Builder;
@Builder
public record CaracteristicaResponse (

    Long id,

    //30 digitos
    String nome,

    //20 digitos
    String descricao,

    VeiculoResponse veiculo

) {

}
