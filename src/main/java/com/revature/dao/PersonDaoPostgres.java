package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dto.PersonInfo;
import com.revature.pojo.Person;
import com.revature.util.ConnectionFactoryPostgres;

public class PersonDaoPostgres implements PersonDao {

	Logger log = Logger.getRootLogger();

	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertPerson(Person person) {

		log.info("PersonDaoPostgres.insertPerson()");


		String sql = "insert into person (first_name, last_name) values (? , ? )";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.warn("SQL Exeption Error " + e.getMessage());
		}

	}

	@Override
	public void addRelative(int personId, int relativeId, int relationTypeId) {
		log.info("PersonDaoPostgres.addRelative()");


		String sql = "insert into relationships (person1_id, person2_id, relation_id) values (? , ?, ? )";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, personId);
			stmt.setInt(2, relativeId);
			stmt.setInt(3, relationTypeId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.warn("SQL Exeption Error " + e.getMessage());
		}

	}

	@Override
	public List<PersonInfo> getPersonInfo(int personId) {
		
		log.info("PersonDaoPostgres.getPersonInfo()");


		String sql = "select p.first_name, p.last_name, p2.first_name as relative_first_name, p2.last_name as relative_last_name, rt.relation_type "
				+ "from relationships rs inner join person p on p.person_id = rs.person1_id "
				+ "inner join person p2 on p2.person_id = rs.person2_id "
				+ "inner join relationship_type rt on rs.relation_id = rt.relation_id where person1_id = ?";

		List<PersonInfo> personInfo = null;
		PersonInfo pInfo = null;
		
		PreparedStatement stmt;
		try {
			personInfo =  new ArrayList<>();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, personId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				pInfo = new PersonInfo(rs.getString("first_name"), rs.getString("last_name"), rs.getString("relative_first_name"),
						rs.getString("relative_last_name"), rs.getString("relation_type"));
				
				personInfo.add(pInfo);
			}
		} catch (SQLException e) {
			log.warn("SQL Exeption Error " + e.getMessage());
		}
		return personInfo;
	}

	@Override
	public int getPersonIdByName(Person person) {
		
		log.info("PersonDaoPostgres.getPersonIdByName()");


		String sql = "select person_id from person where first_name = ? and last_name = ?";

		int personId = 0;
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				personId = rs.getInt("person_id");
			}
			
		} catch (SQLException e) {
			log.warn("SQL Exeption Error " + e.getMessage());
		}
		
		return personId;
	}

	@Override
	public int getRelationTypeIdByName(String relationType) {
		
		log.info("PersonDaoPostgres.getPersonIdByName()");


		String sql = "select relation_id from relationship_type where relation_type = ?";

		int relationId = 0;
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, relationType);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				relationId = rs.getInt("relation_id");
			}
			
		} catch (SQLException e) {
			log.warn("SQL Exeption Error " + e.getMessage());
		}
		
		return relationId;
	}

	@Override
	public boolean updateRelationShipType(int personId, int relativeId, int relationTypeId) {
		
		log.info("PersonDaoPostgres.updateRelationShipType()");


		String sql = "update relationships set relation_id = ? where person1_id = ? and person2_id = ?;";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, relationTypeId);
			stmt.setInt(2, personId);
			stmt.setInt(3, relativeId);
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			log.warn("SQL Exeption Error " + e.getMessage());
		}
		return false;
	}

}
