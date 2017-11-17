package org.waves_rsp.data_vis;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.waves_rsp.data_vis.json.GeoJsonParser;
import org.waves_rsp.data_vis.json.JsonReader;

import com.eclipsesource.json.JsonObject;

@Path("context")
public class ContextResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getContext() throws IOException {
    	// TODO: Replace the file string
    	JsonObject json = JsonReader.getInstance()
    			.getResourceFileAsJsonObject("context.json");
        return Response.ok(json.toString()).build();
    }
    
    @GET
    @Path("sector-boundary")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSectorBoundary(@QueryParam("name") String name) throws IOException, URISyntaxException {
    	// TODO: From commune name and the geojson
    	//data get the coordinates of boundary
    	return GeoJsonParser.getInstance().getPolygons(name);
    }
    
}
