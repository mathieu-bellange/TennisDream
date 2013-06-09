package org.mbellange.tennisdream.services.rest;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mbellange.tennisdream.domain.entities.Article;

@Path("/command")
public class CommandResource {
	
	@POST
	@Path("/{user}/basket")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validBasket(@PathParam("user") String user, Set<Article> articles){
		//TODO gestion de la commande
		return Response.ok().build();
	}

}
