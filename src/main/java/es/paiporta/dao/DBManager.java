package es.paiporta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.paiporta.dto.Example;

public class DBManager {
	public ArrayList<Example> GetExamples(Connection connection) throws Exception
	{
		ArrayList<Example> examples = new ArrayList<Example>();
		try	{
			
			PreparedStatement ps = connection.prepareStatement("SELECT id, data FROM example ORDER BY id DESC");
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
}
