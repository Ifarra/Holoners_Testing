package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import controller.account;
import model.accountDAO;

class accountDao {

	private accountDAO accountDao;

    @Test
    public void testAmbilDataSemua() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(account.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	
	     accountDao = new accountDAO();
	     
        // Assuming you have some sample data in the test database
        List<account> accounts = accountDao.ambildatasemuanya();

        session.getTransaction().commit();
        session.close();

        // Verify that the method returns a non-empty list
        assertEquals(false, accounts.isEmpty());
    }

    
    @Test
    public void testSaveAccount() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(account.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    accountDao = new accountDAO();
	    account sampleAccount = new account();
    	// Create a sample account and save it
		sampleAccount.setAccID(0);
		sampleAccount.setUsername("TestUser");
		sampleAccount.setPassword("TestPassword");
		sampleAccount.setEmail("TestEmail");
		sampleAccount.setRole("TestRole");
        accountDao.saveacc(sampleAccount);

        account latestAccount = accountDao.getLatestAccount();

        // Verify that the account was saved successfully
        account retrievedAccount = (account) session.get(account.class, latestAccount.getAccID());
        assertEquals("TestUser", retrievedAccount.getUsername());
        accountDao.deleteAcc(String.valueOf(latestAccount.getAccID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateAccount() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(account.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	    
	    accountDao = new accountDAO();
	    account sampleAccount = new account();
    	// Create a sample account and save it
		sampleAccount.setAccID(0);
		sampleAccount.setUsername("TestUser");
		sampleAccount.setPassword("TestPassword");
		sampleAccount.setEmail("TestEmail");
		sampleAccount.setRole("TestRole");
        accountDao.saveacc(sampleAccount);
        
        account latestAccount = accountDao.getLatestAccount();
        
        // Modify the account and update it
        accountDAO rawr = new accountDAO();
        latestAccount.setUsername("UpdatedContent");
        rawr.updateacc(latestAccount);
        
        // Verify that the account was updated successfully
        account retrievedAccount = (account) session.get(account.class, latestAccount.getAccID());
        assertEquals("UpdatedContent", retrievedAccount.getUsername());
        accountDao.deleteAcc(String.valueOf(latestAccount.getAccID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteAccount() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(account.class);
    	 // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    accountDao = new accountDAO();
	    account sampleAccount = new account();
    	// Create a sample account and save it
		sampleAccount.setAccID(0);
		sampleAccount.setUsername("TestUser");
		sampleAccount.setPassword("TestPassword");
		sampleAccount.setEmail("TestEmail");
		sampleAccount.setRole("TestRole");
        accountDao.saveacc(sampleAccount);
	     
        account latestAccount = accountDao.getLatestAccount();
        
        // Delete the account and verify that it's removed from the database
        accountDao.deleteAcc(String.valueOf(latestAccount.getAccID()));
        account retrievedAccount = (account) session.get(account.class, latestAccount.getAccID());
        assertEquals(null, retrievedAccount);

        session.getTransaction().commit();
        session.close();
    }

}
