package com.guilherme.explorandomarte.controller;

import com.guilherme.explorandomarte.entity.PosicaoSondaPassada;
import com.guilherme.explorandomarte.entity.Sonda;
import com.guilherme.explorandomarte.repository.PosicaoSondaPassadaRepository;
import com.guilherme.explorandomarte.repository.SondaRepository;
import com.guilherme.explorandomarte.request.SondaRequest;
import com.guilherme.explorandomarte.request.SondaResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(SondaController.SONDAS_ENDPOINT)
public class SondaController {
    public static final String SONDAS_ENDPOINT = "/api/sondas";

    @Autowired
    private SondaRepository sondaRepository;

    @Autowired
    private PosicaoSondaPassadaRepository posicaoSondaPassadaRepository;

    @Autowired
    private SondaResourceFactory sondaResourceFactory;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<SondaResource> criarSonda(@RequestBody @Valid SondaRequest sondaRequest, UriComponentsBuilder builder) {
        Sonda sonda = new Sonda(sondaRequest.getX(), sondaRequest.getY(), sondaRequest.getDirecao());
        sondaRepository.save(sonda);

        SondaResource resource = sondaResourceFactory.toResource(sonda);
        return new ResponseEntity<>(resource, getLocationHeader(builder, sonda), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/{comando}")
    public ResponseEntity<SondaResource> executarComando(@PathVariable("id") Long id, @PathVariable("comando") String comando){
        Optional<Sonda> sondaOptional = sondaRepository.findById(id);

        if(sondaOptional.isPresent()) {
            Sonda sonda = sondaOptional.get().executar(comando);
            sondaRepository.save(sonda);

            PosicaoSondaPassada posicaoSondaPassada = new PosicaoSondaPassada(sonda);
            posicaoSondaPassadaRepository.save(posicaoSondaPassada);

            SondaResource resource = sondaResourceFactory.toResource(sonda);
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SondaResource> getById(@PathVariable("id") Long id) {
        Optional<Sonda> sondaOptional = sondaRepository.findById(id);
        return sondaOptional.map(sonda ->  {
            SondaResource resource = sondaResourceFactory.toResource(sonda);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private HttpHeaders getLocationHeader(UriComponentsBuilder builder, Sonda sonda) {
        UriComponents uriComponents = builder.path(SONDAS_ENDPOINT + "/{id}").buildAndExpand(sonda.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return headers;
    }
}
