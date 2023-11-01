package test;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertFormElementPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertFormPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setFormElement;
import static net.sourceforge.jwebunit.junit.JWebUnit.submit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class loginNav {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		setBaseUrl("http://localhost:8080/Holoners");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void LoginToHome() {
        beginAt("login.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
        assertTitleEquals("Holoners");
        assertFormPresent("loginfrm");         // click the link
        assertFormElementPresent("loginfrm:logemail");
        assertFormElementPresent("loginfrm:logpass");
        setFormElement("loginfrm:logemail", "login@gmail.com");
        setFormElement("loginfrm:logpass", "login");
        submit();
        assertTitleEquals("Holoners : Home page");
    }
	
	@SuppressWarnings("deprecation")
	@Test
	public void LoginToHomeFail() {
        beginAt("login.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
        assertTitleEquals("Holoners");
        assertFormPresent("loginfrm");         // click the link
        assertFormElementPresent("loginfrm:logemail");
        assertFormElementPresent("loginfrm:logpass");
        setFormElement("loginfrm:logemail", "loginners@gmail.com");
        setFormElement("loginfrm:logpass", "login");
        submit();
        assertTitleEquals("Holoners");
    }

}
