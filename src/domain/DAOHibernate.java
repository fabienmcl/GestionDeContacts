package domain;


import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DAOHibernate {
	
	private Session session;
	private Transaction tansaction;
	
	DAOHibernate(){
		super();
	    try {
	    	this.session = HibernateUtil.getSessionFactory().getCurrentSession();
	        this.tansaction = null;
	    } catch (Exception e) {
	    	this.session = null;
	        e.printStackTrace();
	    }
	}
	

	public void open(){
		try {
			this.tansaction = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public void close(){
		try {
            this.tansaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		//this.tansaction = null;
	}
	
	public Session getSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
