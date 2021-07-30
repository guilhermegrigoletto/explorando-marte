package com.guilherme.explorandomarte;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/malhas")
/*
    Comentarios da classe
 */
public class MalhasController {

    @PostMapping(consumes = "application/json")
    public void defineMalha(@RequestBody MalhaRequest malha){
        Malha.setMalha(malha.getX(), malha.getY());
    }

}
