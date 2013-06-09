package org.mbellange.tennisdream.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mbellange.tennisdream.domain.entities.Account;
import org.mbellange.tennisdream.domain.entities.AuthenticateForm;

@Path("/account")
public class AccountResource {

	@POST
	@Path("/authenticate")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authentication(AuthenticateForm authenticateForm){
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("id") long id){
		Account account = new Account();
		return account;
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Account account){
		return Response.ok().build();
	}
}
