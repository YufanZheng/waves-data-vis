package org.waves_rsp.data_vis.json;

import org.waves_rsp.data_vis.json.GeoJsonParser;

public class TestGeoParser {

	public static void main(String args) throws Exception {
		GeoJsonParser g = new GeoJsonParser();
		System.out.println(g.getPolygons("Drom"));
	}
}
