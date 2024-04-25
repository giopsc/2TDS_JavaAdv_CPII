package br.com.fiap.concessionaria.resource;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class FabricanteResource {

    private Long id;

    private String nome;

    private String nomeFantasia;



}
