package controller;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@ManagedBean(name=("card"))
@SessionScoped
public class Cardbean {
	
    private List<talent> cards; // Replace CardEntity with your entity class

    

    public List<talent> getCards() {
    	if (cards == null) {
            fetchDataFromDatabase(); // Fetch data when cards is null
        }
		return cards;
	}



	public void setCards(List<talent> cards) {
		this.cards = cards;
	}



	private void fetchDataFromDatabase() {
        // Use Hibernate to fetch data from the database and populate 'cards'
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(talent.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<talent> query = session.createQuery("FROM talent", talent.class);
            cards = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
}
