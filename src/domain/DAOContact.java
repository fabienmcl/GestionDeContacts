package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DAOContact extends DAO {
	
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
	List<Contact> contacts;
	
	
	public DAOContact() {
        super();
    }
	
	public String addContact(final long id, final String firstName, final String lastName, final String email) {
		String result = null;
		String rq = "INSERT INTO CONTACT(FIRSTNAME, LASTNAME, EMAIL) VALUES(?, ?, ?)";
		try{
			
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			super.setPreparedStatement(preparedStatement);
			super.getPreparedStatement().executeUpdate();
			super.close();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
		
	}
	
	public String removeContact(final long id, final String email){
		String result = null;
		String rq = "DELETE FROM CONTACT WHERE ID_CONTACT="+id+" AND EMAIL='"+email+"'";
		try{
			super.setPreparedStatement(super.getContext().prepareStatement(rq));
			super.getPreparedStatement().executeUpdate();
			super.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public Contact getContact(final long id){
		Contact c = new Contact(id);
		
		String rq = "SELECT * FROM CONTACT WHERE ID_CONTACT= ? ;";
		try{
			
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setLong(1, id);
			super.setPreparedStatement(preparedStatement);
			ResultSet result = super.getPreparedStatement().executeQuery();
			
			while(result.next()){
				c.setFirstName(result.getString("FIRSTNAME"));
				c.setLastName(result.getString("LASTNAME"));
				c.setEmail(result.getString("EMAIL"));
			}
			super.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public String alterContact(final long id, final String firstName, final String lastName, final String email) {
		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection  = lDataSource.getConnection();
			
			// adding a new contact
			final PreparedStatement lPreparedStatementCreation = 
					lConnection.prepareStatement("UPDATE CONTACT SET FIRSTNAME='"+firstName+"', LASTNAME='"+lastName+"', EMAIL='"+email+"' WHERE ID_CONTACT="+id+"");
			
			lPreparedStatementCreation.executeUpdate();
			
			return null;
		} catch (NamingException e) {
		
			return "NamingException : " + e.getMessage();
		
		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();
			
		}
	}
	
	public List<Contact> searchContact(String element){
		System.out.println("step 1 : DAOContact entree dans search");
		try {
			final Context lContext = new InitialContext();
			System.out.println("step 2 : DAOContact init context");
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			System.out.println("step 3 : DAOContact init sourcce");
			final Connection lConnection  = lDataSource.getConnection();
			System.out.println("step 4 : DAOContact init connection");
			
			String rqFN = "SELECT * FROM CONTACT WHERE FIRSTNAME='"+element+"'";
			String rqLN = "SELECT * FROM CONTACT WHERE LASTNAME='"+element+"'";
			String rqEmail = "SELECT * FROM CONTACT WHERE EMAIL='"+element+"'";
			
			contacts = new ArrayList<Contact>();
			
			System.out.println("step 5 : DAOContact init rq ok");

			
			
			PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement(rqFN);
			System.out.println("step 6 : DAOContact prepare statement");
			ResultSet result = lPreparedStatementCreation.executeQuery();
			System.out.println("step 7 : DAOContact execute query");
			
			System.out.println("step 8 : DAOContact list contact : ");
			
			
			while(result.next()){
				System.out.print("- "+result.getString("id_contact")+", ");
				System.out.print(result.getString("firstname")+", ");
				System.out.print(result.getString("lastname")+", ");
				System.out.println(result.getString("email"));
				Contact c = new Contact(Long.parseLong(
								result.getString("id_contact")),
								result.getString("firstname"),
								result.getString("lastname"),
								result.getString("email"));
				System.out.println(c.toString());
				
				if(!isNotInList(contacts,c)){
					contacts.add(c);
				}
				
			
			}
			lPreparedStatementCreation = lConnection.prepareStatement(rqLN);
			System.out.println("step 6 : DAOContact prepare statement");
			result = lPreparedStatementCreation.executeQuery();
			System.out.println("step 7 : DAOContact execute query");
			
			System.out.println("step 8 : DAOContact list contact : ");
			
			
			while(result.next()){
				System.out.print("- "+result.getString("id_contact")+", ");
				System.out.print(result.getString("firstname")+", ");
				System.out.print(result.getString("lastname")+", ");
				System.out.println(result.getString("email"));
				Contact c = new Contact(Long.parseLong(
								result.getString("id_contact")),
								result.getString("firstname"),
								result.getString("lastname"),
								result.getString("email"));
				System.out.println(c.toString());
				
				if(!isNotInList(contacts,c)){
					contacts.add(c);
				}
				
			
			}
			lPreparedStatementCreation = lConnection.prepareStatement(rqEmail);
			System.out.println("step 6 : DAOContact prepare statement");
			result = lPreparedStatementCreation.executeQuery();
			System.out.println("step 7 : DAOContact execute query");
			
			System.out.println("step 8 : DAOContact list contact : ");
			
			
			while(result.next()){
				System.out.print("- "+result.getString("id_contact")+", ");
				System.out.print(result.getString("firstname")+", ");
				System.out.print(result.getString("lastname")+", ");
				System.out.println(result.getString("email"));
				Contact c = new Contact(Long.parseLong(
								result.getString("id_contact")),
								result.getString("firstname"),
								result.getString("lastname"),
								result.getString("email"));
				System.out.println(c.toString());
				
				if(!isNotInList(contacts,c)){
					contacts.add(c);
				}
				
			
			}
			return contacts;
		} catch (NamingException e) {
			System.out.println("NamingException : " + e.getMessage());
			return null;

		} catch (SQLException e) {

			System.out.println("SQLException : " + e.getMessage());
			return null;
		}
	}

	public List<Contact> getListContact()  {
		System.out.println("step 1 : DAOContact entree dans getListcontact");
		try {
			final Context lContext = new InitialContext();
			System.out.println("step 2 : DAOContact init context");
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			System.out.println("step 3 : DAOContact init sourcce");
			final Connection lConnection  = lDataSource.getConnection();
			System.out.println("step 4 : DAOContact init connection");
			
			String requete ="SELECT * FROM CONTACT";
			contacts = new ArrayList<Contact>();
			
			System.out.println("step 5 : DAOContact init rq ok");

			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement(requete);
			System.out.println("step 6 : DAOContact prepare statement");
			ResultSet result = lPreparedStatementCreation.executeQuery();
			System.out.println("step 7 : DAOContact execute query");
			
			System.out.println("step 8 : DAOContact list contact : ");
			
			System.out.println(result);
			
			while(result.next()){
				System.out.print("- "+result.getString("id_contact")+", ");
				System.out.print(result.getString("firstname")+", ");
				System.out.print(result.getString("lastname")+", ");
				System.out.println(result.getString("email"));
				Contact c = new Contact(Long.parseLong(
								result.getString("id_contact")),
								result.getString("firstname"),
								result.getString("lastname"),
								result.getString("email"));
				System.out.println(c.toString());
				
				contacts.add(c);
				
			
			}

			return contacts;
		} catch (NamingException e) {
			System.out.println("NamingException : " + e.getMessage());
			return null;

		} catch (SQLException e) {

			System.out.println("SQLException : " + e.getMessage());
			return null;
		}
	}
	
	public boolean isNotInList(List<Contact> l, Contact c){
		for(int i=0;i<l.size();i++){
			if(c.getId() == l.get(i).getId()){
				return true;
			}
		}
		return false;
	}
	
}
