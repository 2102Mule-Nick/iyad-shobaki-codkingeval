package com.revature.pojo;

public class Relationships {
	
	private int relationshipsId;
	private int person1Id;
	private int person2Id;
	private int relationTypeId;
	
	
	
	public Relationships(int person1Id, int person2Id, int relationTypeId) {
		super();
		this.person1Id = person1Id;
		this.person2Id = person2Id;
		this.relationTypeId = relationTypeId;
	}



	public Relationships(int relationshipsId, int person1Id, int person2Id, int relationTypeId) {
		super();
		this.relationshipsId = relationshipsId;
		this.person1Id = person1Id;
		this.person2Id = person2Id;
		this.relationTypeId = relationTypeId;
	}


	public int getRelationshipsId() {
		return relationshipsId;
	}



	public void setRelationshipsId(int relationshipsId) {
		this.relationshipsId = relationshipsId;
	}



	public int getPerson1Id() {
		return person1Id;
	}



	public void setPerson1Id(int person1Id) {
		this.person1Id = person1Id;
	}



	public int getPerson2Id() {
		return person2Id;
	}



	public void setPerson2Id(int person2Id) {
		this.person2Id = person2Id;
	}



	public int getRelationTypeId() {
		return relationTypeId;
	}



	public void setRelationTypeId(int relationTypeId) {
		this.relationTypeId = relationTypeId;
	}
	
	
	
	
}
