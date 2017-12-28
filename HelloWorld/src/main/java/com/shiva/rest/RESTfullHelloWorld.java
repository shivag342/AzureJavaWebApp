package com.shiva.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

@Path("/")
public class RESTfullHelloWorld {
	static Logger logger = Logger.getLogger(RESTfullHelloWorld.class);
	String output = "Before Method Call";

	@GET
	@Path("Home")
	@Produces("text/html")
	public Response getStrartingPage() {
		logger.info("inside getStratingpage method......");
		try {
			output = "<h1>Hello World</h1>" + "<p>RESTful Service is running....<br>Ping @" + new Date().toString()
					+ "</p<br>";
		} catch (Exception e) {
			logger.error("Exception while running....:" + e.getMessage());
			e.printStackTrace();
		}
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("users/{id : \\d+}")
	@Produces("text/html")
	public Response getUserIDDetails(@PathParam("id") Integer id) {
		try {
			logger.info("Inside getUserIDDetails");
			if(id >=1)
			{
				logger.info("Entered value is greater then 1");
				int i= 1/id;
				output = "<h1>You Entered: "+id+" so Result ="+i+"</h1><br>Ping @" + new Date().toString()
						+ "</p<br>";
			}
			else if (id < 0)
			{
				logger.info("Entered value is less then 0");
				int i= 1/id;
				output = "<h1>You Entered: "+id+" so Result ="+i+"</h1><br>Ping @" + new Date().toString()
						+ "</p<br>";
			}
			else
			{
				logger.info("Entered value is 0");
				int i= 1/id;
				output = "<h1>You Entered: "+id+" so Result ="+i+"</h1><br>Ping @" + new Date().toString()
						+ "</p<br>";
			}
		} catch (Exception e) {
			logger.error("Exception while running :"+ e.getMessage());
			e.printStackTrace();
		}
		return Response.status(200).entity(output).build();

	}
}
