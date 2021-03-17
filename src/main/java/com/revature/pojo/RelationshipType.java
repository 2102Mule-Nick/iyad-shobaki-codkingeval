package com.revature.pojo;

public class RelationshipType {

	private  int relationId;
	private String relationType;
	
	
	public RelationshipType(String relationType) {
		super();
		this.relationType = relationType;
	}


	public RelationshipType(int relationId, String relationType) {
		super();
		this.relationId = relationId;
		this.relationType = relationType;
	}


	public int getRelationId() {
		return relationId;
	}



	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}



	public String getRelationType() {
		return relationType;
	}


	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	
	
	
}
