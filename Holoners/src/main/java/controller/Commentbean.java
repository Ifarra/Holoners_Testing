package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.commentDAO;

@ManagedBean(name=("cmt"))
@RequestScoped
public class Commentbean {

private comment talent;
private List<comment> cards; // Replace CardEntity with your entity class

    

    public comment getTalent() {
	return talent;
}



public void setTalent(comment talent) {
	this.talent = talent;
}



	public List<comment> getCards(String page, String id) {
    	if (cards == null) {
            fetchDatacommunity(page,id); // Fetch data when cards is null
        }
		return cards;
	}



	public void setCards(List<comment> cards) {
		this.cards = cards;
	}



	private void fetchDatacommunity(String page, String id) {
        // Use Hibernate to fetch data from the database and populate 'cards'
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(comment.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<comment> query = session.createQuery("FROM comment c WHERE c.page = :guh AND c.subid = :wah", comment.class);
            query.setParameter("guh", page);
            query.setParameter("wah", id);
            cards = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void selectarticle(String id) {
		int guh = Integer.valueOf(id);
        // Initialize Hibernate session
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(comment.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<comment> query = session.createQuery("FROM comment t WHERE t.commentID = :selectedId", comment.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new comment();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void modify() {
		commentDAO accdao = new commentDAO();
      	accdao.updatecomment(talent);
     
	}
	
	public void ambatuc(String id) {
		commentDAO accdao = new commentDAO();
      	accdao.deleteComment(id);
	}
	
}
