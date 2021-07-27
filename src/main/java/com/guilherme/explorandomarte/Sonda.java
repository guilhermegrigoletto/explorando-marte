package com.guilherme.explorandomarte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sonda {

    public Sonda() {
    }

    public Sonda(int x, int y, String direcao) {
        this.x = x;
        this.y = y;
        this.direcao = direcao;
    }

    @Id
    @GeneratedValue
    private Long id;

    private int x;
    private int y;
    private String direcao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }
}
