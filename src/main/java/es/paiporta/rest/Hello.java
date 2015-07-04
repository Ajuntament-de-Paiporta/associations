package es.paiporta.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import java.sql.Connection;
import java.util.ArrayList;

import es.paiporta.dao.DBManager;
import es.paiporta.dao.Database;
import es.paiporta.dto.Example;
 
@Path("/hello")
public class Hello {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		ArrayList<Example> examples = null;
		
		String output = "Jersey say : " + msg;
 
		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();
			
			Connection conn = db.GetConnection();
			examples = dbManager.GetExamples(conn);
			
			for(Example ex: examples) {
				output += ("<br>" + ex.getId() + " - " + ex.getData());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return Response.status(200).entity(output).build();
	}
 
}
