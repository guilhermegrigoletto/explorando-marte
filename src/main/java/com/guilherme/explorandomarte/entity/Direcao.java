package com.guilherme.explorandomarte.entity;

public enum Direcao {
    N("N", "W", "E"),
    E("E", "N", "S"),
    S("S", "E", "W"),
    W("W", "S", "N");

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
            if (direction.value.equals(position)) {
                return direction;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }

}