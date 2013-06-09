package org.mbellange.tennisdream.services.rest;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.mbellange.tennisdream.domain.entities.Article;
import org.mbellange.tennisdream.domain.entities.Brand;

import com.google.common.collect.Sets;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class CommandResourceTest {

	@Rule
	public EmbeddedServer server = new EmbeddedServer();
	
	@Test
	public void shouldValidBasketTest() throws JsonGenerationException, JsonMappingException, UniformInterfaceException, ClientHandlerException, IOException{
		URI uri = UriBuilder.fromPath("/rest/command/{user}/basket").build("Toto");
		Set<Article> basket = Sets.newHashSet(dummyArticle());
		ObjectMapper mapper = new ObjectMapper();
		ClientResponse response = webResource(uri).header("Content-Type", "application/json").post(ClientResponse.class, mapper.writeValueAsString(basket));
		assertThat(response.getStatus()).as("Verif la réponse")
				.isEqualTo(200);
	}
	
	
	/* helpers */	
	private WebResource webResource(URI uri) {
		ClientConfig cc = new DefaultClientConfig(JacksonJsonProvider.class);
		WebResource webResource = Client.create(cc).resource(server.uri())
				.path(uri.getPath());
		webResource.accept(MediaType.APPLICATION_JSON_TYPE);
		return webResource;
	}
	
	private Article dummyArticle(){
		return new Article("Ref", "nom", "desc", 15.5f,new Brand("marque", "desc"));
	}
}
