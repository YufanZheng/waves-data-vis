package org.waves_rsp.data_vis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("anomaly")
public class AnomalyResource {
	
	// ----------------------------------------
	// TODO : Replace the function below
	// ----------------------------------------

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnomaly() throws IOException {
    	
    	// Every 1 second, the front-end will send a get request to this function
    	//
    	//  - if there is a detected anomaly:
    	//      return the json string same format as anomaly.json
    	//
    	//  - if no anomaly
    	//      return the json string same format as no_anomaly.json 
    	//
    	// TODO: Replace the file string as the real anomaly result
    	//
    	// Important Note Here: the returned format must be the same as indicated in the file
    	//
    	
    	String json = getResourceFile("anomaly.json");
    	// String json = getAnomalyDataFromTs(new Date((TimeReference.millis));
    	
        return json;
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
