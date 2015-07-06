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
			PreparedStatement ps = connection.prepareStatement("SELECT id, data FROM example ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Example ex = new Example();
				ex.setId(rs.getInt("id"));
				ex.setData(rs.getString("data"));
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
			PreparedStatement ps = connection.prepareStatement("SELECT id, data FROM example WHERE id = " + id + " ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ex.setId(rs.getInt("id"));
				ex.setData(rs.getString("data"));
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
			
			PreparedStatement ps = connection.prepareStatement("SELECT id, data FROM example WHERE data LIKE '%" + search + "%' ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Example ex = new Example();
				ex.setId(rs.getInt("id"));
				ex.setData(rs.getString("data"));
				examples.add(ex);
			}
			return examples;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	// add an example
	public void addExample(Connection connection, Example example) throws Exception {	
		String sql = "INSERT INTO example (id, data) VALUES (?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, example.getId());
		ps.setString(2, example.getData());
		ps.executeUpdate();
	}
	
	// delete an example
	public void deleteExample(Connection connection, int id) throws Exception {	
		String sql = "DELETE FROM example WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	// update an example
	public void updateExample(Connection connection, Example example) throws Exception {	
		String sql = "UPDATE example set data = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, example.getData());
		ps.setInt(2, example.getId());
		ps.executeUpdate();
	}	
}
