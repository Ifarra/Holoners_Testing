package controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.articleDAO;

@ManagedBean(name="article")
@SessionScoped
@Entity
@Table(name="article")
public class article {

	@Id
	private int articleID;
	private String username;
	private String content;
	private String img;
	private String date;
	private String title;
	
	
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<article> getdatatbl() {
		articleDAO guh = new articleDAO();
		List<article> meh = guh.ambildatasemuanya();
		return meh;
	}
	
	public String register() {
		Date cd = new Date();
		String meh = String.valueOf(cd);
		article acc = new article();
        acc.setArticleID(0);
        acc.setContent(content);
        acc.setDate(meh);
        acc.setImg(img);
        acc.setTitle(title);
        acc.setUsername(username);

      	articleDAO accdao = new articleDAO();
      	accdao.savearticle(acc);
      	return "admin";
	}
	
}
