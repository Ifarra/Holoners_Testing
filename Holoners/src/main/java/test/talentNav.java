package test;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLinkWithText;
import static net.sourceforge.jwebunit.junit.JWebUnit.gotoPage;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class talentNav {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		setBaseUrl("http://localhost:8080/Holoners");
	}

	//To Home
	@Test
	void TalentToHomeWithBtn() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
        clickLinkWithText("Holoners");
        assertTitleEquals("Holoners : Home page");
	}
	
	@Test
	void TalentToHomeWithLink() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
		gotoPage("http://localhost:8080/Holoners/index.xhtml");
        assertTitleEquals("Holoners : Home page");
	}
	
	//To Login
	@Test
	void TalentToLoginWithBtn() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
        clickLinkWithText("Login");
        assertTitleEquals("Holoners");
	}
	
	@Test
	void TalentToLoginWithLink() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
		gotoPage("http://localhost:8080/Holoners/login.xhtml");
        assertTitleEquals("Holoners");
	}

	
	//To Talent
	@Test
	void TalentToTalentWithBtn() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
        clickLinkWithText("Talent");
        assertTextPresent("Hololive Member");
	}
	
	@Test
	void TalentToTalentWithLink() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
		gotoPage("http://localhost:8080/Holoners/talent.xhtml");
		assertTextPresent("Hololive Member");
	}
	
	//To Article
	@Test
	void TalentToArticleWithBtn() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
        clickLinkWithText("Article");
        assertTextPresent("Hololive Article");
	}
	
	@Test
	void TalentToArticleWithLink() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
		gotoPage("http://localhost:8080/Holoners/article.xhtml");
		assertTextPresent("Hololive Article");
	}
	
	//To Community
	@Test
	void TalentToCommunityWithBtn() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
        clickLinkWithText("Community");
        assertTextPresent("Hololive Community");
	}
	
	@Test
	void TalentToCommunityWithLink() {
		beginAt("talent.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Member");
		gotoPage("http://localhost:8080/Holoners/community.xhtml");
		assertTextPresent("Hololive Community");
	}
}
