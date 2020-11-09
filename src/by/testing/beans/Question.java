package by.testing.beans;

import java.io.Serializable;

public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9145427175065788168L;

	private int id;
	private String content;
	private int testId;
	
	public Question() {
		
	}
	
	public Question(int id, String content, int testId) {
		this.id = id;
		this.content = content;
		this.testId = testId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getTestId() {
		return testId;
	}
	
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
}
