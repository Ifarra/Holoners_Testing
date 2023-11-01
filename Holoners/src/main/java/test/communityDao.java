package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import controller.community;
import model.communityDAO;

class communityDao {

	private communityDAO communityDao;

    @Test
    public void testAmbilDataSemua() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(community.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	
	     communityDao = new communityDAO();
	     
        // Assuming you have some sample data in the test database
        List<community> comments = communityDao.ambildatasemuanya();

        session.getTransaction().commit();
        session.close();

        // Verify that the method returns a non-empty list
        assertEquals(false, comments.isEmpty());
    }

    
    @Test
    public void testSaveCommunity() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(community.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    communityDao = new communityDAO();
	    community sampleCommunity = new community();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
		sampleCommunity.setCommunityID(0);
		sampleCommunity.setContent("TestContent");
		sampleCommunity.setDate(meh);
		sampleCommunity.setIframe("TestIframe");
		sampleCommunity.setTitle("TestTitle");
		sampleCommunity.setUsername("TestUser");
        communityDao.savecommunity(sampleCommunity);

        community latestCommunity = communityDao.getLatestCommunity();

        // Verify that the comment was saved successfully
        community retrievedCommunity = (community) session.get(community.class, latestCommunity.getCommunityID());
        assertEquals("TestUser", retrievedCommunity.getUsername());
        communityDao.deleteCommunity(String.valueOf(latestCommunity.getCommunityID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateCommunity() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(community.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	    
	    communityDao = new communityDAO();
	    community sampleCommunity = new community();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
		sampleCommunity.setCommunityID(0);
		sampleCommunity.setContent("TestContent");
		sampleCommunity.setDate(meh);
		sampleCommunity.setIframe("TestIframe");
		sampleCommunity.setTitle("TestTitle");
		sampleCommunity.setUsername("TestUser");
        communityDao.savecommunity(sampleCommunity);
        
        community latestCommunity = communityDao.getLatestCommunity();
        
        // Modify the comment and update it
        communityDAO rawr = new communityDAO();
        latestCommunity.setContent("UpdatedContent");
        rawr.updatecommunity(latestCommunity);
        
        // Verify that the comment was updated successfully
        community retrievedCommunity = (community) session.get(community.class, latestCommunity.getCommunityID());
        assertEquals("UpdatedContent", retrievedCommunity.getContent());
        communityDao.deleteCommunity(String.valueOf(latestCommunity.getCommunityID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteCommunity() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(community.class);
    	 // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    communityDao = new communityDAO();
	    community sampleCommunity = new community();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
		sampleCommunity.setCommunityID(0);
		sampleCommunity.setContent("TestContent");
		sampleCommunity.setDate(meh);
		sampleCommunity.setIframe("TestIframe");
		sampleCommunity.setTitle("TestTitle");
		sampleCommunity.setUsername("TestUser");
        communityDao.savecommunity(sampleCommunity);
	     
        community latestCommunity = communityDao.getLatestCommunity();
        
        // Delete the comment and verify that it's removed from the database
        communityDao.deleteCommunity(String.valueOf(latestCommunity.getCommunityID()));
        community retrievedCommunity = (community) session.get(community.class, latestCommunity.getCommunityID());
        assertEquals(null, retrievedCommunity);

        session.getTransaction().commit();
        session.close();
    }

}
