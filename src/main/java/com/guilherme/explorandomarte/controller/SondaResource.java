package com.guilherme.explorandomarte.controller;

import com.guilherme.explorandomarte.entity.Direcao;
import org.springframework.hateoas.RepresentationModel;

public class SondaResource extends RepresentationModel<SondaResource> {

    private int x;
    private int y;
    private Direcao direcao;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }
}
