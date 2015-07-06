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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import es.paiporta.dao.DBManager;
import es.paiporta.dao.Database;
import es.paiporta.dto.Example;

@Path("/")
public class RESTFulService {

	@GET
	@Path("/list")
	public Response listExamples(@QueryParam("search") final String search) {

		ArrayList<Example> examples = null;

		String output = new String("");

		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();

			Connection conn = db.GetConnection();
			if (search != null) {
				examples = dbManager.searchExamples(conn, search);
			} else {
				examples = dbManager.getExamples(conn);
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
			Example example = dbManager.getExampleById(conn, id);

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
	public Response newExample(@FormParam("id") int id, @FormParam("name") String name, @FormParam("telf") int telf) throws IOException {

		Example example = new Example();
		example.setId(id);
		example.setName(name);
		example.setTelf(telf);

		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();

			Connection conn = db.GetConnection();
			dbManager.addExample(conn, example);
		} catch (Exception e) {
			return Response.status(200).entity("ERROR: " + e.getMessage()).build();
		}

		return Response.status(200).entity("SUCCESS: (data, telf) = (" + name + ", " + telf + ")").build();
	}

	@DELETE
	@Path("/delete")
	public Response deleteExample(@QueryParam("id") final int id) {

		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();

			Connection conn = db.GetConnection();
			dbManager.deleteExample(conn, id);
		} catch (Exception e) {
			return Response.status(200).entity("ERROR: " + e.getMessage()).build();
		}

		return Response.status(200).entity("SUCCESS: ID = " + id).build();
	}

	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateExample(@FormParam("id") int id, @FormParam("name") String name, @FormParam("telf") int telf) throws IOException {

		Example example = new Example();
		example.setId(id);
		example.setName(name);
		example.setTelf(telf);

		try {
			Database db = new Database();
			DBManager dbManager = new DBManager();

			Connection conn = db.GetConnection();
			dbManager.updateExample(conn, example);
		} catch (Exception e) {
			return Response.status(200).entity("ERROR: " + e.getMessage()).build();
		}

		return Response.status(200).entity("SUCCESS: (data, telf) = (" + name + ", " + telf + ")").build();
	}

}
