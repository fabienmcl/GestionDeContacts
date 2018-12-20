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
	
	
	public DAOContact() {
        super();
    }
	
	public String addContact(Contact contact) {
		String result = null;
		String rq = "INSERT INTO CONTACT(FIRSTNAME, LASTNAME, EMAIL) VALUES(?, ?, ?)";
		try{
			
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setString(1, contact.getFirstName());
			preparedStatement.setString(2, contact.getLastName());
			preparedStatement.setString(3, contact.getEmail());
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
		String rq = "DELETE FROM CONTACT WHERE ID_CONTACT="+id+" AND EMAIL='"+email+"' ;";
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
		String result = null;
		String rq = "UPDATE contact SET firstName = ?, lastName = ?, email = ? WHERE ID_CONTACT = ?;";
		
		try{
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, id);
			
			super.getPreparedStatement().executeUpdate();
			
			super.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Contact> getListContact(){
		List<Contact> listContacts = new ArrayList<Contact>();
		ResultSet result = null;
		String rq = "SELECT * FROM CONTACT ;";
		try{
			super.setPreparedStatement(super.getContext().prepareStatement(rq));
			result = super.getPreparedStatement().executeQuery();
			
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
				
				listContacts.add(c);
				
			
			}
			
			
			super.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(listContacts.isEmpty()==true){
			listContacts.add(new Contact());
		}
		return listContacts;
	}
	
	
}
