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

public class Example {
	private int id;
	private String data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
