package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOAddress extends DAO{

	public DAOAddress() {
        super();
    }
	
	public String addAddress(Address address){
		String result = null;
		String rq = "INSERT INTO ADDRESS  (street, city, zip, country) VALUES(?, ?, ?, ?);";
		try{
			
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
	
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getZip());
			preparedStatement.setString(4, address.getCountry());
			
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
	public String alterAddress(Address address){
		String result = null;
		String rq = "UPDATE ADDRESS SET street = ?, city = ? , zip = ?, country = ? WHERE ID = ?;";
		
		try{
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getZip());
			preparedStatement.setString(4, address.getCountry());
			
			preparedStatement.setLong(5, address.getAddressId());
			
			
			super.getPreparedStatement().executeUpdate();
			
			super.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public Address getAdress(long id){
		Address a = new Address(id);
		
		
		String rq = "SELECT * FROM ADDRESS WHERE ID = ? ;";
		try{
			
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setLong(1, id);
			super.setPreparedStatement(preparedStatement);
			ResultSet result = super.getPreparedStatement().executeQuery();
			
			while(result.next()){
				a.setCity(result.getString("city"));
				a.setCountry(result.getString("country"));
				a.setZip(result.getString("zip"));
				a.setStreet(result.getString("street"));
				
			}
			super.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	public List<Address> getListAddress(){
		List<Address> listAddress= new ArrayList<Address>();
		ResultSet result = null;
		String rq = "SELECT * FROM ADDRESS ;";
		try{
			super.setPreparedStatement(super.getContext().prepareStatement(rq));
			result = super.getPreparedStatement().executeQuery();
			
			while(result.next()){
				Address a = new Address(result.getLong("id"),result.getString("street"),result.getString("city"),result.getString("zip"),result.getString("country"));
				
				listAddress.add(a);
			}
			
			
			super.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listAddress;
	}
	
	public String removeAddress(Address address){
		String result = null;
		String rq = "DELETE FROM ADDRESS WHERE ID="+address.getAddressId()+";";
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

}
