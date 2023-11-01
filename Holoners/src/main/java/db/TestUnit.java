/**
 * 
 */
package db;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertFormPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkNotPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class TestUnit {

	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		setBaseUrl("http://localhost:8080/Holoners");
	}

	@Test	
    public void test1() {
        beginAt("login.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
        assertTitleEquals("Holoners");
        assertLinkNotPresent("Logout");		// we should not be logged in
        assertFormPresent("loginfrm");
    }
	
	@Test	
    public void test2() {
        beginAt("index.xhtml"); //Open the browser on http://localhost:8080/test/home.xhtml    
        assertTitleEquals("Holoners : Home page");
    }
	
	@SuppressWarnings("deprecation")
	@Test	
    public void test3() {
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

}
