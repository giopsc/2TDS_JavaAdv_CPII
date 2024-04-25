package br.com.fiap.concessionaria.service;


import br.com.fiap.concessionaria.dto.request.VeiculoRequest;
import br.com.fiap.concessionaria.dto.response.VeiculoResponse;
import br.com.fiap.concessionaria.entity.Fabricante;
import br.com.fiap.concessionaria.entity.TipoVeiculo;
import br.com.fiap.concessionaria.entity.Veiculo;
import br.com.fiap.concessionaria.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, VeiculoRequest, VeiculoResponse>{

    @Autowired
    private TipoVeiculoService tipoVeiculoService;

    @Autowired
    private FabricanteService fabricanteService;

    @Autowired
    private VeiculoRepository repo;
    @Override
    public Collection<Veiculo> findAll(Example<Veiculo> example) {

        return repo.findAll(example);

    }

    @Override
    public Veiculo findById(Long id) {

        return repo.findById(id).orElse(null);

    }

    @Override
    public Veiculo save(Veiculo e) {

        return repo.save(e);

    }

    @Override
    public Veiculo toEntity(VeiculoRequest dto) {

        Fabricante fabricante = fabricanteService.findById(dto.fabricante().id());
        TipoVeiculo tipoVeiculo = tipoVeiculoService.findById(dto.fabricante().id());
        return Veiculo.builder()
                .nome(dto.nome())
                .cor(dto.cor())
                .preco(dto.preco())
                .tipo(tipoVeiculo)
                .cilindradas(dto.cilindradas())
                .anoDeFabricacao(dto.anoDeFabricacao())
                .palavraDeEfeito(dto.palavraDeEfeito())
                .modelo(dto.modelo())
                .fabricante(fabricante)
                .build();
    }

    @Override
    public VeiculoResponse toResponse(Veiculo e) {

        return VeiculoResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .cor(e.getCor())
                .preco(e.getPreco())
                .cilindradas(e.getCilindradas())
                .anoDeFabricacao(e.getAnoDeFabricacao())
                .palavraDeEfeito(e.getPalavraDeEfeito())
                .modelo(e.getModelo())
                .fabricante(fabricanteService.toResponse(e.getFabricante()))
                .tipo(tipoVeiculoService.toResponse(e.getTipo()))
                .build();
    }
}
