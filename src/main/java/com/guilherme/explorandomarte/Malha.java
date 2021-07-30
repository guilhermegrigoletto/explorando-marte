package com.guilherme.explorandomarte;

import java.awt.*;

public class Malha {

    private static int X_MAXIMO = 5;
    private static int Y_MAXIMO = 5;
    
    public static void setMalha(int x, int y) {
        Malha.X_MAXIMO = x;
        Malha.Y_MAXIMO = y;
    }

    public static int getX() {
        return X_MAXIMO;
    }

    public static int getY() {
        return Y_MAXIMO;
    }

    public static Point getCoordenadasPara(Direcao direcao, Point coordinate) {
        int y = coordinate.y;
        int x = coordinate.x;

        if (direcao == Direcao.NORTH) {
            y = (y + 1) % Y_MAXIMO;
        }

        if (direcao == Direcao.EAST) {
            x = (x + 1) % X_MAXIMO;
        }

        if (direcao == Direcao.WEST) {
            if ( x > 0 ) {
                x = x - 1;
            } else {
                x = X_MAXIMO - 1;
            }
        }

        if (direcao == Direcao.SOUTH) {
            if ( y > 0 ) {
                y -= 1;
            } else {
                y = Y_MAXIMO - 1;
            }
        }
        return new Point(x, y);
    }
}
