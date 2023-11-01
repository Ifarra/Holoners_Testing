package test;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class homeNav {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		setBaseUrl("http://localhost:8080/Holoners");
	}

	//To Login
	@Test
	void HomeToLoginWithBtn() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
        assertTitleEquals("Holoners : Home page");
        clickLinkWithText("Login");
        assertTitleEquals("Holoners");
	}
	
	@Test
	void HomeToLoginWithLink() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
        assertTitleEquals("Holoners : Home page");
        gotoPage("http://localhost:8080/Holoners/login.xhtml");
        assertTitleEquals("Holoners");
	}
	
	//To Home
	@Test
	void HomeToHomeWithBtn() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
        clickLinkWithText("Holoners");
        assertTitleEquals("Holoners : Home page");
	}
	
	@Test
	void HomeToHomeWithLink() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
		gotoPage("http://localhost:8080/Holoners/index.xhtml");
        assertTitleEquals("Holoners : Home page");
	}
	
	//To Talent
	@Test
	void HomeToTalentWithBtn() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
        clickLinkWithText("Talent");
        assertTextPresent("Hololive Member");
	}
	
	@Test
	void HomeToTalentWithLink() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
		gotoPage("http://localhost:8080/Holoners/talent.xhtml");
		assertTextPresent("Hololive Member");
	}

	//To Article
	@Test
	void HomeToArticleWithBtn() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
        clickLinkWithText("Article");
        assertTextPresent("Hololive Article");
	}
	
	@Test
	void HomeToArticleWithLink() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
		gotoPage("http://localhost:8080/Holoners/article.xhtml");
		assertTextPresent("Hololive Article");
	}
	
	//To Community
	@Test
	void HomeToCommunityWithBtn() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
        clickLinkWithText("Community");
        assertTextPresent("Hololive Community");
	}
	
	@Test
	void HomeToCommunityWithLink() {
		beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTitleEquals("Holoners : Home page");
		gotoPage("http://localhost:8080/Holoners/community.xhtml");
		assertTextPresent("Hololive Community");
	}
}
