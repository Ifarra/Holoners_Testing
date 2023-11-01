package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name=("stats"))
@SessionScoped
public class navbar {

	private boolean loggedin = false;
	private boolean unloggdin = true;
	
	
	public boolean isLoggedin() {
		return loggedin;
	}
	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	public boolean isUnloggdin() {
		return unloggdin;
	}
	public void setUnloggdin(boolean unloggdin) {
		this.unloggdin = unloggdin;
	}
	
	public String login() {
        // Implement your login logic here
		loggedin = true;
		unloggdin = false;
        return "login"; // Redirect to the dashboard page after login
    }
	

    public String account() {
        return "account"; // Redirect to the home page after logout
    }
    
    public String logout() {
        // Implement your logout logic here
    	loggedin = false;
    	unloggdin = true;
        return "index"; // Redirect to the home page after logout
    }
	
}
