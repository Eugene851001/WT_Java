package by.testing.beans;

import java.io.Serializable;

public class Test implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int subjectFieldId;
	private int userId;
	
	public Test() {
		
	}
	
	public Test(int id, String name, int subjectFieldId, int userId) {
		this.id = id;
		this.name = name;
		this.subjectFieldId = subjectFieldId;
		this.userId = userId;
	}
	
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
	
	public int getSubjectFieldId() {
		return subjectFieldId;
	}
	
	public void setSubjectFieldId(int subjectFieldId) {
		this.subjectFieldId = subjectFieldId;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	

}
