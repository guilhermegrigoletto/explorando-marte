package com.guilherme.explorandomarte.entity;

import com.guilherme.explorandomarte.domain.Malha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SondaTest {

    private Sonda sondaInicial;

    @BeforeEach
    void setUp() {
        sondaInicial = new Sonda(0,0, Direcao.NORTH);
        Malha.setMalha(10,10);
    }

    @Test
    void givenL_shouldTurnLeft_thenFaceWest() {

        Sonda expected = new Sonda(0,0,Direcao.WEST);

        Sonda response = sondaInicial.executar("L");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void giveLL_shouldTurnLeftTwice_thenFaceSouth() {
        Sonda expected = new Sonda(0,0,Direcao.SOUTH);

        Sonda response = sondaInicial.executar("LL");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLLL_shouldTurnLeftThrice_thenFaceEast() {
        Sonda expected = new Sonda(0,0,Direcao.EAST);

        Sonda response = sondaInicial.executar("LLL");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLLLL_shouldTurnCompletely_thenFaceNorth() {
        Sonda expected = new Sonda(0,0,Direcao.NORTH);

        Sonda response = sondaInicial.executar("LLLL");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenR_shouldTurnRight_thenFaceEast() {
        Sonda expected = new Sonda(0,0,Direcao.EAST);

        Sonda response = sondaInicial.executar("R");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRR_shouldTurnRightTwice_thenFaceSouth() {
        Sonda expected = new Sonda(0,0,Direcao.SOUTH);

        Sonda response = sondaInicial.executar("RR");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRRR_shouldTurnRightThrice_thenFaceWest() {
        Sonda expected = new Sonda(0,0,Direcao.WEST);

        Sonda response = sondaInicial.executar("RRR");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRRRR_shouldTurnCompletely_thenFaceNorth() {
        Sonda expected = new Sonda(0,0,Direcao.NORTH);

        Sonda response = sondaInicial.executar("RRRR");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenM_shouldMoveOneNorth() {
        Sonda expected = new Sonda(0,1,Direcao.NORTH);

        Sonda response = sondaInicial.executar("M");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenMMM_shouldMoveThreeNorth() {
        Sonda expected = new Sonda(0,3,Direcao.NORTH);

        Sonda response = sondaInicial.executar("MMM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenMGridSize_shouldExceed_thenReturnToOrigin() {
        Sonda expected = new Sonda(0,0,Direcao.NORTH);

        Sonda response = sondaInicial.executar("MMMMMMMMMM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRotateMGridSize_shouldReturnToOrigin_thenFaceEast() {
        Sonda expected = new Sonda(0,0,Direcao.EAST);

        Sonda response = sondaInicial.executar("RMMMMMMMMMM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLM_shouldRotateLeftMoveOneToEdge_thenFaceWest() {
        Sonda expected = new Sonda(9,0,Direcao.WEST);

        Sonda response = sondaInicial.executar("LM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLLM_shouldRoateToSouthMoveToTheEdge_thenFaceSouth() {
        Sonda expected = new Sonda(0,9,Direcao.SOUTH);

        Sonda response = sondaInicial.executar("LLM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }
}