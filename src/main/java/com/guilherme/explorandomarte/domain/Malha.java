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

    public static Point getCoordenadasPara(Direcao direcao, Point coordinate) {
        int y = coordinate.y;
        int x = coordinate.x;

        if (direcao == Direcao.NORTH) {
            y = (y + 1) % yMaximo;
        }

        if (direcao == Direcao.EAST) {
            x = (x + 1) % xMaximo;
        }

        if (direcao == Direcao.WEST) {
            if ( x > 0 ) {
                x = x - 1;
            } else {
                x = xMaximo - 1;
            }
        }

        if (direcao == Direcao.SOUTH) {
            if ( y > 0 ) {
                y -= 1;
            } else {
                y = yMaximo - 1;
            }
        }
        return new Point(x, y);
    }
}
