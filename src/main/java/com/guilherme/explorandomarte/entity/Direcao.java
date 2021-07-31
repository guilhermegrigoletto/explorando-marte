package com.guilherme.explorandomarte.entity;

public enum Direcao {
    NORTH("N", "W", "E"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W"),
    WEST("W", "S", "N");

    private String value;
    private String left;
    private String right;

    Direcao(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Direcao right() {
        return getDirection(this.right);
    }

    public Direcao left() {
        return getDirection(this.left);
    }

    public static Direcao getDirection(String position) {
        for (Direcao direction : values()) {
            if (direction.value == position) {
                return direction;
            }
        }
        return null;
    }
}