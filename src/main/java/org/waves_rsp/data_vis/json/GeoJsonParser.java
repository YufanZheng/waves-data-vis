package org.waves_rsp.data_vis.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.eclipsesource.json.*;

final public class GeoJsonParser {
	
    // ------------------------------------------------------------------------
    // Constants
    // ------------------------------------------------------------------------
	
	/** Default France Cities GeoJson File Path */
	private final static String GEO_JSON_PATH = "/sectors/communes.geojson";
	
    // ------------------------------------------------------------------------
    // Instance members
    // ------------------------------------------------------------------------
	
	/** GeoJson Parser Singleton Instance */
	private static GeoJsonParser instance = null;
	/** All Sector Polygon's Coordinates */
	private static JsonObject polygons = null;
	
	// ------------------------------------------------------------------------
    // Singleton Constructor
    // ------------------------------------------------------------------------
	
	public static GeoJsonParser getInstance() throws IOException {
		if(instance == null) {
			instance = new GeoJsonParser();
			instance.loadGeoData();
		}
		return instance;
	}
	
	// ------------------------------------------------------------------------
    // Get Sector Boundary Polygons
    // ------------------------------------------------------------------------
	
	/**
	 * Get sector boundary polygons
	 * 
	 * @param name	Sector name
	 * @return	Polygon boundary coordinates array in string format, 
	 * 			if the sector not found, return 'NaN'
	 */
	public String getPolygons(String name) {
		JsonValue value = polygons.get(name);
	    return value != null ? value.asArray().toString() : "NaN";
	}
	
	// ------------------------------------------------------------------------
    // Load Default GeoJson Data
    // ------------------------------------------------------------------------
	
	/**
	 * Load default GeoJson data for French sectors
	 * 
	 * @throws IOException
	 */
	private void loadGeoData() throws IOException {
		polygons = new JsonObject();
		InputStream in = this.getClass().getResourceAsStream(GEO_JSON_PATH);
	    Reader r = new InputStreamReader(in, "UTF-8");
		JsonArray j = Json.parse(r).asObject()
				           .get("features").asArray();
		for (JsonValue value : j) {
			JsonObject o = value.asObject();
			JsonArray coord = o.get("geometry").asObject()
								.get("coordinates").asArray();
			String name = o.get("properties").asObject()
							.get("nom").asString();
			polygons.add(name, coord);
		}
	}
	
}
