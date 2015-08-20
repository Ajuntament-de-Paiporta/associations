package es.paiporta.rest;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import es.paiporta.dao.DBManager;
import es.paiporta.dao.Database;
import es.paiporta.dto.Association;
 /*
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
 */

@Path("/")
public class Hello {
 
	@GET
	@Path("/list")
	public Response listExamples(@QueryParam("search") final String search) {
 
		ArrayList<Association> examples = null;
		
		String output = new String("");
 
		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();
			
			Connection conn = db.GetConnection();
			if (search != null) {
				examples = dbManager.searchAssociation(conn, search);
			} else {
				examples = dbManager.getAssociations(conn);
			}

			Gson gson = new Gson();
			output = gson.toJson(examples);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/get")
	public Response getExample(@QueryParam("id") final int id) {
 
		String output = new String("");
 
		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();
			
			Connection conn = db.GetConnection();
			Association example = dbManager.getAssociationById(conn, id);
			
			Gson gson = new Gson();
			output = gson.toJson(example);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/add")	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response newExample(@FormParam("id") int id,
	      @FormParam("name") String name, @FormParam("email") String email, @FormParam("phone") int phone, @FormParam("address") String address,
	      @FormParam("postalcode") int postalcode, @FormParam("city") String city, @FormParam("longitude") String longitude, @FormParam("latitude") String latitude, 
	      @FormParam("webpage") String webpage, @FormParam("facebook") String facebook, @FormParam("twitter") String twitter, 
	      @FormParam("presidentName") String presidentName, @FormParam("presidentEmail") String presidentEmail, @FormParam("presidentPhone") int presidentPhone, 
	      @FormParam("secretaryName") String secretaryName, @FormParam("secretaryEmail") String secretaryEmail, @FormParam("secretaryPhone") int secretaryPhone,
	      @FormParam("active") boolean active) throws IOException {
		
		Association example = new Association();
	    example.setId(id);
	    example.setName(name);
	    example.setEmail(email);
	    example.setAddress(address);
	    example.setPhone(phone);
	    example.setPostalcode(postalcode);
	    example.setCity(city);
	    example.setLongitude(longitude);
	    example.setLatitude(latitude);
	    example.setWebpage(webpage);
	    example.setFacebook(facebook);
	    example.setTwitter(twitter);
	    example.setPresidentName(presidentName);
	    example.setPresidentEmail(presidentEmail);
	    example.setPresidentPhone(presidentPhone);
	    example.setSecretaryName(secretaryName);
	    example.setSecretaryEmail(secretaryEmail);
	    example.setSecretaryPhone(secretaryPhone);
	    example.setActive(active);
	    

	    try {
	    	Database db = new Database();
	    	DBManager dbManager = new DBManager();
		
	    	Connection conn = db.GetConnection();
	    	dbManager.addAssociation(conn, example);
	    } catch (Exception e) {
	    	return Response.status(200).entity("ERROR: " + e.getMessage()).build();
	    }
		
	    return Response.status(200).entity("SUCCESS").build();
	  }

	@DELETE
	@Path("/delete")
	public Response deleteExample(@QueryParam("id") final int id) {
 
		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();
			
			Connection conn = db.GetConnection();
			dbManager.deleteAssociation(conn, id);
		} catch (Exception e) {
	    	return Response.status(200).entity("ERROR: " + e.getMessage()).build();
		}

	    return Response.status(200).entity("SUCCESS: ID = " + id).build();
	}
	
	@PUT
	@Path("/edit")	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateExample(@FormParam("id") int id, 
		      @FormParam("name") String name, @FormParam("email") String email, @FormParam("phone") int phone, @FormParam("address") String address,
		      @FormParam("postalcode") int postalcode, @FormParam("city") String city, @FormParam("longitude") String longitude, @FormParam("latitude") String latitude, 
		      @FormParam("webpage") String webpage, @FormParam("facebook") String facebook, @FormParam("twitter") String twitter, 
		      @FormParam("presidentName") String presidentName, @FormParam("presidentEmail") String presidentEmail, @FormParam("presidentPhone") int presidentPhone, 
		      @FormParam("secretaryName") String secretaryName, @FormParam("secretaryEmail") String secretaryEmail, @FormParam("secretaryPhone") int secretaryPhone,
		      @FormParam("active") boolean active) throws IOException {
		
		Association example = new Association();
	    example.setId(id);
	    example.setName(name);
	    example.setEmail(email);
	    example.setAddress(address);
	    example.setPhone(phone);
	    example.setPostalcode(postalcode);
	    example.setCity(city);
	    example.setLongitude(longitude);
	    example.setLatitude(latitude);
	    example.setWebpage(webpage);
	    example.setFacebook(facebook);
	    example.setTwitter(twitter);
	    example.setPresidentName(presidentName);
	    example.setPresidentEmail(presidentEmail);
	    example.setPresidentPhone(presidentPhone);
	    example.setSecretaryName(secretaryName);
	    example.setSecretaryEmail(secretaryEmail);
	    example.setSecretaryPhone(secretaryPhone);
	    example.setActive(active);

	    try {
	    	Database db = new Database();
	    	DBManager dbManager = new DBManager();
		
	    	Connection conn = db.GetConnection();
	    	dbManager.updateAssociation(conn, example);
	    } catch (Exception e) {
	    	return Response.status(200).entity("ERROR: " + e.getMessage()).build();
	    }
		
	    return Response.status(200).entity("SUCCESS").build();
	  }

}
