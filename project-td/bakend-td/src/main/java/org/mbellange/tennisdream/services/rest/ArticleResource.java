package org.mbellange.tennisdream.services.rest;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.mbellange.tennisdream.domain.entities.Article;

import com.google.common.collect.Sets;

@Path("/articles")
public class ArticleResource {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Article getArticle(@PathParam("id") long id) {

		Article article = new Article("ArticleRef","ArticleNom","ArticleDesc");
		
		return article;
 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Article> getAllArticle() {
		Article article = new Article("ArticleRef","ArticleNom","ArticleDesc");

		Set<Article> listArticle = Sets.newHashSet(article);
				
		return listArticle;
 
	}
	
	@POST
	@Path("/{id}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Article addComment(@PathParam("id") long id, @QueryParam("note") int note, @QueryParam("comment")String comment){
		
		Article article = new Article("ArticleRef","ArticleNom",comment);
		
		return article;
	}
}
