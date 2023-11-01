package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import controller.talent;
import model.talentDAO;

class talentDao {

	private talentDAO talentDao;

    @Test
    public void testAmbilDataSemua() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(talent.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	
	     talentDao = new talentDAO();
	     
        // Assuming you have some sample data in the test database
        List<talent> comments = talentDao.ambildatasemuanya();

        session.getTransaction().commit();
        session.close();

        // Verify that the method returns a non-empty list
        assertEquals(false, comments.isEmpty());
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testGetAllRecords() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(talent.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	
	     talentDao = new talentDAO();
	     
        // Assuming you have some sample data in the test database
        List<talent> comments = talentDao.getAllRecords();

        session.getTransaction().commit();
        session.close();

        // Verify that the method returns a non-empty list
        assertEquals(false, comments.isEmpty());
    }

    
    @Test
    public void testSaveTalent() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(talent.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    talentDao = new talentDAO();
	    talent sampleTalent = new talent();
    	// Create a sample comment and save it
		sampleTalent.setTalentID(0);
		sampleTalent.setBio("TestBIo");
		sampleTalent.setBranch("TestBranch");
		sampleTalent.setImg("TestImg");
		sampleTalent.setFanname("TestFanname");
		sampleTalent.setPersonality("TestPersonality");
		sampleTalent.setOverview("TestOverview");
		sampleTalent.setJpname("TestJpname");
		sampleTalent.setDebut("TestDebut");
		sampleTalent.setName("TestUser");
        talentDao.savetalent(sampleTalent);

        talent latestTalent = talentDao.getLatestTalent();

        // Verify that the comment was saved successfully
        talent retrievedTalent = (talent) session.get(talent.class, latestTalent.getTalentID());
        assertEquals("TestUser", retrievedTalent.getName());
        talentDao.deleteTalent(String.valueOf(latestTalent.getTalentID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateTalent() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(talent.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	    
	    talentDao = new talentDAO();
	    talent sampleTalent = new talent();
    	// Create a sample comment and save it
		sampleTalent.setTalentID(0);
		sampleTalent.setBio("TestBIo");
		sampleTalent.setBranch("TestBranch");
		sampleTalent.setImg("TestImg");
		sampleTalent.setFanname("TestFanname");
		sampleTalent.setPersonality("TestPersonality");
		sampleTalent.setOverview("TestOverview");
		sampleTalent.setJpname("TestJpname");
		sampleTalent.setDebut("TestDebut");
		sampleTalent.setName("TestUser");
        talentDao.savetalent(sampleTalent);
        
        talent latestTalent = talentDao.getLatestTalent();
        
        // Modify the comment and update it
        talentDAO rawr = new talentDAO();
        latestTalent.setBio("UpdatedContent");
        rawr.updatetalent(latestTalent);
        
        // Verify that the comment was updated successfully
        talent retrievedTalent = (talent) session.get(talent.class, latestTalent.getTalentID());
        assertEquals("UpdatedContent", retrievedTalent.getBio());
        talentDao.deleteTalent(String.valueOf(latestTalent.getTalentID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteTalent() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(talent.class);
    	 // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    talentDao = new talentDAO();
	    talent sampleTalent = new talent();
    	// Create a sample comment and save it
		sampleTalent.setTalentID(0);
		sampleTalent.setBio("TestBIo");
		sampleTalent.setBranch("TestBranch");
		sampleTalent.setImg("TestImg");
		sampleTalent.setFanname("TestFanname");
		sampleTalent.setPersonality("TestPersonality");
		sampleTalent.setOverview("TestOverview");
		sampleTalent.setJpname("TestJpname");
		sampleTalent.setDebut("TestDebut");
		sampleTalent.setName("TestUser");
        talentDao.savetalent(sampleTalent);
	     
        talent latestTalent = talentDao.getLatestTalent();
        
        // Delete the comment and verify that it's removed from the database
        talentDao.deleteTalent(String.valueOf(latestTalent.getTalentID()));
        talent retrievedTalent = (talent) session.get(talent.class, latestTalent.getTalentID());
        assertEquals(null, retrievedTalent);

        session.getTransaction().commit();
        session.close();
    }

}
