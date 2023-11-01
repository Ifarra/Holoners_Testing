package controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.communityDAO;

@ManagedBean(name = "communtiy" )
@SessionScoped
@Entity
@Table(name="community")
public class community {

	@Id
	private int communityID;
	private String username;
	private String title;
	private String content;
	private String iframe;
	private String date;
	
	public int getCommunityID() {
		return communityID;
	}
	public void setCommunityID(int communityID) {
		this.communityID = communityID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIframe() {
		return iframe;
	}
	public void setIframe(String iframe) {
		this.iframe = iframe;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<community> getdatatbl() {
		System.out.println("Community");
		communityDAO guh = new communityDAO();
		List<community> meh = guh.ambildatasemuanya();
		return meh;
	}
	
	public void register() {
		Date cd = new Date();
		String meh = String.valueOf(cd);
		community acc = new community();
        acc.setCommunityID(0);
        acc.setContent(content);
        acc.setDate(meh);
        acc.setIframe(iframe);
        acc.setTitle(title);
        acc.setUsername(username);

      	communityDAO accdao = new communityDAO();
      	accdao.savecommunity(acc);
     
	}
	
}
