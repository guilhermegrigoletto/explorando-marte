package com.guilherme.explorandomarte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sondas")
public class SondasController {

    @Autowired
    private SondasRepository sondasRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> criarSonda(@RequestBody SondaRequest sondaRequest) {
        System.out.println(sondaRequest.getX() + ", pos: " + sondaRequest.getDirecao());
        if(sondaRequest.getDirecao() != null && sondaRequest.getX() != null && sondaRequest.getY() != null) {
            Sonda s = new Sonda(sondaRequest.getX(), sondaRequest.getY(), sondaRequest.getDirecao());
            sondasRepository.save(s);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/{comando}")
    public ResponseEntity<Sonda> movimentar(@PathVariable("id") Long id, @PathVariable("comando") String comando){
        System.out.println("Comando= "+comando);
        System.out.println("id = " + id);
        Optional<Sonda> sondaOptional = sondasRepository.findById(id);

        if(sondaOptional.isPresent()) {
            Sonda sondaNovaPosicao = sondaOptional.get().execute(comando);
            sondaNovaPosicao.setId(id);
            sondasRepository.save(sondaNovaPosicao);
            return ResponseEntity.ok(sondaNovaPosicao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sonda> getById(@PathVariable("id") Long id) {
        Optional<Sonda> sondaOptional = sondasRepository.findById(id);
        if(sondaOptional.isPresent()) {
            return new ResponseEntity<>(sondaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
