package br.com.fiap.concessionaria.resource;


import br.com.fiap.concessionaria.dto.request.AcessorioRequest;
import br.com.fiap.concessionaria.dto.response.AcessorioResponse;
import br.com.fiap.concessionaria.entity.Acessorio;
import br.com.fiap.concessionaria.service.AcessorioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/acessorio")
public class AcessorioResource implements ResourceDTO<Acessorio, AcessorioRequest, AcessorioResponse>{

    @Autowired
    private AcessorioService service;

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<AcessorioResponse> findById(Long id) {
        Acessorio acessorio = service.findById(id);
        return service.toResponse(acessorio);
    }

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<AcessorioResponse> save(AcessorioRequest r) {
        if (Objects.isNull(r)) return null;
        Acessorio save = service.save(service.toEntity(r));
        return service.toResponse(save);
    }

}
