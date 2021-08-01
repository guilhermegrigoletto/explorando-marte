package com.guilherme.explorandomarte.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.explorandomarte.entity.Direcao;
import com.guilherme.explorandomarte.entity.Sonda;
import com.guilherme.explorandomarte.repository.PosicaoSondaPassadaRepository;
import com.guilherme.explorandomarte.repository.SondaRepository;
import com.guilherme.explorandomarte.request.SondaRequest;
import com.guilherme.explorandomarte.request.SondaResourceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {SondaController.class})
class SondaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SondaRepository sondaRepository;
    @MockBean
    private SondaResourceFactory factory;
    @MockBean
    private PosicaoSondaPassadaRepository  posicaoSondaPassadaRepository;
    @Captor
    private ArgumentCaptor<Sonda> sondaArgumentCaptor;

    private Sonda sonda;
    private SondaResource expectedResource;

    @BeforeEach
    void setUp() {
        sonda = new Sonda(0,0,Direcao.N);
        expectedResource = new SondaResource();
    }

    @Test
    void getById_GivenNonExistentSonda_ReturnsNotFoundResponse() throws Exception {
        mockMvc.perform(
                get("/api/sondas/1")
        ).andExpect(
                status().isNotFound()
        );
    }

    @Test
    void getById_GivenFoundSonda_ReturnsSondaResource() throws Exception {
        sonda.setId(1L);
        when(sondaRepository.findById(1L)).thenReturn(Optional.of(sonda));

        expectedResource.setX(7);
        expectedResource.setY(3);
        expectedResource.setDirecao(Direcao.S);
        expectedResource.add(Link.of("http://localhost:8080/api/sondas/1"));
        when(factory.toResource(sonda)).thenReturn(expectedResource);

        mockMvc.perform(
                get("/api/sondas/1")
        ).andExpect(
            status().isOk()
        ).andExpect(
            jsonPath("x").value(7)
        ).andExpect(
                jsonPath("y").value(3)
        ).andExpect(
                jsonPath("direcao").value("S")
        ).andExpect(
                jsonPath("links[0].href").value("http://localhost:8080/api/sondas/1")
        );
    }

    @Test
    void criarSonda_givenValidRequest_CreateSondaResource() throws Exception {
        SondaRequest postSondaRequest = new SondaRequest();
        postSondaRequest.setX(5);
        postSondaRequest.setY(0);
        postSondaRequest.setDirecao(Direcao.E);

        expectedResource.setX(5);
        expectedResource.setY(0);
        expectedResource.setDirecao(Direcao.E);
        expectedResource.add(Link.of("http://localhost:8080/api/sondas/1"));
        when(factory.toResource(any())).thenReturn(expectedResource);

        mockMvc.perform(
                post("/api/sondas")
                .content(asJsonString(postSondaRequest))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isCreated()
        ).andExpect(
                jsonPath("x").value(5)
        ).andExpect(
                jsonPath("y").value(0)
        ).andExpect(
                jsonPath("direcao").value("E")
        ).andExpect(
                jsonPath("links[0].href").value("http://localhost:8080/api/sondas/1")
        );
    }

    @Test
    void criarSonda_givenInvalidRequest_ReturnBadRequest() throws Exception {
        mockMvc.perform(
                post("/api/sondas")
                    .content(asJsonString("invalid"))
                    .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isBadRequest()
        );
    }

    @Test
    void executarComando_givenExistingSondaMoves_ReturnsResourceUpdated() throws Exception {
        sonda.setId(1L);
        when(sondaRepository.findById(1L)).thenReturn(Optional.of(sonda));

        expectedResource.setX(0);
        expectedResource.setY(3);
        expectedResource.setDirecao(Direcao.N);
        expectedResource.add(Link.of("http://localhost:8080/api/sondas/1"));
        when(factory.toResource(sondaArgumentCaptor.capture())).thenReturn(expectedResource);

        mockMvc.perform(
                put("/api/sondas/1/MMM")
        ).andExpect(
                status().isOk()
        ).andExpect(
                jsonPath("x").value(0)
        ).andExpect(
                jsonPath("y").value(3)
        ).andExpect(
                jsonPath("direcao").value("N")
        ).andExpect(
                jsonPath("links[0].href").value("http://localhost:8080/api/sondas/1")
        );

        assertThat(sondaArgumentCaptor.getValue().getY()).isEqualTo(3);
    }

    @Test
    void executarComando_givenResourceDoesntExist_ReturnNotFound() throws Exception {
        mockMvc.perform(
                put("/api/sondas/15/MMM")
        ).andExpect(
                status().isNotFound()
        );
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}