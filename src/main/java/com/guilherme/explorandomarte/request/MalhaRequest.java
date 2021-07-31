package com.guilherme.explorandomarte.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class MalhaRequest {

    @NotNull(message = "X deve ser preenchido ao definir malha")
    @PositiveOrZero
    private Integer x;
    @NotNull(message = "Y deve ser preenchido ao definir malha")
    @PositiveOrZero
    private Integer y;

    public MalhaRequest(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

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
}
