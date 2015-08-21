package es.paiporta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.paiporta.dto.Association;

public class DBManager {
		
	// get all examples
	public ArrayList<Association> getAssociations(Connection connection) throws Exception {
		ArrayList<Association> examples = new ArrayList<Association>();
		try	{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM association ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Association ex = new Association();
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setEmail(rs.getString("email"));
				ex.setPhone(rs.getString("phone"));
				ex.setCity(rs.getString("city"));
				ex.setAddress(rs.getString("address"));
				ex.setPostalcode(rs.getString("postalcode"));
				ex.setLongitude(rs.getString("longitude"));
				ex.setLatitude(rs.getString("latitude"));
				ex.setWebpage(rs.getString("webpage"));
				ex.setFacebook(rs.getString("facebook"));
				ex.setTwitter(rs.getString("twitter"));
				ex.setPresidentName(rs.getString("presidentName"));
				ex.setPresidentEmail(rs.getString("presidentEmail"));
				ex.setPresidentPhone(rs.getString("presidentPhone"));
				ex.setSecretaryName(rs.getString("secretaryName"));
				ex.setSecretaryEmail(rs.getString("secretaryEmail"));
				ex.setSecretaryPhone(rs.getString("secretaryPhone"));
				ex.setActive(rs.getBoolean("active"));
				examples.add(ex);
			}
			return examples;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	// get example by id
	public Association getAssociationById(Connection connection, int id) throws Exception {
		Association ex = new Association();
		try	{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM association WHERE id = " + id + " ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setEmail(rs.getString("email"));
				ex.setPhone(rs.getString("phone"));
				ex.setCity(rs.getString("city"));
				ex.setAddress(rs.getString("address"));
				ex.setPostalcode(rs.getString("postalcode"));
				ex.setLongitude(rs.getString("longitude"));
				ex.setLatitude(rs.getString("latitude"));
				ex.setWebpage(rs.getString("webpage"));
				ex.setFacebook(rs.getString("facebook"));
				ex.setTwitter(rs.getString("twitter"));
				ex.setPresidentName(rs.getString("presidentName"));
				ex.setPresidentEmail(rs.getString("presidentEmail"));
				ex.setPresidentPhone(rs.getString("presidentPhone"));
				ex.setSecretaryName(rs.getString("secretaryName"));
				ex.setSecretaryEmail(rs.getString("secretaryEmail"));
				ex.setSecretaryPhone(rs.getString("secretaryPhone"));
				ex.setActive(rs.getBoolean("active"));
				break;
			}			
		} catch(Exception e) {
			throw e;
		}
		return ex;
	}
	
	// search examples
	public ArrayList<Association> searchAssociation(Connection connection, String search) throws Exception {
		ArrayList<Association> examples = new ArrayList<Association>();
		try	{
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM association WHERE name LIKE '%" + search + "%' ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Association ex = new Association();
				ex.setId(rs.getInt("id"));
				ex.setName(rs.getString("name"));
				ex.setEmail(rs.getString("email"));
				ex.setPhone(rs.getString("phone"));
				ex.setCity(rs.getString("city"));
				ex.setAddress(rs.getString("address"));
				ex.setPostalcode(rs.getString("postalcode"));
				ex.setLongitude(rs.getString("longitude"));
				ex.setLatitude(rs.getString("latitude"));
				ex.setWebpage(rs.getString("webpage"));
				ex.setFacebook(rs.getString("facebook"));
				ex.setTwitter(rs.getString("twitter"));
				ex.setPresidentName(rs.getString("presidentName"));
				ex.setPresidentEmail(rs.getString("presidentEmail"));
				ex.setPresidentPhone(rs.getString("presidentPhone"));
				ex.setSecretaryName(rs.getString("secretaryName"));
				ex.setSecretaryEmail(rs.getString("secretaryEmail"));
				ex.setSecretaryPhone(rs.getString("secretaryPhone"));
				ex.setActive(rs.getBoolean("active"));
				examples.add(ex);
			}
			return examples;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	// add an example
	public void addAssociation(Connection connection, Association example) throws Exception {	
		String sql = "INSERT INTO association (name, email, phone, address, postalcode, city, longitude, latitude, webpage, facebook, twitter, presidentName, presidentEmail, presidentPhone, secretaryName, secretaryEmail, secretaryPhone, active) "
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		//ps.setInt(1, example.getId());
		ps.setString(1, example.getName());
		ps.setString(2, example.getEmail());
		ps.setString(3, example.getPhone());
		ps.setString(4, example.getAddress());
		ps.setString(5, example.getPostalcode());
		ps.setString(6, example.getCity());
		ps.setString(7, example.getLongitude());
		ps.setString(8, example.getLatitude());
		ps.setString(9, example.getWebpage());
		ps.setString(10, example.getFacebook());
		ps.setString(11, example.getTwitter());
		ps.setString(12, example.getPresidentName());
		ps.setString(13, example.getPresidentEmail());
		ps.setString(14, example.getPresidentPhone());
		ps.setString(15, example.getSecretaryName());
		ps.setString(16, example.getSecretaryEmail());
		ps.setString(17, example.getSecretaryPhone());
		ps.setBoolean(18, example.isActive());
		ps.executeUpdate();
	}
	
	// delete an example
	public void deleteAssociation(Connection connection, int id) throws Exception {	
		String sql = "DELETE FROM association WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	// update an example
	public void updateAssociation(Connection connection, Association example) throws Exception {	
		String sql = "UPDATE association set presidentName = ? AND set presidentEmail AND set presidentPhone WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, example.getId());
		ps.setString(2, example.getPresidentName());
		ps.setString(3, example.getPresidentEmail());
		ps.setString(4, example.getPresidentPhone());
		
		ps.executeUpdate();
	}	
}
