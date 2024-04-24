package br.com.fiap.concessionaria.service;

import br.com.fiap.concessionaria.dto.request.LojaRequest;
import br.com.fiap.concessionaria.dto.response.LojaResponse;
import br.com.fiap.concessionaria.entity.Loja;
import br.com.fiap.concessionaria.repository.LojaRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class LojaService implements ServiceDTO<Loja, LojaRequest, LojaResponse>{

    @Autowired
    private LojaRepository repo;

    @Autowired
    private


    @Override
    public Collection<Loja> findAll(Example<Loja> example) {
        return null;
    }

    @Override
    public Loja findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Loja save(Loja e) {
        return repo.save(e);
    }

    @Override
    public Loja toEntity(LojaRequest dto) {
        return null;
    }

    @Override
    public LojaResponse toResponse(Loja e) {
        return null;
    }
}
