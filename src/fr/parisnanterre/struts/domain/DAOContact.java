package fr.parisnanterre.struts.domain;

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



public class DAOContact {
	
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
	List<Contact> contacts;
	
	
	public Long countContact() throws SQLException{
		Long size = (long) 0;
		Context lContext;
		try {
			lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection  = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementCreation = 
			lConnection.prepareStatement("SELECT MAX(ID_CONTACT) AS SIZE FROM CONTACT");
			
			
			ResultSet result = lPreparedStatementCreation.executeQuery();
			while(result.next()){
				
				try {
					size = Long.parseLong(result.getString("SIZE"));
					size++;
					return size;
			    } catch (NumberFormatException e) {
			       return size;
			    }
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
		
		
	}
	
	public String addContact(final long id, final String firstName, final String lastName, final String email) {
		
		try {
			countContact();
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection  = lDataSource.getConnection();
			
			// adding a new contact
			final PreparedStatement lPreparedStatementCreation = 
					
			lConnection.prepareStatement("INSERT INTO CONTACT(ID_CONTACT, FIRSTNAME, LASTNAME, EMAIL) VALUES(?, ?, ?, ?)");
			
			lPreparedStatementCreation.setLong(1, countContact());
			lPreparedStatementCreation.setString(2, firstName);
			lPreparedStatementCreation.setString(3, lastName);
			lPreparedStatementCreation.setString(4, email);
			lPreparedStatementCreation.executeUpdate();
			
			return null;
		} catch (NamingException e) {
		
			return "NamingException : " + e.getMessage();
		
		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();
			
		}
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
	public String removeContact(final long id, final String email){
		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection  = lDataSource.getConnection();
			System.out.println("je suis dans remove conatct dao");
			// removing a new contact
			String rq = "DELETE FROM CONTACT WHERE ID_CONTACT="+id+" AND EMAIL='"+email+"'";
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement(rq);

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
