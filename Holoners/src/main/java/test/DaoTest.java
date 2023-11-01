package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ articleDao.class, commentDao.class, communityDao.class, talentDao.class, accountDao.class, commentCon.class })
public class DaoTest {

}
