package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import controller.comment;
import model.commentDAO;

public class commentDao {
    private commentDAO commentDao;

    @Test
    public void testAmbilDataSemua() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	
	     commentDao = new commentDAO();
	     
        // Assuming you have some sample data in the test database
        List<comment> comments = commentDao.ambildatasemuanya();

        session.getTransaction().commit();
        session.close();

        // Verify that the method returns a non-empty list
        assertEquals(false, comments.isEmpty());
    }

    
    @Test
    public void testSaveComment() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    commentDao = new commentDAO();
	    comment sampleComment = new comment();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
        sampleComment.setCommentID(0);
        sampleComment.setContent("TestComment");
        sampleComment.setDate(meh);
        sampleComment.setSubid("1");
        sampleComment.setPage("1");
        sampleComment.setUsername("TestUser");
        commentDao.savecomment(sampleComment);

        comment latestComment = commentDao.getLatestComment();

        // Verify that the comment was saved successfully
        comment retrievedComment = (comment) session.get(comment.class, latestComment.getCommentID());
        assertEquals("TestUser", retrievedComment.getUsername());
        commentDao.deleteComment(String.valueOf(latestComment.getCommentID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateComment() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	    
	    commentDao = new commentDAO();
	    comment sampleComment = new comment();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
        sampleComment.setCommentID(0);
        sampleComment.setContent("TestComment");
        sampleComment.setDate(meh);
        sampleComment.setSubid("1");
        sampleComment.setPage("1");
        sampleComment.setUsername("TestUser");
        commentDao.savecomment(sampleComment);
        
        comment latestComment = commentDao.getLatestComment();
        
        // Modify the comment and update it
        commentDAO rawr = new commentDAO();
        latestComment.setContent("UpdatedContent");
        rawr.updatecomment(latestComment);
        
        // Verify that the comment was updated successfully
        comment retrievedComment = (comment) session.get(comment.class, latestComment.getCommentID());
        assertEquals("UpdatedContent", retrievedComment.getContent());
        commentDao.deleteComment(String.valueOf(latestComment.getCommentID()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteComment() {
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
    	 // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();

	     
	    commentDao = new commentDAO();
	    comment sampleComment = new comment();
	    Date cd = new Date();
		String meh = String.valueOf(cd);
    	// Create a sample comment and save it
        sampleComment.setCommentID(0);
        sampleComment.setContent("TestComment");
        sampleComment.setDate(meh);
        sampleComment.setSubid("1");
        sampleComment.setPage("1");
        sampleComment.setUsername("TestUser");
        commentDao.savecomment(sampleComment);
	     
        comment latestComment = commentDao.getLatestComment();
        
        // Delete the comment and verify that it's removed from the database
        commentDao.deleteComment(String.valueOf(latestComment.getCommentID()));
        comment retrievedComment = (comment) session.get(comment.class, latestComment.getCommentID());
        assertEquals(null, retrievedComment);

        session.getTransaction().commit();
        session.close();
    }
}
