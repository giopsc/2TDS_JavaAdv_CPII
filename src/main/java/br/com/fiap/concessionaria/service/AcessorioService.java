package br.com.fiap.concessionaria.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class AcessorioService {

    private Long id;

    private String nome;

    private Double preco;

}
