package org.mbellange.tennisdream.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mbellange.tennisdream.domain.entities.Article;

@Path("/catalogue")
public class CatalogueResource {

	@GET
	@Path("/article/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Article getArticle(@PathParam("id") long id) {

		Article article = new Article("ArticleRef","ArticleNom","ArticleDesc");
		
		return article;
 
	}
}
