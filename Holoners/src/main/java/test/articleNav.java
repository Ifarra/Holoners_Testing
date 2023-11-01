package test;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLinkWithText;
import static net.sourceforge.jwebunit.junit.JWebUnit.gotoPage;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class articleNav {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		setBaseUrl("http://localhost:8080/Holoners");
	}

	//To Login
	@Test
	void ArticleToLoginWithBtn() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
        clickLinkWithText("Login");
        assertTitleEquals("Holoners");
	}
	
	@Test
	void ArticleToLoginWithLink() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
        gotoPage("http://localhost:8080/Holoners/login.xhtml");
        assertTitleEquals("Holoners");
	}
	
	//To Home
	@Test
	void ArticleToHomeWithBtn() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
        clickLinkWithText("Holoners");
        assertTitleEquals("Holoners : Home page");
	}
	
	@Test
	void ArticleToHomeWithLink() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
		gotoPage("http://localhost:8080/Holoners/index.xhtml");
        assertTitleEquals("Holoners : Home page");
	}
	
	//To Talent
	@Test
	void ArticleToTalentWithBtn() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
        clickLinkWithText("Talent");
        assertTextPresent("Hololive Member");
	}
	
	@Test
	void ArticleToTalentWithLink() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
		gotoPage("http://localhost:8080/Holoners/talent.xhtml");
		assertTextPresent("Hololive Member");
	}
	
	//To Article
	@Test
	void ArticleToArticleWithBtn() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
        clickLinkWithText("Article");
        assertTextPresent("Hololive Article");
	}
	
	@Test
	void ArticleToArticleWithLink() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
		gotoPage("http://localhost:8080/Holoners/article.xhtml");
		assertTextPresent("Hololive Article");
	}
	
	//To Community
	@Test
	void ArticleToCommunityWithBtn() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
        clickLinkWithText("Community");
        assertTextPresent("Hololive Community");
	}
	
	@Test
	void ArticleToCommunityWithLink() {
		beginAt("article.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
		assertTextPresent("Hololive Article");
		gotoPage("http://localhost:8080/Holoners/community.xhtml");
		assertTextPresent("Hololive Community");
	}

}
