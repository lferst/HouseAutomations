package com.lucasautomations.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("device")
public class HomeServices {
	
	public static final String URL_ARDUINO = "http://192.168.0.16:9090/?";

	@GET
	@Path("/{device}")
    public Response postMsg(@PathParam("device") String device) {
 
		  
		try {
			  URL url = new URL(URL_ARDUINO + device);
			  HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			  if (conn.getResponseCode() != 200) {
				  return Response.status(conn.getResponseCode()).build();  
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

		return Response.status(200).build();
    }

}
