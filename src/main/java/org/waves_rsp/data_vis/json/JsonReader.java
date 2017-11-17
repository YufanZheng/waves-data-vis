package org.waves_rsp.data_vis.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import com.eclipsesource.json.*;

final public class JsonReader {
	
    // ------------------------------------------------------------------------
    // Constants
    // ------------------------------------------------------------------------
	
	/** UTF8 encoding */
	private final static String UTF8_ENCODING = "UTF-8";
	
    // ------------------------------------------------------------------------
    // Instance members
    // ------------------------------------------------------------------------
	
	/** GeoJson Parser Singleton Instance */
	private static JsonReader instance = null;
	
	// ------------------------------------------------------------------------
    // Singleton Constructor
    // ------------------------------------------------------------------------
	
	public static JsonReader getInstance() throws IOException {
		if(instance == null) {
			instance = new JsonReader();
		}
		return instance;
	}
	
	// ------------------------------------------------------------------------
    // Read resource JSON file
    // ------------------------------------------------------------------------
	
	/**
     * Get file in resource folder as JSON object
     * 
     * @param filename: File name in the resources folder
     * @return JsonObject object
     * @throws URISyntaxException 
     */
	public JsonObject getResourceFileAsJsonObject(String filename) throws IOException {
	    return Json
	    		.parse(readInputStream(filename)).asObject();
    }
	
	/**
     * Get file in resource folder as JSON array
     * 
     * @param filename: File name in the resources folder
     * @return JsonArray object
     * @throws URISyntaxException 
     */
	public JsonArray getResourceFileAsJsonArray(String filename) throws IOException {
	    return Json
	    		.parse(readInputStream(filename)).asArray();
    }
	
	/**
     * Read JSON file as Input Stream
     * 
     * @param filename: File name in the resources folder
     * @return file string
     * @throws URISyntaxException 
     */
	private Reader readInputStream(String filename) throws UnsupportedEncodingException {
		InputStream in = this.getClass().getResourceAsStream("/" + filename);
	    Reader r = new InputStreamReader(in, UTF8_ENCODING);
	    return r;
	}
	
}
