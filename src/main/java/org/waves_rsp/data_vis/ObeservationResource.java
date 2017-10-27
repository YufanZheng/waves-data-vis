package org.waves_rsp.data_vis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("observation")
public class ObeservationResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------
	
	// Every 1 second, the front-end will send a request to 
	//		fetch current observation data
	// Need to REPLACE the function below with the code 
	//		to receive the real observation data
	//
	// NOTE:
	//   The returned string must be in the same format as the dump-54.json file
	//
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getObsValue() throws IOException {
    	
    	String obsValue = getResourceFile("dump-54.json");
    	
        return obsValue;
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
