package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.talentDAO;

@ManagedBean(name="talent")
@SessionScoped
@Entity
@Table(name="talent")
public class talent {

	@Id
	private int talentID;
	@Column(name = "name")
	private String name;
	@Column(name = "branch")
	private String branch;
	@Column(name = "debut")
	private String debut;
	@Column(name = "jpname")
	private String jpname;
	@Column(name = "fanname")
	private String fanname;
	@Column(name = "bio")
	private String bio;
	@Column(name = "personality")
	private String personality;
	@Column(name = "overview")
	private String overview;
	@Column(name = "img")
	private String img;
	
	
	public int getTalentID() {
		return talentID;
	}
	public void setTalentID(int talentID) {
		this.talentID = talentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDebut() {
		return debut;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public String getJpname() {
		return jpname;
	}
	public void setJpname(String jpname) {
		this.jpname = jpname;
	}
	public String getFanname() {
		return fanname;
	}
	public void setFanname(String fanname) {
		this.fanname = fanname;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public List<talent> getdatatbl() {
		talentDAO guh = new talentDAO();
		List<talent> meh = guh.ambildatasemuanya();
		return meh;
	}
	
	public String register() {
		talent acc = new talent();
        acc.setTalentID(0);
        acc.setBio(bio);
        acc.setBranch(branch);
        acc.setImg(img);
        acc.setFanname(fanname);
        acc.setPersonality(personality);
        acc.setOverview(overview);
        acc.setJpname(jpname);
        acc.setDebut(debut);
        acc.setName(name);

        talentDAO accdao = new talentDAO();
      	accdao.savetalent(acc);
      	return "admin";
	}
	
}
