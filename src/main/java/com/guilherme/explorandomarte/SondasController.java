package com.guilherme.explorandomarte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sondas")
public class SondasController {

    @Autowired
    private SondasRepository sondasRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> criarSonda(@RequestBody SondaRequest sondaRequest) {
        System.out.println(sondaRequest.getX());
        if(sondaRequest.getDirecao() != null && sondaRequest.getX() != null && sondaRequest.getY() != null) {
            Sonda s = new Sonda(sondaRequest.getX(), sondaRequest.getY(), sondaRequest.getDirecao());
            sondasRepository.save(s);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/{comando}")
    public void movimentar(@PathVariable("id") Integer id, @PathVariable("comando") String comando){
        System.out.println("Comando= "+comando);
        System.out.println("id = " + id);

    }
}
