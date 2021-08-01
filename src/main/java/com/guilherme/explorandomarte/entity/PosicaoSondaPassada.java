package com.guilherme.explorandomarte.entity;

import javax.persistence.*;

@Entity
public class PosicaoSondaPassada {

    @Id
    @GeneratedValue
    private Long id;
    private Long sondaId;
    private int x;
    private int y;
    @Enumerated(EnumType.STRING)
    private Direcao direcao;

    public PosicaoSondaPassada() {
    }

    public PosicaoSondaPassada(Sonda sonda) {
        this.sondaId = sonda.getId();
        this.x = sonda.getX();
        this.y = sonda.getY();
        this.direcao = sonda.getDirecao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSondaId() {
        return sondaId;
    }

    public void setSondaId(Long sondaId) {
        this.sondaId = sondaId;
    }

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
