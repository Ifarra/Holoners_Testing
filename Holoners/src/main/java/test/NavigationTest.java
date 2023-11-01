package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ homeNav.class, loginNav.class, talentNav.class, articleNav.class, communityNav.class })
public class NavigationTest {
}
