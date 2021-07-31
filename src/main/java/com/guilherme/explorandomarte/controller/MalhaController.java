package com.guilherme.explorandomarte.controller;

import com.guilherme.explorandomarte.domain.Malha;
import com.guilherme.explorandomarte.request.MalhaRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/malhas")
public class MalhaController {

    @PutMapping(consumes = "application/json")
    public void defineMalha(@RequestBody @Valid MalhaRequest malha){
        Malha.setMalha(malha.getX(), malha.getY());
    }

}
