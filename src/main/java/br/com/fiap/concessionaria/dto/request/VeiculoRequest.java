package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;



public class VeiculoRequest {

    @Size(min=3, max = 30, message = "Nome inválido!")
    @NotNull(message = "Nome não pode ser nulo!")
    private String nome;

    @Size(max=4, message = "Ano inválido")
    @NotNull(message = "ano de fabricação não pode ser nulo!")
    private Year anoDeFabricacao;

    @Size(max=10, message = "cor inválida")
    @NotNull(message = "cor não pode ser nulo!")
    private String cor;


    @Positive
    @NotNull(message = "cor não pode ser nulo!")
    private Double preco;


    @Positive
    @NotNull(message = "cilindradas não pode ser nulo!")
    private Short cilindradas;


    @Size(min= 3, max=15, message = "modelo inválido")
    @NotNull(message = "modelo não pode ser nulo!")
    private String modelo;


    @Size(min= 3, max=15, message = "palavra de efeito inválido")
    @NotNull(message = "palavra de efeito não pode ser nulo!")
    //15 digitos
    private String palavraDeEfeito;


    @NotNull(message = "palavra de efeito não pode ser nulo!")
    private AbstractRequest fabricante;


    @NotNull(message = "palavra de efeito não pode ser nulo!")
    private AbstractRequest tipo;


}
