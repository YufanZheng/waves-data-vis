package org.waves_rsp.data_vis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("anomaly")
public class AnomalyResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnomaly() throws IOException {

    	// TODO: Replace the file string as the real anomaly result
    	
    	String json = getResourceFile("anomaly.json");
    	
        return json;
    }
    
    @GET
    @Path("explanation")
    @Produces(MediaType.TEXT_PLAIN)
    public String getExplanation(@QueryParam("startTime") String startTime,
    							 @QueryParam("endTime")   String endTime,
    							 @QueryParam("longitude") double longitude,
    							 @QueryParam("latitude")  double latitude) throws IOException {

    	// TODO: Replace the file string as the real anomaly result
    	
    	String json = getResourceFile("scouter-events.json");
    	
        return json;
    }
    
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
