package com.guilherme.explorandomarte.domain;

import com.guilherme.explorandomarte.entity.Direcao;

import java.awt.*;

public class Malha {

    private static int xMaximo = 10;
    private static int yMaximo = 10;
    
    public static void setMalha(int x, int y) {
        Malha.xMaximo = x;
        Malha.yMaximo = y;
    }

    public static int getXMaximo() {
        return xMaximo;
    }

    public static int getYMaximo() {
        return yMaximo;
    }

    public static Point getCoordenadasPara(Direcao direcao, int x, int y) {
        if (direcao == Direcao.N) {
            y = (y + 1) % yMaximo;
        }

        if (direcao == Direcao.E) {
            x = (x + 1) % xMaximo;
        }

        if (direcao == Direcao.W) {
            if ( x > 0 ) {
                x = x - 1;
            } else {
                x = xMaximo - 1;
            }
        }

        if (direcao == Direcao.S) {
            if ( y > 0 ) {
                y -= 1;
            } else {
                y = yMaximo - 1;
            }
        }
        return new Point(x, y);
    }
}
