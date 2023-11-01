package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.accountDAO;

@ManagedBean(name = "account")
@SessionScoped
@Entity
@Table(name = "account")
public class account {

	@Id
	private int accID;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "role")
	private String role;
	
	
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
    // Create a ProductDAO instance
	public void register() {
		account acc = new account();
        acc.setAccID(0);
        acc.setUsername(username);
        acc.setPassword(password);
        acc.setEmail(email);
        acc.setRole("member");

      	accountDAO accdao = new accountDAO();
      	accdao.saveacc(acc);
     
	}
	
	public String login() {
      	accountDAO accdao = new accountDAO();
      	String guh = accdao.login(email, password);
      	
      	if(guh.equals("index")) {
      		return "index";
      	} else if (guh.equals("admin")) {
      		return "admin";
      	}
      	
      	return "login";
     
	}
	
	public String testlogin() {
      	accountDAO accdao = new accountDAO();
      	String guh = accdao.testlogin(email, password);
     
      	if (guh.equals("index")){
      		return "index";
      	}
      	return "login";
	}
	
	public void modify(account account) {
      	accountDAO accdao = new accountDAO();
      	accdao.updateacc(account);
     
	}
	
	public List<account> getdata() {
		accountDAO guh = new accountDAO();
		List<account> meh = guh.ambildata();
		return meh;
	}
	
	public List<account> getdatatbl() {
		accountDAO guh = new accountDAO();
		List<account> meh = guh.ambildatasemuanya();
		return meh;
	}
	
	public void setsemua(int id,String nama,String email,String password,String role) {
		System.out.println(id);
		System.out.println(nama);
		System.out.println(email);
		System.out.println(password);
		System.out.println(role);
		setAccID(id);
		setUsername(nama);
		setEmail(email);
		setPassword(password);
		setRole(role);
		System.out.println(this.accID);
		System.out.println(this.email);
		System.out.println(this.password);
		System.out.println(this.username);
		System.out.println(this.role);
	}
	
	public String registeracc() {
		account acc = new account();
        acc.setAccID(0);
        acc.setUsername(username);
        acc.setPassword(password);
        acc.setEmail(email);
        acc.setRole(role);

      	accountDAO accdao = new accountDAO();
      	accdao.saveacc(acc);
      	return "admin";
	}
}
