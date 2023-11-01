package test;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLinkWithText;
import static net.sourceforge.jwebunit.junit.JWebUnit.gotoPage;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class communityNav {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		setBaseUrl("http://localhost:8080/Holoners");
	}

	//To Login
	@Test
	void CommunityToLoginWithBtn() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml
		assertTextPresent("Hololive Community");
        clickLinkWithText("Login");
        assertTitleEquals("Holoners");
	}
	
	@Test
	void CommunityToLoginWithLink() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml
		assertTextPresent("Hololive Community");
        gotoPage("http://localhost:8080/Holoners/login.xhtml");
        assertTitleEquals("Holoners");
	}
	
	//To Home
	@Test
	void CommunityToHomeWithBtn() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml
		assertTextPresent("Hololive Community");
        clickLinkWithText("Holoners");
        assertTitleEquals("Holoners : Home page");
	}
	
	@Test
	void CommunityToHomeWithLink() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml
		assertTextPresent("Hololive Community");
		gotoPage("http://localhost:8080/Holoners/index.xhtml");
        assertTitleEquals("Holoners : Home page");
	}
	
	//To Talent
	@Test
	void CommunityToTalentWithBtn() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml
		assertTextPresent("Hololive Community");
        clickLinkWithText("Talent");
        assertTextPresent("Hololive Member");
	}
	
	@Test
	void CommunityToTalentWithLink() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml 
		assertTextPresent("Hololive Community");
		gotoPage("http://localhost:8080/Holoners/talent.xhtml");
		assertTextPresent("Hololive Member");
	}
	
	//To Article
	@Test
	void CommunityToArticleWithBtn() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml  
		assertTextPresent("Hololive Community");
        clickLinkWithText("Article");
        assertTextPresent("Hololive Article");
	}
	
	@Test
	void CommunityToArticleWithLink() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml  
		assertTextPresent("Hololive Community");
		gotoPage("http://localhost:8080/Holoners/article.xhtml");
		assertTextPresent("Hololive Article");
	}
	
	//To Community
	@Test
	void CommunityToCommunityWithBtn() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml   
		assertTextPresent("Hololive Community");
        clickLinkWithText("Community");
        assertTextPresent("Hololive Community");
	}
	
	@Test
	void CommunityToCommunityWithLink() {
		beginAt("community.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Community");
		gotoPage("http://localhost:8080/Holoners/community.xhtml");
		assertTextPresent("Hololive Community");
	}

}
