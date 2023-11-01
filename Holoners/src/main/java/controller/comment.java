package controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.commentDAO;
import model.communityDAO;

@ManagedBean(name="comment")
@SessionScoped
@Entity
@Table(name="comment")
public class comment {

	@Id
	private int commentID;
	private String username;
	private String content;
	private String date;
	private String page;
	private String subid;
	
	
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public void pasangnama(String guh) {
		username = guh;
	}
	
	public void pasangpage(String guh) {
		page = guh;
	}

	public void pasangsub(String guh) {
		subid = guh;
	}
	
	
	
	public List<comment> getdatatbl() {
		commentDAO guh = new commentDAO();
		List<comment> meh = guh.ambildatasemuanya();
		return meh;
	}
	
	public List<community> getdatatblcom() {
		System.out.println("Community");
		communityDAO guh = new communityDAO();
		List<community> meh = guh.ambildatasemuanya();
		return meh;
	}
	
	public String register() {
		Date cd = new Date();
		String meh = String.valueOf(cd);
		comment acc = new comment();
        acc.setCommentID(0);
        acc.setContent(content);
        acc.setDate(meh);
        acc.setSubid(subid);
        acc.setPage(page);
        acc.setUsername(username);

      	commentDAO accdao = new commentDAO();
      	accdao.savecomment(acc);
      	return "admin";
	}
	
	public void commentadd(String nama, String halaman, String sub) {
		Date cd = new Date();
		String meh = String.valueOf(cd);
		comment acc = new comment();
        acc.setCommentID(0);
        acc.setContent(content);
        acc.setDate(meh);
        acc.setSubid(sub);
        acc.setPage(halaman);
        acc.setUsername(nama);

      	commentDAO accdao = new commentDAO();
      	accdao.savecomment(acc);
	}
	
}
