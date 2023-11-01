package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.article;

@SuppressWarnings("deprecation")
public class articleDAO {

	public static List<article> getAllRecords() {
	    List<article> list = new ArrayList<article>();

	    
	    	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(article.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
	    	
	        Query<article> query = session.createQuery("FROM article", article.class);
	        list = query.list();

	    
	    return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<article> ambildatasemuanya(){
    	List<article> guh = new ArrayList<article>();
    	// Open the Configuration
    	 		Configuration configuration = new Configuration()
    	                 .configure("hibernate.cfg.xml")
    	                 .addAnnotatedClass(article.class);
    		  // Create a SessionFactory
    	      SessionFactory sf = configuration.buildSessionFactory();
    	  	        
    	      // Open a session
    	      Session session = sf.openSession(); 
    	      
    	      // Begin a transaction
    	      Transaction tx = session.beginTransaction();
    	      
    	      Query<article> query = session.createQuery("FROM article");

    	      
    	      guh = query.list();
    	      
    	      tx.commit();
    	      
    	      sf.close();
    	      
    	      return guh;
    	      
    }
	
	public void savearticle(article acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(article.class);
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
	
	public void updatearticle(article acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(article.class);
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
public void deleteArticle(String id) {
		
		Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(article.class);
	  // Create a SessionFactory
     SessionFactory sf = configuration.buildSessionFactory();
 	        
     // Open a session
     Session session = sf.openSession(); 
     
     // Begin a transaction
     Transaction tx = session.beginTransaction();
     article acc = (article)session.load(article.class, new Integer(Integer.valueOf(id)));
     session.delete(acc);
     tx.commit();
     sf.close();
	}

@SuppressWarnings({ "unchecked" })
public article getLatestArticle() {
	Configuration configuration = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(article.class);
  // Create a SessionFactory
 SessionFactory sf = configuration.buildSessionFactory();
	        
 // Open a session
 Session session = sf.openSession(); 
 
 session.beginTransaction();

    // Use your specific logic to retrieve the latest comment (e.g., based on commentID or timestamp)
    Query<article> query = session.createQuery("FROM article ORDER BY articleID DESC");
    query.setMaxResults(1); // Retrieve only the latest comment

    article latestArticle = query.uniqueResult();

    session.getTransaction().commit();
    session.close();
    

    return latestArticle;
}
	
}
