package fr.parisnanterre.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
	
	private Connection  context;
	private DataSource dataSource;
	private PreparedStatement preparedStatement;
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
	
	DAO(){
		super();
		context = null;
		dataSource = getDataSource(); 
		preparedStatement = null;
	}
	
	

	public Connection getContext() {
		this.openContext();
		if (this.context == null){
				this.openContext();
		}
		return context;
	}

	public void setContext(Connection context) {
		this.context = context;
	}
	private void openContext(){
		try {
			this.context = this.dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void closeContext() {
    	try {
    		if(this.context!=null){
        		this.context.close();
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

	public DataSource getDataSource() {
		DataSource ldataSource = null;
		try {
			Context lcontext = new InitialContext();
			ldataSource = (DataSource) lcontext.lookup(RESOURCE_JDBC);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
		return ldataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
	
	public void close(){
		try {
			if (this.preparedStatement != null) {
				this.preparedStatement.close();
			}
		}catch (Exception e) { 
			throw new RuntimeException(e); 
		}
		this.closeContext();
	}

}
