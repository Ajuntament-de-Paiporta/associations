package es.paiporta.dto;

/*
mysql> use associations;
Database changed
mysql> create table example(id int, data varchar(100));
Query OK, 0 rows affected (0.10 sec)

mysql> insert into example (id, dta) values (1, "hello");
ERROR 1054 (42S22): Unknown column 'dta' in 'field list'
mysql> insert into example (id, data) values (1, "hello");
Query OK, 1 row affected (0.05 sec)

mysql> insert into example (id, data) values (2, "manolo");
Query OK, 1 row affected (0.07 sec)

mysql> insert into example (id, data) values (3, "pepe");
Query OK, 1 row affected (0.06 sec)

mysql> select * from example;
+------+--------+
| id   | data   |
+------+--------+
|    1 | hello  |
|    2 | manolo |
|    3 | pepe   |
+------+--------+
3 rows in set (0.00 sec)
*/

public class Association {
	private int id;
	private String name;
	private String email;
	private int phone;
	private String address;
	private int postalcode;
	private String city;
	private String longitude; // to show on google maps
	private String latitude; // to show on google maps
	private String webpage;
	private String facebook;
	private String twitter;
	private String president_name;
	private String president_email;
	private int president_phone;
	private String secretary_name;
	private String secretary_email;
	private int secretary_phone;
	private boolean active;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getWebpage() {
		return webpage;
	}
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getPresident_name() {
		return president_name;
	}
	public void setPresident_name(String president_name) {
		this.president_name = president_name;
	}
	public String getPresident_email() {
		return president_email;
	}
	public void setPresident_email(String president_email) {
		this.president_email = president_email;
	}
	public int getPresident_phone() {
		return president_phone;
	}
	public void setPresident_phone(int president_phone) {
		this.president_phone = president_phone;
	}
	public String getSecretary_name() {
		return secretary_name;
	}
	public void setSecretary_name(String secretary_name) {
		this.secretary_name = secretary_name;
	}
	public String getSecretary_email() {
		return secretary_email;
	}
	public void setSecretary_email(String secretary_email) {
		this.secretary_email = secretary_email;
	}
	public int getSecretary_phone() {
		return secretary_phone;
	}
	public void setSecretary_phone(int secretary_phone) {
		this.secretary_phone = secretary_phone;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
