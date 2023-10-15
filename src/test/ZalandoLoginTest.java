package test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import page.ZalandoLogin;
import testbase.TestBase;

public class ZalandoLoginTest extends TestBase  {

	@Test 
	public void loginTest() {
		
		ZalandoLogin pageObject = new ZalandoLogin(page);
		
		pageObject.opetStartPage();
		pageObject.pageLogin("behroz_m@hotmail.com", "1234");
		
		
		assertThat(page.locator("span:has-text('Inmatningen är för kort.')")).isVisible();
	
		
	}
	
}
