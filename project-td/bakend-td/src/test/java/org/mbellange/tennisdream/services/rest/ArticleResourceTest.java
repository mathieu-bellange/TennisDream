package org.mbellange.tennisdream.services.rest;

import static org.fest.assertions.Assertions.assertThat;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Rule;
import org.junit.Test;
import org.mbellange.tennisdream.domain.entities.Article;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ArticleResourceTest {

	@Rule
	public EmbeddedServer server = new EmbeddedServer();

	@Test
	public void shouldGetProduct() {
		Article articleToTest = articleResource(1).get(Article.class);
		assertThat(articleToTest).as("Verif que cet article n'est pas null")
				.isNotNull();
		assertThat(articleToTest.getNom()).isEqualTo("ArticleNom");
	}

	/* helpers */
	private WebResource articleResource(long id) {
		URI uri = UriBuilder.fromPath("/rest/articles/{id}").build(id);
		ClientConfig cc = new DefaultClientConfig(JacksonJsonProvider.class);
		WebResource webResource = Client.create(cc).resource(server.uri())
				.path(uri.getPath());
		webResource.accept(MediaType.APPLICATION_JSON_TYPE);
		return webResource;
	}
}
