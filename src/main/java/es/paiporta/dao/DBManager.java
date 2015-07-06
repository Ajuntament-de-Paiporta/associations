package es.paiporta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.paiporta.dto.Example;

public class DBManager {
		
	// get all examples
	public ArrayList<Example> getExamples(Connection connection) throws Exception {
		ArrayList<Example> examples = new ArrayList<Example>();
		try	{
			PreparedStatement ps = connection.prepareStatement("SELECT id, name, telf FROM examples ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Example ex = new Example();
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setTelf(rs.getInt("telf"));
				examples.add(ex);
			}
			return examples;
		} catch(Exception e) {
			throw e;
		}
	}
	
	// get example by id
	public Example getExampleById(Connection connection, int id) throws Exception {
		Example ex = new Example();
		try	{
			PreparedStatement ps = connection.prepareStatement("SELECT id, name, telf FROM examples WHERE id = " + id + " ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setTelf(rs.getInt("telf"));
				break;
			}			
		} catch(Exception e) {
			throw e;
		}
		return ex;
	}
	
	// search examples
	public ArrayList<Example> searchExamples(Connection connection, String search) throws Exception {
		ArrayList<Example> examples = new ArrayList<Example>();
		try	{			
			PreparedStatement ps = connection.prepareStatement("SELECT id, name, telf FROM examples WHERE name LIKE '%" + search + "%' ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Example ex = new Example();
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setTelf(rs.getInt("telf"));
				examples.add(ex);
			}
			return examples;
		} catch(Exception e) {
			throw e;
		}
	}
	
	// add an example
	public void addExample(Connection connection, Example example) throws Exception {	
		String sql = "INSERT INTO examples (name, telf) VALUES (?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		//ps.setInt(1, example.getId());
		ps.setString(1, example.getName());
		ps.setInt(2, example.getTelf());
		ps.executeUpdate();
	}
	
	// delete an example
	public void deleteExample(Connection connection, int id) throws Exception {	
		String sql = "DELETE FROM examples WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	// update an example
	public void updateExample(Connection connection, Example example) throws Exception {	
		String sql = "UPDATE examples set name = ?, telf = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, example.getName());
		ps.setInt(2, example.getTelf());
		ps.setInt(3, example.getId());
		ps.executeUpdate();
	}	
}
