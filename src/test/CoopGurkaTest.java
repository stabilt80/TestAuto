package test;

import org.junit.jupiter.api.Test;

import page.CoopGurka;
import testbase.TestBase;

public class CoopGurkaTest extends TestBase {

	
	@Test
	public void coopGurkaTest() {
		
		CoopGurka coopGurkaTest = new CoopGurka(page);
		
		coopGurkaTest.openCoopPage();
		coopGurkaTest.selectGurkaproduct();
		coopGurkaTest.assertImgGurka();                 
			
	}
	
	
}
