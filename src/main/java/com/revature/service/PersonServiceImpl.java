package com.revature.service;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.PersonDaoPostgres;
import com.revature.dto.PersonInfo;
import com.revature.pojo.Person;

public class PersonServiceImpl implements PersonService {
	
	Logger log = Logger.getRootLogger();
	private PersonDaoPostgres personDao;
	private Connection conn;
	
	
	
	

	public PersonServiceImpl(PersonDaoPostgres personDao, Connection conn) {
		super();
		this.personDao = personDao;
		this.conn = conn;
		this.personDao.setConn(conn);
	}

	@Override
	public void insertPerson(Person person) {
		log.info("PersonServiceImpl.insertPerson()");
		personDao.insertPerson(person);

	}

	@Override
	public void addRelative(int personId, int relativeId, int relationTypeId) {
		log.info("PersonServiceImpl.addRelative()");
		personDao.addRelative(personId, relativeId, relationTypeId);

	}

	@Override
	public int getPersonIdByName(Person person) {
		
		log.info("PersonServiceImpl.getPersonIdByName()");
		int pId = personDao.getPersonIdByName(person);
		return pId;
	}

	@Override
	public List<PersonInfo> getPersonInfo(int personId) {
		log.info("PersonServiceImpl.getPersonInfo()");
		List<PersonInfo> personInfo = personDao.getPersonInfo(personId);
		
		return personInfo;
	}

	@Override
	public int getRelationTypeIdByName(String relationType) {
		log.info("PersonServiceImpl.getRelationTypeIdByName()");
		int relationTypeId  =personDao.getRelationTypeIdByName(relationType);
		
		return relationTypeId;
	}

	@Override
	public boolean updateRelationShipType(int personId, int relativeId, int relationTypeId) {
		
		return personDao.updateRelationShipType(personId, relativeId, relationTypeId);
	}

}
