package by.testing.service;

import by.testing.service.impl.*;

public class ServiceProvider {

	private static ServiceProvider instance = null;
	
	private ClientService clientService = null;
	private TestService testService = null;
	private QuestionService questionService = null;
	
	private ServiceProvider() {
		clientService = new ClientServiceImpl();
		testService = new TestServiceImpl(); 
		questionService = new QuestionServiceImpl();
	}
	
	public static ServiceProvider getInstance() {
		if(instance == null) {
			instance = new ServiceProvider();
		}
		return instance;
	}
	
	public ClientService getClientService() {
		return clientService;
	}
	
	public TestService getTestService() {
		return testService;
	}
	
	public QuestionService getQuestionService() {
		return questionService;
	}
	
}
