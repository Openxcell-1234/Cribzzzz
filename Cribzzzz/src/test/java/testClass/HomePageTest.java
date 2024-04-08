package testClass;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class HomePageTest extends BeforeAfterTest{
	
	public static Logger log = Logger.getLogger(HomePageTest.class);
	
	@Test
	public void loginTestMethod() {
		
		log.info("test executed");
		
	}

}
