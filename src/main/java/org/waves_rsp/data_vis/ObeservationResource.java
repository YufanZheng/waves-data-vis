package org.waves_rsp.data_vis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("observation")
public class ObeservationResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getObsValue(@QueryParam("id") String streamId) throws IOException {
    	
    	// TODO: Replace the returned json string with real time data from request stream id
    	
    	System.out.println("The stream id is " + streamId);
    	String json = getResourceFile("dump-54.json");
    	
        return json;
    }
    
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
	
    @GET
    @Path("history")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHistoryObsValue(@QueryParam("id")        String streamId,
						    		 @QueryParam("startDate") String startDate,
						    		 @QueryParam("endDate")   String endDate) throws IOException {
    	
    	// TODO: Replace the returned json string with history data
    	
    	System.out.println("The stream id is " + streamId);
    	System.out.println("The startDate id is " + startDate);
    	System.out.println("The endDate id is " + endDate);
    	
    	String json = getResourceFile("dump-54.json");
    	
        return json;
    }
    
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
    
    @GET
    @Path("streams")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllObsStreams() {
    	
    	// TODO: Replace with real time observation stream IDs
    	
    	String streamIds = getResourceFile("list-obs-streams.json");
    	
    	return streamIds;
    }

    /**
     * Method to be removed from this class once get the real time data
     * 		instead of fixed file data
     * 
     * Get file in resource folder as string
     * 
     * @param filename: File name in the resources folder
     * @return file string
     */
    private String getResourceFile(String filename) {

    	StringBuilder result = new StringBuilder("");

    	//Get file from resources folder
    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File(classLoader.getResource(filename).getFile());

    	try (Scanner scanner = new Scanner(file)) {

    		while (scanner.hasNextLine()) {
    			String line = scanner.nextLine();
    			result.append(line).append("\n");
    		}

    		scanner.close();

    	} catch (IOException e) {
    		e.printStackTrace();
    	}

    	return result.toString();
    }
}
