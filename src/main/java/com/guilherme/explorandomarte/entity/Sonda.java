package com.guilherme.explorandomarte.entity;

import com.guilherme.explorandomarte.domain.Malha;

import javax.persistence.*;
import java.awt.*;

@Entity
public class Sonda {

    private static final char COMANDO_DIREITA = 'R';
    private static final char COMANDO_ESQUERDA = 'L';
    private static final char COMANDO_MOVER = 'M';

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


    public Sonda executar(String comando) {
        for (char command : comando.toCharArray()) {
            if (command == COMANDO_DIREITA) {
                direcao = direcao.right();
            } if (command == COMANDO_ESQUERDA) {
                direcao = direcao.left();
            } if (command == COMANDO_MOVER) {
                Point coordinate = Malha.getCoordenadasPara(direcao, x, y);
                this.x = coordinate.x;
                this.y = coordinate.y;
            }
        }
        return new Sonda(x, y, direcao);
    }
}
