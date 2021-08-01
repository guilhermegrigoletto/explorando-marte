package com.guilherme.explorandomarte.request;

import com.guilherme.explorandomarte.controller.SondaController;
import com.guilherme.explorandomarte.controller.SondaResource;
import com.guilherme.explorandomarte.entity.Sonda;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SondaResourceFactory {

    public SondaResource toResource(Sonda sonda) {
        SondaResource resource = new SondaResource();
        resource.setDirecao(sonda.getDirecao());
        resource.setX(sonda.getX());
        resource.setY(sonda.getY());
        resource.add(linkTo(methodOn(SondaController.class).getById(sonda.getId())).withSelfRel());

        return resource;
    }
}
