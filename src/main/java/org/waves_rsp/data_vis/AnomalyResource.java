package org.waves_rsp.data_vis;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.waves_rsp.data_vis.json.JsonReader;

import com.eclipsesource.json.JsonObject;

@Path("anomaly")
public class AnomalyResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAnomaly() throws IOException, URISyntaxException {
    	// TODO: Replace the file string as the real anomaly result
		JsonObject json = JsonReader.getInstance()
    			.getResourceFileAsJsonObject("anomaly.json");
		return Response.ok(json.toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("explanation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExplanation(@QueryParam("sector")    String sector,
    							 @QueryParam("startTime") String startTime,
    							 @QueryParam("endTime")   String endTime) throws IOException, URISyntaxException {
    	// TODO: Replace the file string as the real anomaly result
    	JsonObject json = JsonReader.getInstance()
    			.getResourceFileAsJsonObject("sample events.large.json");
    	return Response.ok(json.toString(), MediaType.APPLICATION_JSON).build();
    }
    
}
