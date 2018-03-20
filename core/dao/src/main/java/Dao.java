import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dao {
	
	public Dao() {}
	
	
	public static <T> void create(final T object) {
	   	Session session = HibernateSession.getSession();
	   	Transaction transaction = session.beginTransaction();
	   	try {
		   	session.save(object);
			transaction.commit();
		} catch (HibernateException e) {
        	if (transaction!=null) {
        		transaction.rollback();	
        	}
        	e.printStackTrace(); 
     	} finally {
        	session.close(); 
      	}
  	}

  	public static <T> void delete(final T object) {
  		Session session = HibernateSession.getSession();
  		Transaction transaction = session.beginTransaction();
	  	try{
	  		session.update(object);
	  		session.delete(object);
	  		transaction.commit();
	  	} catch (HibernateException e) {
        	if (transaction!=null) {
        		transaction.rollback();	
        	}
        	e.printStackTrace(); 
     	} finally {
        	session.close(); 
      	}
  	}

  	public static <T> void update(final T object) {
  		Session session = HibernateSession.getSession();
  		Transaction transaction = session.beginTransaction();
	  	try{
	  		session.update(object);
	  		session.getTransaction().commit();
	  	} catch (HibernateException e) {
        	if (transaction!=null) {
        		transaction.rollback();	
        	}
        	e.printStackTrace(); 
     	} finally {
        	session.close(); 
      	}
  	}
}