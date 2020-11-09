package by.testing.beans;

import java.io.Serializable;

public class SubjectField implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005675855144441419L;
	
	private int id;
	private String name;
	private String description;
	
	
	public SubjectField() {
		
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
		this.name=  name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
