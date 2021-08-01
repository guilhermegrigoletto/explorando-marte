package com.guilherme.explorandomarte.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class MalhaRequest {

    @NotNull
    @PositiveOrZero
    private Integer x;
    @NotNull
    @PositiveOrZero
    private Integer y;

    public MalhaRequest(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
