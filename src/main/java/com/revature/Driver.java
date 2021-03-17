package com.revature;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.PersonDaoPostgres;
import com.revature.dto.PersonInfo;
import com.revature.pojo.Person;
import com.revature.service.PersonServiceImpl;
import com.revature.util.ConnectionFactoryPostgres;

public class Driver {
	
	public static Scanner scanner = new Scanner(System.in);
	private static Connection connection = ConnectionFactoryPostgres.getConnection();

	public static void main(String[] args) {

		System.out.println("\t------------             Famil Tree Application          ------------");
		System.out.println("\t------------    -------------------------------------     ------------");
		System.out.println("\t------------    -------------------------------------     ------------");
		
		PersonDaoPostgres personDao = new PersonDaoPostgres();
		PersonServiceImpl personService = new PersonServiceImpl(personDao, connection);
		
		printMenu();
		
		Person person = null;
		Person relative = null;
		
		List<PersonInfo> personInfo = null;
		
		boolean logout = false;
		
		while(!logout) {
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch (action) {
			case 0:
				System.out.println("You are successfully logout. Thank you!");
				logout = true;
				break;
			case 1:
				System.out.println("********** ADD PERSON ******************");
				System.out.println("Please enter person first name:");
				String firstName = scanner.nextLine();
				System.out.println("Please enter person last name:");
				String lastName =scanner.nextLine();
				person = new Person(firstName, lastName);
				personService.insertPerson(person);
				printMenu();
				break;
			case 2:
				if(person == null) {
					System.out.println("Please enter person first name:");
					String firstName2 = scanner.nextLine();
					System.out.println("Please enter person last name:");
					String lastName2 =scanner.nextLine();
					person = new Person(firstName2, lastName2);
				}
				System.out.println("********** ADD RELATIVE ******************");
				System.out.println("Please enter relative first name:");
				String relativeFirstName = scanner.nextLine();
				System.out.println("Please enter relative last name:");
				String relativeLastName =scanner.nextLine();
				System.out.println("Please enter relationship:");
				String relationship =scanner.nextLine();
				relative = new Person(relativeFirstName, relativeLastName);
				personService.insertPerson(relative);
				
				int relationTypeId = personService.getRelationTypeIdByName(relationship);
				int personId = personService.getPersonIdByName(person);
				int relativeId = personService.getPersonIdByName(relative);
				
				personDao.addRelative(personId, relativeId, relationTypeId);
				
				printMenu();
				break;
			case 3:
				if(person == null) {
					System.out.println("Please enter person first name:");
					String firstName2 = scanner.nextLine();
					System.out.println("Please enter person last name:");
					String lastName2 =scanner.nextLine();
					person = new Person(firstName2, lastName2);
				}
				System.out.println("********** UPDATE RELATIONSHIP ******************");
				System.out.println("Please enter relative first name:");
				String relativeFirstName1 = scanner.nextLine();
				System.out.println("Please enter relative last name:");
				String relativeLastName1 =scanner.nextLine();
				System.out.println("Please enter new relationship:");
				String relationship1 =scanner.nextLine();
				int relationTypeId1 = personService.getRelationTypeIdByName(relationship1);
				Person relativePerson = new Person(relativeFirstName1, relativeLastName1);
				int personId1 = personService.getPersonIdByName(person);
				int relativeId1 = personService.getPersonIdByName(relativePerson);
				if (personService.updateRelationShipType(personId1, relativeId1, relationTypeId1)){
					System.out.println("Relationship updated successfully!");
				}
				printMenu();
			case 4:
				System.out.println("********** SEE PERSON INFO ******************");
				int personId2 = personService.getPersonIdByName(person);
				personInfo = personService.getPersonInfo(personId2);
				
				for(PersonInfo p : personInfo) {
					System.out.println(p);
				}
				printMenu();
			case 9:
				printMenu();
				break;
			}
			
		}
		
		
	}
	private static void printMenu() {
		System.out.println("Available actions:\npress");
		System.out.println("0 - to quit\n" + "1 - Add person\n"
							+ "2 - Add relative\n"
							+ "3 - Update relationship\n" 
							+ "4 - See person info\n"
							+ "9 - Print available actions");

	}
	

}
