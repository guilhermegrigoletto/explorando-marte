package com.guilherme.explorandomarte.controller;

import com.guilherme.explorandomarte.domain.Malha;
import com.guilherme.explorandomarte.request.MalhaRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/malhas")
public class MalhaController {

    Logger logger = Logger.getLogger(MalhaController.class.getName());

    @PutMapping(consumes = "application/json")
    public void defineMalha(@RequestBody @Valid MalhaRequest malha){
        logger.info("Malha alterada para: " + malha.getX() + "x" + malha.getY());
        Malha.setMalha(malha.getX(), malha.getY());
    }
}
