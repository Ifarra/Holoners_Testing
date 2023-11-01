package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import controller.article;
import model.articleDAO;

class articleDao {

	private articleDAO articleDao;

    @Test
    public void testAmbilDataSemua() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(article.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	
	     articleDao = new articleDAO();
	     
        // Assuming you have some sample data in the test database
        List<article> comments = articleDao.ambildatasemuanya();

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
                .addAnnotatedClass(article.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	
	     articleDao = new articleDAO();
	     
        // Assuming you have some sample data in the test database
        List<article> comments = articleDao.getAllRecords();

        session.getTransaction().commit();
        session.close();

        // Verify that the method returns a non-empty list
        assertEquals(false, comments.isEmpty());
    }

    
    @Test
    public void testSaveArticle() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(article.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    articleDao = new articleDAO();
	    article sampleArticle = new article();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
		sampleArticle.setArticleID(0);
		sampleArticle.setContent("TestContent");
		sampleArticle.setDate(meh);
		sampleArticle.setImg("TestImg");
		sampleArticle.setTitle("TestTitle");
		sampleArticle.setUsername("TestUser");
        articleDao.savearticle(sampleArticle);

        article latestArticle = articleDao.getLatestArticle();

        // Verify that the comment was saved successfully
        article retrievedArticle = (article) session.get(article.class, latestArticle.getArticleID());
        assertEquals("TestUser", retrievedArticle.getUsername());
        articleDao.deleteArticle(String.valueOf(latestArticle.getArticleID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateArticle() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(article.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	    
	    articleDao = new articleDAO();
	    article sampleArticle = new article();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
		sampleArticle.setArticleID(0);
		sampleArticle.setContent("TestContent");
		sampleArticle.setDate(meh);
		sampleArticle.setImg("TestImg");
		sampleArticle.setTitle("TestTitle");
		sampleArticle.setUsername("TestUsername");
        articleDao.savearticle(sampleArticle);
        
        article latestArticle = articleDao.getLatestArticle();
        
        // Modify the comment and update it
        articleDAO rawr = new articleDAO();
        latestArticle.setContent("UpdatedContent");
        rawr.updatearticle(latestArticle);
        
        // Verify that the comment was updated successfully
        article retrievedArticle = (article) session.get(article.class, latestArticle.getArticleID());
        assertEquals("UpdatedContent", retrievedArticle.getContent());
        articleDao.deleteArticle(String.valueOf(latestArticle.getArticleID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteArticle() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(article.class);
    	 // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    articleDao = new articleDAO();
	    article sampleArticle = new article();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
		sampleArticle.setArticleID(0);
		sampleArticle.setContent("TestContent");
		sampleArticle.setDate(meh);
		sampleArticle.setImg("TestImg");
		sampleArticle.setTitle("TestTitle");
		sampleArticle.setUsername("TestUsername");
        articleDao.savearticle(sampleArticle);
	     
        article latestArticle = articleDao.getLatestArticle();
        
        // Delete the comment and verify that it's removed from the database
        articleDao.deleteArticle(String.valueOf(latestArticle.getArticleID()));
        article retrievedArticle = (article) session.get(article.class, latestArticle.getArticleID());
        assertEquals(null, retrievedArticle);

        session.getTransaction().commit();
        session.close();
    }

}
