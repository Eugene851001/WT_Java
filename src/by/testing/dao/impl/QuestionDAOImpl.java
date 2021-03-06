package by.testing.dao.impl;

import by.testing.dao.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import by.testing.beans.*;

import org.apache.log4j.*;

public class QuestionDAOImpl implements QuestionDAO {

	private ConnectionPool connectionPool;
	private static Logger logger = Logger.getLogger(QuestionDAOImpl.class);
	
	public QuestionDAOImpl() {
		connectionPool = ConnectionPool.getInstance();
	}
	
	@Override
	public Question[] getQuestionsForTest(Test test) throws DAOException {
		Question[] result = null;
		ArrayList<Question> questions = new ArrayList<Question>();
		
		Connection conn = null;
		
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 logger.error("Can not get connection");
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "SELECT * FROM questions WHERE test_test_id=" + test.getId();
	         System.out.println(query);
	         stm.executeQuery(query);
	         
	         ResultSet rs = stm.getResultSet();
	         while(rs.next()) {
	        	 Question question = new Question();
	        	 question.setContent(rs.getString("question_content"));
	        	 questions.add(question);
	         }
	         
	         
		}
		catch(Exception e) {
			logger.error("Error while executing query");
			throw new DAOException("Connection failed...");
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				logger.error("Exception while closing connection");
			}
		}
		result = new Question[questions.size()];
		for(int  i = 0; i < questions.size(); i++) {
			result[i] = questions.get(i);
		}
		return result;
	}

	@Override
	public void addQuestion(Question question, Test test) throws DAOException {
		Connection conn = null;
		
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 logger.error("Can not get connection");
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "INSERT INTO questions VALUE(NULL, '" + question.getContent() + "', " + test.getId() + ")";
	         System.out.println(query);
	         stm.execute(query);
	         
	         
		}
		catch(Exception e) {
			logger.error("Error while executing query");
			throw new DAOException("Connection failed...");
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				logger.error("Exception while closing connection");
			}
		}
		
	}

}
