package es.paiporta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.paiporta.dto.Association;

public class DBManager {
		
	// get all examples
	public ArrayList<Association> getExamples(Connection connection) throws Exception {
		ArrayList<Association> examples = new ArrayList<Association>();
		try	{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM association ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Association ex = new Association();
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setEmail(rs.getString("email"));
				ex.setPhone(rs.getInt("phone"));
				ex.setCity(rs.getString("city"));
				ex.setAddress(rs.getString("address"));
				ex.setPostalcode(rs.getInt("postalcode"));
				ex.setLongitude(rs.getString("longitude"));
				ex.setLatitude(rs.getString("latitude"));
				ex.setWebpage(rs.getString("webpage"));
				ex.setFacebook(rs.getString("facebook"));
				ex.setTwitter(rs.getString("twitter"));
				ex.setPresident_name(rs.getString("president_name"));
				ex.setPresident_email(rs.getString("president_email"));
				ex.setPresident_phone(rs.getInt("president_phone"));
				ex.setSecretary_name(rs.getString("secretary_name"));
				ex.setSecretary_email(rs.getString("secretary_email"));
				ex.setSecretary_phone(rs.getInt("secretary_phone"));
				ex.setActive(rs.getBoolean("active"));
				examples.add(ex);
			}
			return examples;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	// get example by id
	public Association getExampleById(Connection connection, int id) throws Exception {
		Association ex = new Association();
		try	{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM association WHERE id = " + id + " ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setEmail(rs.getString("email"));
				ex.setPhone(rs.getInt("phone"));
				ex.setCity(rs.getString("city"));
				ex.setAddress(rs.getString("address"));
				ex.setPostalcode(rs.getInt("postalcode"));
				ex.setLongitude(rs.getString("longitude"));
				ex.setLatitude(rs.getString("latitude"));
				ex.setWebpage(rs.getString("webpage"));
				ex.setFacebook(rs.getString("facebook"));
				ex.setTwitter(rs.getString("twitter"));
				ex.setPresident_name(rs.getString("president_name"));
				ex.setPresident_email(rs.getString("president_email"));
				ex.setPresident_phone(rs.getInt("president_phone"));
				ex.setSecretary_name(rs.getString("secretary_name"));
				ex.setSecretary_email(rs.getString("secretary_email"));
				ex.setSecretary_phone(rs.getInt("secretary_phone"));
				ex.setActive(rs.getBoolean("active"));
				break;
			}			
		} catch(Exception e) {
			throw e;
		}
		return ex;
	}
	
	// search examples
	public ArrayList<Association> searchExamples(Connection connection, String search) throws Exception {
		ArrayList<Association> examples = new ArrayList<Association>();
		try	{
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM association WHERE name LIKE '%" + search + "%' ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Association ex = new Association();
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setEmail(rs.getString("email"));
				ex.setPhone(rs.getInt("phone"));
				ex.setCity(rs.getString("city"));
				ex.setAddress(rs.getString("address"));
				ex.setPostalcode(rs.getInt("postalcode"));
				ex.setLongitude(rs.getString("longitude"));
				ex.setLatitude(rs.getString("latitude"));
				ex.setWebpage(rs.getString("webpage"));
				ex.setFacebook(rs.getString("facebook"));
				ex.setTwitter(rs.getString("twitter"));
				ex.setPresident_name(rs.getString("president_name"));
				ex.setPresident_email(rs.getString("president_email"));
				ex.setPresident_phone(rs.getInt("president_phone"));
				ex.setSecretary_name(rs.getString("secretary_name"));
				ex.setSecretary_email(rs.getString("secretary_email"));
				ex.setSecretary_phone(rs.getInt("secretary_phone"));
				ex.setActive(rs.getBoolean("active"));
				examples.add(ex);
			}
			return examples;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	// add an example
	public void addExample(Connection connection, Association example) throws Exception {	
		String sql = "INSERT INTO association (id, name, email, phone, address, postalcode, city, longitude, latitude, webpage, facebook, twitter, president_name, president_email, president_phone, secretary_name, secretary_email, active) "
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, example.getId());
		ps.setString(2, example.getName());
		ps.setString(3, example.getEmail());
		ps.setInt(4, example.getPhone());
		ps.setString(5, example.getAddress());
		ps.setInt(6, example.getPostalcode());
		ps.setString(7, example.getCity());
		ps.setString(8, example.getLongitude());
		ps.setString(9, example.getLatitude());
		ps.setString(10, example.getWebpage());
		ps.setString(11, example.getFacebook());
		ps.setString(12, example.getTwitter());
		ps.setString(13, example.getPresident_name());
		ps.setString(14, example.getPresident_email());
		ps.setInt(15, example.getPresident_phone());
		ps.setString(16, example.getSecretary_name());
		ps.setString(17, example.getSecretary_email());
		ps.setInt(18, example.getSecretary_phone());
		ps.setBoolean(19, example.isActive());
		ps.executeUpdate();
	}
	
	// delete an example
	public void deleteExample(Connection connection, int id) throws Exception {	
		String sql = "DELETE FROM association WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	// update an example
	public void updateExample(Connection connection, Association example) throws Exception {	
		String sql = "UPDATE association set president_name = ? AND set president_email AND set president_phone WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, example.getId());
		ps.setString(2, example.getPresident_name());
		ps.setString(3, example.getPresident_email());
		ps.setInt(4, example.getPresident_phone());
		
		ps.executeUpdate();
	}	
}
