package org.mbellange.tennisdream.services.rest;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;
import org.mbellange.tennisdream.domain.entities.Article;
import org.mbellange.tennisdream.domain.entities.ArticleReview;
import org.mbellange.tennisdream.domain.entities.Brand;
import org.mbellange.tennisdream.domain.entities.Deal;

import com.google.common.collect.Sets;

@Path("/articles")
public class ArticleResource {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Article getArticle(@PathParam("id") long id) {

		Article article = new Article();
		article = article.findArticle(id);
		
		return article;
 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Article> getAllArticle() {
		Article article = dummyArticle();

		Set<Article> listArticle = Sets.newHashSet(article,article);
				
		return listArticle;
 
	}
	
	@POST
	@Path("/{id}/review")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Article addReview(@PathParam("id") long id, ArticleReview review){
		
		Article article = dummyArticle();
		article.addreview(review);
		
		return article;
	}
	
	@GET
	@Path("/daydeals")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Deal> getAllDayDeals(){
		Set<Deal> allDayDeals = Sets.newHashSet(dummyDeal());
		return allDayDeals;
	}
	
	private Article dummyArticle(){
		return new Article("ArticleRef","ArticleNom","ArticleDesc", 15.5f, new Brand("theMarque","C'est une marque"));
	}
	
	private Deal dummyDeal(){
		DateTime datetime = new DateTime();
		DateTime tomorrow = datetime.plusDays(1);
		return new Deal("desc", datetime.toDate(), tomorrow.toDate(),0.5f);
	}
}
