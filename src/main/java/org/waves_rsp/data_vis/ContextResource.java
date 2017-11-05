package org.waves_rsp.data_vis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("context")
public class ContextResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getContext() throws IOException {
    	
        // context.json is static sensor data, do NOT need to update it with real time data
        // don't need to change the method below
    	
    	String context = getResourceFile("context.json");
    	
        return context;
    }
    
    /**
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
