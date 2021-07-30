package com.guilherme.explorandomarte;

/*
    Entrada de dados para uma sonda
 */
public class SondaRequest {

    private Integer x;
    private Integer y;
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
