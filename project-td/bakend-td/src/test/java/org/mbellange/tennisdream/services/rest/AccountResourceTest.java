package org.mbellange.tennisdream.services.rest;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.mbellange.tennisdream.domain.entities.Account;
import org.mbellange.tennisdream.domain.entities.Address;
import org.mbellange.tennisdream.domain.entities.AuthenticateForm;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class AccountResourceTest {
	
	@Rule
	public EmbeddedServer server = new EmbeddedServer();
	
	@Test
	public void shouldAuthenticateTest() throws JsonGenerationException, JsonMappingException, UniformInterfaceException, ClientHandlerException, IOException{
		URI uri = UriBuilder.fromPath("/rest/account/authenticate").build();
		ObjectMapper mapper = new ObjectMapper();
		ClientResponse clientResponse = webResource(uri).header("Content-Type", "application/json").post(ClientResponse.class, mapper.writeValueAsString(dummyAuthenticateForm()));
		assertThat(clientResponse.getStatus()).as("Verif que le status est ok")
		.isEqualTo(200);
	}
	
	@Test
	public void shouldCreateAccountTest() throws JsonGenerationException, JsonMappingException, UniformInterfaceException, ClientHandlerException, IOException{
		URI uri = UriBuilder.fromPath("/rest/account/create").build();
		ObjectMapper mapper = new ObjectMapper();
		ClientResponse clientResponse = webResource(uri).header("Content-Type", "application/json").post(ClientResponse.class,mapper.writeValueAsString(dummyAccount()));
		assertThat(clientResponse.getStatus()).as("Verif que le status est ok")
				.isEqualTo(200);
	}
	
	@Test
	public void shouldGetAccountTest(){
		URI uri = UriBuilder.fromPath("/rest/account/{id}").build(1);
		Account accountToTest = webResource(uri).get(Account.class);
		assertThat(accountToTest).as("Verif que le compte n'est pas null")
				.isNotNull();
	}

	/* helpers */	
	private WebResource webResource(URI uri) {
		ClientConfig cc = new DefaultClientConfig(JacksonJsonProvider.class);
		WebResource webResource = Client.create(cc).resource(server.uri())
				.path(uri.getPath());
		webResource.accept(MediaType.APPLICATION_JSON_TYPE);
		return webResource;
	}
	
	private Account dummyAccount(){
		return new Account("name","firstName","mail", new Address(1, "rue", "", 75012, "Paris", "France"));
	}
	
	private AuthenticateForm dummyAuthenticateForm(){
		return new AuthenticateForm("userName", "password");
	}

}
