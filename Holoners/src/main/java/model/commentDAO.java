package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.comment;

@SuppressWarnings("deprecation")
public class commentDAO {

	@SuppressWarnings("unchecked")
	public List<comment> ambildatasemuanya(){
    	List<comment> guh = new ArrayList<comment>();
    	// Open the Configuration
    	 		Configuration configuration = new Configuration()
    	                 .configure("hibernate.cfg.xml")
    	                 .addAnnotatedClass(comment.class);
    		  // Create a SessionFactory
    	      SessionFactory sf = configuration.buildSessionFactory();
    	  	        
    	      // Open a session
    	      Session session = sf.openSession(); 
    	      
    	      // Begin a transaction
    	      Transaction tx = session.beginTransaction();
    	      
    	      Query<comment> query = session.createQuery("FROM comment");

    	      
    	      guh = query.list();
    	      
    	      tx.commit();
    	      
    	      sf.close();
    	      
    	      return guh;
    	      
    }
	
	public void savecomment(comment acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(comment.class);
	  // Create a SessionFactory
      SessionFactory sf = configuration.buildSessionFactory();
  	        
      // Open a session
      Session session = sf.openSession(); 
      
      // Begin a transaction
      Transaction tx = session.beginTransaction();
      
      // Save the student
      session.save(acc);
	
      // Commit the transaction
      tx.commit();

      // Close the SessionFactory
      sf.close();
      
      System.out.println("CLEAR");
    }
	
	public void updatecomment(comment acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(comment.class);
	  // Create a SessionFactory
      SessionFactory sf = configuration.buildSessionFactory();
  	        
      // Open a session
      Session session = sf.openSession(); 
      
      // Begin a transaction
      Transaction tx = session.beginTransaction();
      
      // Save the student
      session.update(acc);
	
      // Commit the transaction
      tx.commit();

      // Close the SessionFactory
      sf.close();
      
      System.out.println("CLEAR");
    }
	
@SuppressWarnings("removal")
public void deleteComment(String id) {
		
		Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
	  // Create a SessionFactory
     SessionFactory sf = configuration.buildSessionFactory();
 	        
     // Open a session
     Session session = sf.openSession(); 
     
     // Begin a transaction
     Transaction tx = session.beginTransaction();
     comment acc = (comment)session.load(comment.class, new Integer(Integer.valueOf(id)));
     session.delete(acc);
     tx.commit();
     sf.close();
	}

@SuppressWarnings({ "unchecked" })
public comment getLatestComment() {
	Configuration configuration = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(comment.class);
  // Create a SessionFactory
 SessionFactory sf = configuration.buildSessionFactory();
	        
 // Open a session
 Session session = sf.openSession(); 
 
 session.beginTransaction();

    // Use your specific logic to retrieve the latest comment (e.g., based on commentID or timestamp)
    Query<comment> query = session.createQuery("FROM comment ORDER BY commentID DESC");
    query.setMaxResults(1); // Retrieve only the latest comment

    comment latestComment = query.uniqueResult();

    session.getTransaction().commit();
    session.close();
    

    return latestComment;
}
	
}
