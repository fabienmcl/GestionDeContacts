package domain;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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


public class DAOEntreprise extends DAO{
	
	public DAOEntreprise() {
        super();
    }
	
	public String addEntreprise(Entreprise entreprise){
		String result = null;
		String rq = "INSERT INTO ENTREPRISE (numSiret) VALUES(?) ;";
		try{
			
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setInt(1, entreprise.getNumSiret());
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
	public String alterEntreprise(Entreprise entreprise){
		String result = null;
		String rq = "UPDATE ENTREPRISE SET numSiret = ? WHERE ID = ?;";
		
		try{
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setInt(1, entreprise.getNumSiret());
			preparedStatement.setLong(2, entreprise.getId());
			
			super.getPreparedStatement().executeUpdate();
			
			super.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public Entreprise getEntreprise(int id){
		Entreprise ent = new Entreprise();
		
		String rq = "SELECT * FROM ENTREPRISE WHERE ID = ? ;";
		try{
			
			super.setPreparedStatement(super.getContext().prepareStatement(rq, Statement.RETURN_GENERATED_KEYS));
			PreparedStatement preparedStatement = super.getPreparedStatement();
			preparedStatement.setLong(1, id);
			super.setPreparedStatement(preparedStatement);
			ResultSet result = super.getPreparedStatement().executeQuery();
			
			while(result.next()){
				ent.setNumSiret(result.getInt("numSiret"));
			}
			super.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ent;
	}
	public List<Entreprise> getListEntreprise(){
		List<Entreprise> listEntreprises = new ArrayList<Entreprise>();
		ResultSet result = null;
		String rq = "SELECT * FROM ENTREPRISE ;";
		try{
			super.setPreparedStatement(super.getContext().prepareStatement(rq));
			result = super.getPreparedStatement().executeQuery();
			
			while(result.next()){
				Entreprise ent = new Entreprise(result.getInt("numSiret"));
				listEntreprises.add(ent);
			}
			
			
			super.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listEntreprises;
	}
	

}
