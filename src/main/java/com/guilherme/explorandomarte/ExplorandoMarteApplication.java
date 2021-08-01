package com.guilherme.explorandomarte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExplorandoMarteApplication {
	/*
		Bean para resolver o bug atual entre spring-hatoas e Springfox Swagger (falha ao iniciar, requer que beans sejam anotados)
	 */
	@Bean
	public LinkDiscoverers discovers() {

		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

	}

	public static void main(String[] args) {
		SpringApplication.run(ExplorandoMarteApplication.class, args);
	}

}
