package es.paiporta.dto;

/*
 
mysql> create database associations;
Query OK, 1 row affected (0.00 sec)

mysql> use associations;
Database changed

mysql> create table examples(id int auto_increment, name varchar(100), telf int, primary key (id));
Query OK, 0 rows affected (0.07 sec)

mysql> insert into examples (name, telf) values ("pepe", 123456789);
Query OK, 1 row affected (0.04 sec)

mysql> insert into examples (name, telf) values ("manolo", 987654321);
Query OK, 1 row affected (0.05 sec)

mysql> select * from examples;
+----+--------+-----------+
| id | name   | telf      |
+----+--------+-----------+
|  1 | pepe   | 123456789 |
|  2 | manolo | 987654321 |
+----+--------+-----------+
2 rows in set (0.00 sec)
*/

public class Example {
	private int id;
	private String name;
	private int telf;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTelf() {
		return telf;
	}
	public void setTelf(int telf) {
		this.telf = telf;
	}
}
