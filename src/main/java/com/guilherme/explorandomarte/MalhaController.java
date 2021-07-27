package com.guilherme.explorandomarte;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/malhas")
public class MalhaController {

    public static int xMaximo = 0;
    public static int yMaximo = 0;

    @PostMapping(consumes = "application/json")
    public void defineMalha(@RequestBody Malha malha){
        xMaximo = malha.getX();
        yMaximo = malha.getY();

        System.out.println("X : " + xMaximo);
        System.out.println("Y : " + yMaximo);
    }

}
