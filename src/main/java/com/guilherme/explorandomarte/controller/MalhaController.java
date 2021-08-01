package com.guilherme.explorandomarte.controller;

import com.guilherme.explorandomarte.domain.Malha;
import com.guilherme.explorandomarte.request.MalhaRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/malhas")
public class MalhaController {

    Logger logger = Logger.getLogger(MalhaController.class.getName());

    @Operation(description = "Permite modificar as coordenadas da malha do planalto representado pelos eixos X e Y")
    @PutMapping(consumes = "application/json")
    public void defineMalha(@RequestBody @Valid MalhaRequest malha){
        logger.info("Malha alterada para: " + malha.getX() + "x" + malha.getY());
        Malha.setMalha(malha.getX(), malha.getY());
    }
}
