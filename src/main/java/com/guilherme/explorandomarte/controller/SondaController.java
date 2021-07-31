package com.guilherme.explorandomarte.controller;

import com.guilherme.explorandomarte.entity.PosicaoExecutadaSonda;
import com.guilherme.explorandomarte.entity.Sonda;
import com.guilherme.explorandomarte.repository.PosicaoExecutadaSondaRepository;
import com.guilherme.explorandomarte.repository.SondaRepository;
import com.guilherme.explorandomarte.request.SondaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping(SondaController.SONDAS_ENDPOINT)
public class SondaController {
    public static final String SONDAS_ENDPOINT = "/api/sondas";

    @Autowired
    private SondaRepository sondaRepository;

    @Autowired
    private PosicaoExecutadaSondaRepository posicaoExecutadaSondaRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Sonda> criarSonda(@RequestBody SondaRequest sondaRequest, UriComponentsBuilder builder) {
        if(sondaRequest.getDirecao() != null && sondaRequest.getX() != null && sondaRequest.getY() != null) {
            Sonda s = new Sonda(sondaRequest.getX(), sondaRequest.getY(), sondaRequest.getDirecao());
            sondaRepository.save(s);


            UriComponents uriComponents = builder.path(SONDAS_ENDPOINT + "/{id}").buildAndExpand(s.getId());

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());
            return new ResponseEntity<>(s, headers, HttpStatus.CREATED);

        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/{comando}")
    public ResponseEntity<Sonda> movimentar(@PathVariable("id") Long id, @PathVariable("comando") String comando){
        Optional<Sonda> sondaOptional = sondaRepository.findById(id);

        if(sondaOptional.isPresent()) {
            Sonda sondaNovaPosicao = sondaOptional.get().execute(comando);
            sondaNovaPosicao.setId(id);
            sondaRepository.save(sondaNovaPosicao);

            PosicaoExecutadaSonda posicaoExecutadaSonda = new PosicaoExecutadaSonda(sondaNovaPosicao);
            posicaoExecutadaSondaRepository.save(posicaoExecutadaSonda);

            return ResponseEntity.ok(sondaNovaPosicao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sonda> getById(@PathVariable("id") Long id) {
        Optional<Sonda> sondaOptional = sondaRepository.findById(id);
        return sondaOptional.map(sonda -> new ResponseEntity<>(sonda, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
