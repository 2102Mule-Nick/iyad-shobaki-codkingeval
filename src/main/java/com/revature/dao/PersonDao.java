package com.revature.dao;

import java.util.List;

import com.revature.dto.PersonInfo;
import com.revature.pojo.Person;

public interface PersonDao {
	
	public void insertPerson(Person person);
	public void addRelative(int personId, int relativeId, int relationTypeId);
	
	public int getPersonIdByName(Person person);
	public List<PersonInfo> getPersonInfo(int personId);
	
	public int getRelationTypeIdByName(String relationType); 
	
	public boolean updateRelationShipType(int personId, int relativeId, int relationTypeId);
	
}
