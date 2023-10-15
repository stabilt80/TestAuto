package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import page.ZalandoDyrastSkor;
import testbase.TestBase;

public class ZalandoDyrastSkorTest extends TestBase {
   
	@Test
		public void zalandoDyrastSkorTest () {
            ZalandoDyrastSkor zalandoDyrastSkorTest = new ZalandoDyrastSkor(page);

            zalandoDyrastSkorTest.openStartPage();
            zalandoDyrastSkorTest.searchProduct();
            
            Assertions.assertTrue(page.url().contains("https://www.zalando.se/"));
            
	}
        
        }
    

