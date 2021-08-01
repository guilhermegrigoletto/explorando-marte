package com.guilherme.explorandomarte.request;

import com.guilherme.explorandomarte.entity.Direcao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class SondaRequest {

    @NotNull
    @PositiveOrZero
    private Integer x;
    @NotNull
    @PositiveOrZero
    private Integer y;
    @NotNull
    private Direcao direcao;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }
}
