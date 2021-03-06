package com.guilherme.explorandomarte.request;

import com.guilherme.explorandomarte.entity.Direcao;
import io.swagger.v3.oas.annotations.Parameter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class SondaRequest {

    @NotNull
    @PositiveOrZero
    @Parameter(description = "Posicao inicial X da Sonda")
    private Integer x;

    @NotNull
    @PositiveOrZero
    @Parameter(description = "Posicao inicial Y da Sonda")
    private Integer y;

    @NotNull
    @Parameter(description = "Direcao inicial da Sonda. Direcao representada pelas letras N, S, W, E da rosa dos ventos")
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
