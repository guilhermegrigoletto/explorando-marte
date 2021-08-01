package com.guilherme.explorandomarte.controller;

import com.guilherme.explorandomarte.domain.Malha;
import com.guilherme.explorandomarte.request.MalhaRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MalhaControllerTest {

    private MalhaController controller;

    @BeforeEach
    void setUp() {
        controller = new MalhaController();
    }
    
    @Test
    void givenNewValues_shouldUpdateMalha() {
        MalhaRequest request = new MalhaRequest(12,14);

        controller.defineMalha(request);
        assertThat(Malha.getXMaximo()).isEqualTo(12);
        assertThat(Malha.getYMaximo()).isEqualTo(14);
    }
}