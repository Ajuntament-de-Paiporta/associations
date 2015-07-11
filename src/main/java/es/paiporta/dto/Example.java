package es.paiporta.dto;

/*
 
mysql> create database associations;
Query OK, 1 row affected (0.00 sec)

mysql> use associations;
Database changed

mysql> create user 'admin_assoc'@'localhost' identified by 'assoc2015';
Query OK, 0 rows affected (0.00 sec)

mysql> grant all on associations.* to 'admin_assoc'@'localhost';
Query OK, 0 rows affected (0.00 sec)

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

mysql> create table users(id int auto_increment, email varchar(256), password varchar(100), rol int, token_id varchar(100), token_creation_time timestamp, primary key (id));
Query OK, 0 rows affected (0.07 sec)

mysql> describe users;
+---------------------+--------------+------+-----+-------------------+-----------------------------+
| Field               | Type         | Null | Key | Default           | Extra                       |
+---------------------+--------------+------+-----+-------------------+-----------------------------+
| id                  | int(11)      | NO   | PRI | NULL              | auto_increment              |
| email               | varchar(256) | YES  |     | NULL              |                             |
| password            | varchar(100) | YES  |     | NULL              |                             |
| rol                 | int(11)      | YES  |     | NULL              |                             |
| token_id            | varchar(100) | YES  |     | NULL              |                             |
| token_creation_time | timestamp    | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
+---------------------+--------------+------+-----+-------------------+-----------------------------+
6 rows in set (0.00 sec)

mysql> insert into users(email, password, rol) values ("joaquintarraga@gmail.com", sha1("toto"), 1);
Query OK, 1 row affected (0.04 sec)

mysql> select * from users;
+----+--------------------------+------------------------------------------+------+----------+---------------------+
| id | email                    | password                                 | rol  | token_id | token_creation_time |
+----+--------------------------+------------------------------------------+------+----------+---------------------+
|  1 | joaquintarraga@gmail.com | 0b9c2625dc21ef05f6ad4ddf47c5f203837aa32c |    1 | NULL     | 2015-07-11 09:28:12 |
+----+--------------------------+------------------------------------------+------+----------+---------------------+
1 row in set (0.00 sec)

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
