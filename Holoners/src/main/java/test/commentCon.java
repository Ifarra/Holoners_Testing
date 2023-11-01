package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import controller.comment;
import controller.community;
import model.commentDAO;

class commentCon {

	private controller.comment comment;
	private commentDAO commentDao;

    @Test
    public void testGettersAndSetters() {
    	comment = new comment();
        comment.setCommentID(1);
        comment.setUsername("JohnDoe");
        comment.setContent("This is a test comment.");
        comment.setDate("2023-10-31");
        comment.setPage("TestPage");
        comment.setSubid("12345");

        assertEquals(1, comment.getCommentID());
        assertEquals("JohnDoe", comment.getUsername());
        assertEquals("This is a test comment.", comment.getContent());
        assertEquals("2023-10-31", comment.getDate());
        assertEquals("TestPage", comment.getPage());
        assertEquals("12345", comment.getSubid());
    }

    @Test
    public void testPasangNama() {
    	comment = new comment();
        comment.pasangnama("Alice");
        assertEquals("Alice", comment.getUsername());
    }

    @Test
    public void testPasangPage() {
    	comment = new comment();
        comment.pasangpage("NewPage");
        assertEquals("NewPage", comment.getPage());
    }

    @Test
    public void testPasangSub() {
    	comment = new comment();
        comment.pasangsub("67890");
        assertEquals("67890", comment.getSubid());
    }

    @Test
    public void testRegister() {
    	commentDao = new commentDAO();
    	comment = new comment();
        comment.setUsername("TestUser");
        comment.setContent("New comment");
        comment.setPage("TestPage");
        comment.setSubid("54321");

        String result = comment.register();

        assertEquals("admin", result); // Assuming this is the expected return value
        
        comment latestComment = commentDao.getLatestComment();

    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
	    // Create a SessionFactory
	    SessionFactory sf = configuration.buildSessionFactory();
	    	        
	    // Open a session
	    Session session = sf.openSession(); 
	     
	    session.beginTransaction();
	    
        // Verify that the comment was saved successfully
        comment retrievedComment = (comment) session.get(comment.class, latestComment.getCommentID());
        assertEquals("TestUser", retrievedComment.getUsername());
        commentDao.deleteComment(String.valueOf(latestComment.getCommentID()));
    }

    @Test
    public void testCommentAdd() {
    	comment = new comment();
    	commentDao = new commentDAO();
        comment.commentadd("TestUser", "AnotherPage", "98765");

        comment latestComment = commentDao.getLatestComment();

    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
	    // Create a SessionFactory
	    SessionFactory sf = configuration.buildSessionFactory();
	    	        
	    // Open a session
	    Session session = sf.openSession(); 
	     
	    session.beginTransaction();
	    
        // Verify that the comment was saved successfully
        comment retrievedComment = (comment) session.get(comment.class, latestComment.getCommentID());
        assertEquals("TestUser", retrievedComment.getUsername());
        commentDao.deleteComment(String.valueOf(latestComment.getCommentID()));
    }
    
    @Test
    public void testAmbilDataSemua() {
    	comment = new comment();
    	Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(comment.class);
	     // Create a SessionFactory
	     SessionFactory sf = configuration.buildSessionFactory();
	    	        
	     // Open a session
	     Session session = sf.openSession(); 
	     
	     session.beginTransaction();
	     
        // Assuming you have some sample data in the test database
        List<comment> comments = comment.getdatatbl();
        List<community> commentos = comment.getdatatblcom();

        session.getTransaction().commit();
        session.close();

        // Verify that the method returns a non-empty list
        assertEquals(false, comments.isEmpty());
        assertEquals(false, commentos.isEmpty());
    }

}
