package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.account;

@SuppressWarnings("deprecation")
@ManagedBean(name=("daoacc"))
@SessionScoped
public class accountDAO {
	
	private account account;
	
	

    public account getAccount() {
		return account;
	}

	public void setAccount(account account) {
		this.account = account;
	}

	public void saveacc(account acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(account.class);
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
    
    public String login(String email, String password) {
        try {
     		Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(account.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<account> query = session.createQuery("FROM account account WHERE account.email = :email AND account.password = :password",account.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            account user = query.uniqueResult();
            account guh = new account();
            guh.setsemua(user.getAccID(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
            System.out.println(user.getAccID());
            System.out.println(user.getUsername());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getRole());
            
            List<account> results = query.list();
            if (!results.isEmpty()) {
                account = results.get(0); // Assuming there's only one user with the provided email
            } else {
                // Handle the case when no matching user is found
            }
            
            
            
            if (user != null) {
                if ("member".equals(user.getRole())) {
                    return "index";
                } else if ("admin".equals(user.getRole())) {
                    return "admin";
                }
            }
            sf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }
    
    public String testlogin(String email, String password) {
    	System.out.println(email);
    	System.out.println(password);
    	return "index";
    }
    
    public void updateacc(account acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(account.class);
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
    
    private String getUserPassword() {
        account us = new account();
        return us.getPassword(); // Replace with your actual email retrieval logic
    }
    
    private String getUserEmail() {
        account us = new account();
        return us.getEmail(); // Replace with your actual email retrieval logic
    }
    
    public List<account> ambildata(){
    	List<account> guh = new ArrayList<account>();
    	// Open the Configuration
    	 		Configuration configuration = new Configuration()
    	                 .configure("hibernate.cfg.xml")
    	                 .addAnnotatedClass(account.class);
    		  // Create a SessionFactory
    	      SessionFactory sf = configuration.buildSessionFactory();
    	  	        
    	      // Open a session
    	      Session session = sf.openSession(); 
    	      
    	      // Begin a transaction
    	      Transaction tx = session.beginTransaction();
    	      
    	      Query<account> query = session.createQuery("FROM account account WHERE account.email = :email AND account.password = :password",account.class);
              query.setParameter("email", getUserEmail());
              query.setParameter("password", getUserPassword());
    	      
    	      guh = query.list();
    	      
    	      tx.commit();
    	      
    	      sf.close();
    	      
    	      return guh;
    	      
    }
    
    @SuppressWarnings("unchecked")
	public List<account> ambildatasemuanya(){
    	List<account> guh = new ArrayList<account>();
    	// Open the Configuration
    	 		Configuration configuration = new Configuration()
    	                 .configure("hibernate.cfg.xml")
    	                 .addAnnotatedClass(account.class);
    		  // Create a SessionFactory
    	      SessionFactory sf = configuration.buildSessionFactory();
    	  	        
    	      // Open a session
    	      Session session = sf.openSession(); 
    	      
    	      // Begin a transaction
    	      Transaction tx = session.beginTransaction();
    	      
    	      Query<account> query = session.createQuery("FROM account");

    	      
    	      guh = query.list();
    	      
    	      tx.commit();
    	      
    	      sf.close();
    	      
    	      return guh;
    	      
    }
	
	@SuppressWarnings("removal")
	public void deleteAcc(String id) {
		
		Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(account.class);
	  // Create a SessionFactory
     SessionFactory sf = configuration.buildSessionFactory();
 	        
     // Open a session
     Session session = sf.openSession(); 
     
     // Begin a transaction yea
     Transaction tx = session.beginTransaction();
     account acc = (account)session.load(account.class, new Integer(Integer.valueOf(id)));
     session.delete(acc);
     tx.commit();
     sf.close();
	}
	
	@SuppressWarnings({ "unchecked" })
	public account getLatestAccount() {
		Configuration configuration = new Configuration()
	            .configure("hibernate.cfg.xml")
	            .addAnnotatedClass(account.class);
	  // Create a SessionFactory
	 SessionFactory sf = configuration.buildSessionFactory();
		        
	 // Open a session
	 Session session = sf.openSession(); 
	 
	 session.beginTransaction();

	    // Use your specific logic to retrieve the latest comment (e.g., based on commentID or timestamp)
	    Query<account> query = session.createQuery("FROM account ORDER BY accID DESC");
	    query.setMaxResults(1); // Retrieve only the latest comment

	    account latestAccount = query.uniqueResult();

	    session.getTransaction().commit();
	    session.close();
	    

	    return latestAccount;
	}
	
}
