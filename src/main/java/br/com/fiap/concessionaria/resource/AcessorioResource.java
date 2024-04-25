package br.com.fiap.concessionaria.resource;


import br.com.fiap.concessionaria.dto.request.AcessorioRequest;
import br.com.fiap.concessionaria.dto.response.AcessorioResponse;
import br.com.fiap.concessionaria.entity.Acessorio;
import br.com.fiap.concessionaria.entity.Fabricante;
import br.com.fiap.concessionaria.entity.TipoVeiculo;
import br.com.fiap.concessionaria.entity.Veiculo;
import br.com.fiap.concessionaria.service.AcessorioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.Year;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/acessorio")
public class AcessorioResource implements ResourceDTO<Acessorio, AcessorioRequest, AcessorioResponse>{

    @Autowired
    private AcessorioService service;

    @GetMapping
    public ResponseEntity<Collection<AcessorioResponse>> findAll (
            @RequestParam(name = "veiculo.nome", required = false) String veiculoNome,
            @RequestParam(name = "veiculo.anoDeFabricacao", required = false) Year veiculoAnoDeFabricacao,
            @RequestParam(name = "veiculo.cor", required = false) String veiculoCor,
            @RequestParam(name = "veiculo.preco", required = false) Double veiculoPreco ,
            @RequestParam(name = "veiculo.cilindradas", required = false) Short veiculoCilindradas,
            @RequestParam(name = "veiculo.modelo", required = false) String veiculoModelo,
            @RequestParam(name = "veiculo.palavraDeEfeito", required = false) String veiculoPalavraDeEfeito,
            @RequestParam(name = "veiculo.fabricante", required = false) Fabricante veiculoFabricante,
            @RequestParam(name = "veiculo.tipoVeiculo", required = false) TipoVeiculo veiculoTipoVeiculo,
            @RequestParam(name = "veiculo.acessorios", required = false) Set<Acessorio> veiculoAcessorios,
            @RequestParam(name = "acessorio.nome", required = false) String nomeAcessorio,
            @RequestParam(name = "acessorio.preco", required = false) Double precoAcessorio
    ) {

        var veiculo = Veiculo.builder()
                .nome(veiculoNome)
                .anoDeFabricacao(veiculoAnoDeFabricacao)
                .cor(veiculoCor)
                .preco(veiculoPreco)
                .cilindradas(veiculoCilindradas)
                .modelo(veiculoModelo)
                .palavraDeEfeito(veiculoPalavraDeEfeito)
                .fabricante(veiculoFabricante)
                .tipo(veiculoTipoVeiculo)
                .acessorios(veiculoAcessorios)
                .build();

        var acessorio = Acessorio.builder()
                .nome(nomeAcessorio)
                .preco(precoAcessorio)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Acessorio> example = Example.of(acessorio, matcher);
        Collection<Acessorio> acessorios = service.findAll(example);

        var response = acessorios.stream().map(service::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<AcessorioResponse> findById( @PathVariable Long id) {
        var entity = service.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<AcessorioResponse> save( @RequestBody @Valid AcessorioRequest r) {
        var entity = service.toEntity(r);
        var saved = service.save(entity);
        var response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);

    }

}
