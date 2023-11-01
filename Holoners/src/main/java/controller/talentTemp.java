package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.talentDAO;

@SuppressWarnings("deprecation")
@ManagedBean(name=("ttemp"))
@SessionScoped
public class talentTemp {

	private talent talent;
	private List<talent> temp;
    

    public List<talent> getTemp() {
		return temp;
	}

	public void setTemp(List<talent> temp) {
		this.temp = temp;
	}

	public talent getTalent() {
		return talent;
	}

	public void setTalent(talent talent) {
		this.talent = talent;
	}


	public talentTemp() {
        talent = new talent();
    }

    // Getter and setter methods for talent and selectedId

    public void selectRowById(String id) {
    	int guh = Integer.valueOf(id);
        // Initialize Hibernate session
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(talent.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<talent> query = session.createQuery("FROM talent t WHERE t.talentID = :selectedId", talent.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new talent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void selectrowwww(String id) {
    	try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(talent.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<talent> query = session.createQuery("FROM talent t WHERE t.talentID = :selectedId", talent.class);
            query.setParameter("selectedId", id);
            temp = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void selecttalent(String id) {
		int guh = Integer.valueOf(id);
        // Initialize Hibernate session
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(talent.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<talent> query = session.createQuery("FROM talent t WHERE t.talentID = :selectedId", talent.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new talent();
            }
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
                    .addAnnotatedClass(talent.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<talent> query = session.createQuery("FROM talent t WHERE t.talentID = :talentId", talent.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new talent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void modify() {
		talentDAO accdao = new talentDAO();
      	accdao.updatetalent(talent);
     
	}
	
	public void ambatuc(String id) {
		talentDAO accdao = new talentDAO();
      	accdao.deleteTalent(id);
	}
	
}
