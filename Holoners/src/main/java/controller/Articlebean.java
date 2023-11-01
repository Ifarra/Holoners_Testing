package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@ManagedBean(name=("art"))
@SessionScoped
public class Articlebean {

private List<article> cards; // Replace CardEntity with your entity class

    

    public List<article> getCards() {
    	if (cards == null) {
            fetchDataFromDatabase(); // Fetch data when cards is null
        }
		return cards;
	}



	public void setCards(List<article> cards) {
		this.cards = cards;
	}



	private void fetchDataFromDatabase() {
        // Use Hibernate to fetch data from the database and populate 'cards'
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(article.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<article> query = session.createQuery("FROM article", article.class);
            cards = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
