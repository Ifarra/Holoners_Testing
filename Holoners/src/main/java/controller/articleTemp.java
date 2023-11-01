package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.articleDAO;

@SuppressWarnings("deprecation")
@ManagedBean(name=("atemp"))
@SessionScoped
public class articleTemp {

	private article talent;
	private List<article> temp;
	
	
	
	public article getTalent() {
		return talent;
	}



	public void setTalent(article talent) {
		this.talent = talent;
	}



	public List<article> getTemp() {
		return temp;
	}



	public void setTemp(List<article> temp) {
		this.temp = temp;
	}



	public void selectRowById(String id) {
    	int guh = Integer.valueOf(id);
        // Initialize Hibernate session
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(article.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<article> query = session.createQuery("FROM article t WHERE t.articleID = :selectedId", article.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new article();
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
                    .addAnnotatedClass(article.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<article> query = session.createQuery("FROM article t WHERE t.articleID = :selectedId", article.class);
            query.setParameter("selectedId", guh);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new article();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void modify() {
      	articleDAO accdao = new articleDAO();
      	accdao.updatearticle(talent);
     
	}
	
	public void ambatuc(String id) {
		articleDAO accdao = new articleDAO();
      	accdao.deleteArticle(id);
	}
	
}
