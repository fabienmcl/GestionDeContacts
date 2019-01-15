package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DAO {
	
	private Session session;
	private Transaction transaction;
	
	DAO(){
		super();
		try {
			this.transaction = null;
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }catch (Exception e) {
        	this.session = null;
            e.printStackTrace();
        }
	}
	
	public Session getSession(){
		return this.session;
	}
	public void open(){
		try{
			this.transaction = this.session.beginTransaction();
		}catch (Exception e) {
        	e.printStackTrace();
        }
	}
	public void close(){
		try{
			this.transaction.commit();
		}catch(Exception e) {
            e.printStackTrace();
        }
		this.transaction=null;
	}
	
}
