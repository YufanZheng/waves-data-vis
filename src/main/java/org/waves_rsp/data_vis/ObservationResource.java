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

import com.eclipsesource.json.JsonArray;

@Path("observation")
public class ObservationResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getObsValue(@QueryParam("id") String streamId) throws IOException, URISyntaxException {
    	// TODO: Replace the returned json string with real time data from request stream id
    	System.out.println("The stream id is " + streamId);
    	JsonArray json = JsonReader.getInstance()
    			.getResourceFileAsJsonArray("dump-54.json");
        return Response.ok(json.toString()).build();
    }
    
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
    
    @GET
    @Path("streams")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllObsStreams() throws IOException, URISyntaxException {
    	// TODO: Replace with real time flags stream IDs
    	JsonArray streamIds = JsonReader.getInstance()
    			.getResourceFileAsJsonArray("list-obs-streams.json");
    	return Response.ok(streamIds.toString()).build();
    }

}
