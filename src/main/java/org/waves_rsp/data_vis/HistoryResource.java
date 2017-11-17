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

@Path("history")
public class HistoryResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getHistoryObsValue(@QueryParam("id")        String streamId,
						    		 @QueryParam("startDate") String startDate,
						    		 @QueryParam("endDate")   String endDate) throws IOException, URISyntaxException {
    	
    	// TODO: Replace the returned json string with history data
    	
    	System.out.println("The stream id is " + streamId);
    	System.out.println("The startDate id is " + startDate);
    	System.out.println("The endDate id is " + endDate);
    	
    	JsonArray json = JsonReader.getInstance()
    			.getResourceFileAsJsonArray("dump-54.json");
        return Response.ok(json.toString()).build();
    }
    
}
