package com.guilherme.explorandomarte.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SondaTest {

    private Sonda sonda;

    @BeforeEach
    void setUp() {
        sonda = new Sonda(0,0, Direcao.NORTH);
    }

    @Test
    void givenL_shouldTurnLeft_thenFaceWest() {
        Sonda expected = new Sonda(0,0,Direcao.WEST);

        Sonda response = sonda.execute("L");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void giveLL_shouldTurnLeftTwice_thenFaceSouth() {
        Sonda expected = new Sonda(0,0,Direcao.SOUTH);

        Sonda response = sonda.execute("LL");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLLL_shouldTurnLeftThrice_thenFaceEast() {
        Sonda expected = new Sonda(0,0,Direcao.EAST);

        Sonda response = sonda.execute("LLL");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLLLL_shouldTurnCompletely_thenFaceNorth() {
        Sonda expected = new Sonda(0,0,Direcao.NORTH);

        Sonda response = sonda.execute("LLLL");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenR_shouldTurnRight_thenFaceEast() {
        Sonda expected = new Sonda(0,0,Direcao.EAST);

        Sonda response = sonda.execute("R");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRR_shouldTurnRightTwice_thenFaceSouth() {
        Sonda expected = new Sonda(0,0,Direcao.SOUTH);

        Sonda response = sonda.execute("RR");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRRR_shouldTurnRightThrice_thenFaceWest() {
        Sonda expected = new Sonda(0,0,Direcao.WEST);

        Sonda response = sonda.execute("RRR");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRRRR_shouldTurnCompletely_thenFaceNorth() {
        Sonda expected = new Sonda(0,0,Direcao.NORTH);

        Sonda response = sonda.execute("RRRR");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenM_shouldMoveOneNorth() {
        Sonda expected = new Sonda(0,1,Direcao.NORTH);

        Sonda response = sonda.execute("M");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenMMM_shouldMoveThreeNorth() {
        Sonda expected = new Sonda(0,3,Direcao.NORTH);

        Sonda response = sonda.execute("MMM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenMGridSize_shouldExceed_thenReturnToOrigin() {
        Sonda expected = new Sonda(0,0,Direcao.NORTH);

        Sonda response = sonda.execute("MMMMMMMMMM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenRotateMGridSize_shouldReturnToOrigin_thenFaceEast() {
        Sonda expected = new Sonda(0,0,Direcao.EAST);

        Sonda response = sonda.execute("RMMMMMMMMMM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLM_shouldRotateLeftMoveOneToEdge_thenFaceWest() {
        Sonda expected = new Sonda(9,0,Direcao.WEST);

        Sonda response = sonda.execute("LM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }

    @Test
    void givenLLM_shouldRoateToSouthMoveToTheEdge_thenFaceSouth() {
        Sonda expected = new Sonda(0,9,Direcao.SOUTH);

        Sonda response = sonda.execute("LLM");
        assertThat(response).isEqualToComparingFieldByField(expected);
    }
}