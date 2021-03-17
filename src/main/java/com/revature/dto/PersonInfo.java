package com.revature.dto;

public class PersonInfo {
	
	private String firstName;
	private String lastName;
	private String relativeFirstName;
	private String relativeLastName;
	private String relationType;
	public String getFirstName() {
		return firstName;
	}
	
	
	
	public PersonInfo(String firstName, String lastName, String relativeFirstName, String relativeLastName,
			String relationType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.relativeFirstName = relativeFirstName;
		this.relativeLastName = relativeLastName;
		this.relationType = relationType;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRelativeFirstName() {
		return relativeFirstName;
	}
	public void setRelativeFirstName(String relativeFirstName) {
		this.relativeFirstName = relativeFirstName;
	}
	public String getRelativeLastName() {
		return relativeLastName;
	}
	public void setRelativeLastName(String relativeLastName) {
		this.relativeLastName = relativeLastName;
	}
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	@Override
	public String toString() {
		return "PersonInfo [First Name=" + getFirstName() + ", Last Name=" + getLastName() + ", Relative First Name=" + getRelativeFirstName() + 
				 ", Relative Last Name=" + getRelativeLastName() + ", Relationship Type=" + getRelationType() + "   ]";
	}
	
	
	
}

