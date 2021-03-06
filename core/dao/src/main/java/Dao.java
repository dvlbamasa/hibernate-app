import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import java.util.List;
import java.io.Serializable;

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

  	public static Object get(int id, String object) {
  		Session session = HibernateSession.getSession();
  		Object resultObject = null;
  		try {
			Query query = session.createQuery("from " + object + " where id= :id");
			query.setParameter("id", id);
			List results = query.list();
			if (results.size() == 1) {
				resultObject = results.get(0);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return resultObject;
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


  	public static boolean isDBEmpty() {
  		Session session = HibernateSession.getSession();
  		List results = null;
  		try {
			Query query = session.createQuery("from Person");
			results = query.list();
		} catch (HibernateException e) {
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return (results.size() > 0 ? false : true);
  	}

  	public static List getList(String object) {
  		Session session = HibernateSession.getSession();
  		List results = null;
  		try {
			Query query = session.createQuery("from " + object);
			results = query.list();
		} catch (HibernateException e) {
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return results;
  	}

  	public static List getOrderedList(String object, String order) {
  		Session session = HibernateSession.getSession();
  		List results = null;
  		try {
			Query query = session.createQuery("from " + object + " ORDER BY " + order + " ASC");
			results = query.list();
		} catch (HibernateException e) {
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return results;
  	}
}