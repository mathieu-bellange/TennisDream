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
import org.mbellange.tennisdream.domain.entities.ArticleReview;
import org.mbellange.tennisdream.domain.entities.Deal;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ArticleResourceTest {

	@Rule
	public EmbeddedServer server = new EmbeddedServer();

	@Test
	public void shouldGetArticle() {
		URI uri = UriBuilder.fromPath("/rest/articles/{id}").build(1);
		Article articleToTest = webResource(uri).get(Article.class);
		assertThat(articleToTest).as("Verif que cet article n'est pas null")
				.isNotNull();
		assertThat(articleToTest.getMarque()).as("Verif que la marque n'est pas null")
		.isNotNull();
		assertThat(articleToTest.getNom()).isEqualTo("ArticleNom");
	}
	
	@Test
	public void shouldGetAllArticle() {
		URI uri = UriBuilder.fromPath("/rest/articles").build();
		GenericType<Set<Article>> genericType = new GenericType<Set<Article>>() {};
		Set<Article> articleToTest = webResource(uri).get(genericType);
		assertThat(articleToTest).as("Verif que la liste d'article n'est pas null")
				.isNotNull();
		assertThat(articleToTest.size()).isGreaterThan(0);
	}
	
	@Test
	public void shouldPostReview() throws JsonGenerationException, JsonMappingException, IOException {
		URI uri = UriBuilder.fromPath("/rest/articles/{id}/review").build(1);
		ObjectMapper mapper = new ObjectMapper();
		Article articleToTest = webResource(uri).header("Content-Type", "application/json").post(Article.class,mapper.writeValueAsString(dummyReview()));
		assertThat(articleToTest).as("Verif que cet article n'est pas null")
				.isNotNull();
		assertThat(articleToTest.getArticleReviews()).as("la liste de commentaire à vérifier qu'il a bien été ajouté")
		.contains(dummyReview());
	}
	
	@Test
	public void shouldGetAllDayDeals() {
		URI uri = UriBuilder.fromPath("/rest/articles/daydeals").build(1);
		GenericType<Set<Deal>> genericType = new GenericType<Set<Deal>>() {};
		Set<Deal> listOfDeak = webResource(uri).get(genericType);
		assertThat(listOfDeak).as("Verif que la liste n'est pas null")
				.isNotNull();
		assertThat(listOfDeak.size()).as("la liste n'est pas vide")
		.isGreaterThan(0);
	}

	/* helpers */	
	private WebResource webResource(URI uri) {
		ClientConfig cc = new DefaultClientConfig(JacksonJsonProvider.class);
		WebResource webResource = Client.create(cc).resource(server.uri())
				.path(uri.getPath());
		webResource.accept(MediaType.APPLICATION_JSON_TYPE);
		return webResource;
	}
	
	private ArticleReview dummyReview(){
		return new ArticleReview(5,"Un super commentaire");
	}
}
