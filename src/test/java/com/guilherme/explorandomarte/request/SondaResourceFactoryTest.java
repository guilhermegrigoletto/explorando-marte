package com.guilherme.explorandomarte.request;


import com.guilherme.explorandomarte.controller.SondaResource;
import com.guilherme.explorandomarte.entity.Direcao;
import com.guilherme.explorandomarte.entity.Sonda;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SondaResourceFactoryTest {

    private SondaResourceFactory factory = new SondaResourceFactory();

    @Test
    void givenSondaEntity_createResourceWithSameDataAndLink() {
        Sonda sonda = new Sonda(5, 7, Direcao.SOUTH);
        sonda.setId(5L);

        SondaResource resource = factory.toResource(sonda);
        assertThat(resource.getX()).isEqualTo(5);
        assertThat(resource.getY()).isEqualTo(7);
        assertThat(resource.getDirecao()).isEqualTo(Direcao.SOUTH);
        assertThat(resource.getLink("self").get().getHref()).isEqualTo("/api/sondas/5");
    }
}