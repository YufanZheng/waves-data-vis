package org.waves_rsp.data_vis;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.waves_rsp.data_vis.json.JsonReader;

import com.eclipsesource.json.JsonArray;

@Path("flags")
public class FlagsResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getFlags() throws IOException {
    	// TODO: Instead of reading the file, use real time data
    	JsonArray json = JsonReader.getInstance()
    			.getResourceFileAsJsonArray("flags.json");
        return Response.ok(json.toString()).build();    	
    }
    
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
    
    @GET
    @Path("streams")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllFlagsStreams() throws IOException {
    	// TODO: Replace with real time flags stream IDs
    	JsonArray streamIds = JsonReader.getInstance()
    			.getResourceFileAsJsonArray("list-flags-streams.json");
    	return Response.ok(streamIds.toString()).build();
    }
    
}
