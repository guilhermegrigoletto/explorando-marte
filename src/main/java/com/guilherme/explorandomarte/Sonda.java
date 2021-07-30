package com.guilherme.explorandomarte;

import javax.persistence.*;
import java.awt.*;

@Entity
public class Sonda {

    public Sonda() {
    }

    public Sonda(int x, int y, Direcao direcao) {
        this.x = x;
        this.y = y;
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
