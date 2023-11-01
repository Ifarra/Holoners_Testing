package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.communityDAO;

@SuppressWarnings("deprecation")
@ManagedBean(name=("ctemp"))
@SessionScoped
public class communityTemp {

	private community talent;
	private List<community> temp;
	
	
	
	public community getTalent() {
		return talent;
	}



	public void setTalent(community talent) {
		this.talent = talent;
	}



	public List<community> getTemp() {
		return temp;
	}



	public void setTemp(List<community> temp) {
		this.temp = temp;
	}



	public void selectRowById(String id) {
    	int guh = Integer.valueOf(id);
        // Initialize Hibernate session
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(community.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<community> query = session.createQuery("FROM community t WHERE t.communityID = :selectedId", community.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new community();
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
                    .addAnnotatedClass(community.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<community> query = session.createQuery("FROM community t WHERE t.communityID = :selectedId", community.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new community();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void modify() {
		communityDAO accdao = new communityDAO();
      	accdao.updatecommunity(talent);
     
	}
	
	public void ambatuc(String id) {
		communityDAO accdao = new communityDAO();
      	accdao.deleteCommunity(id);
	}
	
}
