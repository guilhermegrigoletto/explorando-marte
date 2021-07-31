package com.guilherme.explorandomarte.entity;

import com.guilherme.explorandomarte.domain.Malha;

import javax.persistence.*;
import java.awt.*;

@Entity
public class Sonda {

    public Sonda() {
    }

    public Sonda(int x, int y, Direcao direcao) {
        this.x = x;
        this.y = y;
        this.coordinate = new Point(x, y);
        this.direcao = direcao;
    }

    @Id
    @GeneratedValue
    private Long id;

    private int x;
    private int y;
    @Enumerated(EnumType.STRING)
    private Direcao direcao;
    private Point coordinate = new Point(0,0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direcao getDirecao() {
        return direcao;
    }


    public Sonda execute(String comando) {
        for (char command : comando.toCharArray()) {
            if (command == 'R') {
                direcao = direcao.right();
            } if (command == 'L') {
                direcao = direcao.left();
            } if (command == 'M') {
                coordinate = Malha.getCoordenadasPara(direcao, coordinate);
            }
        }
        return new Sonda(coordinate.x, coordinate.y, direcao);
    }
}
