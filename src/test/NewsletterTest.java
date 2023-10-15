package test;
import testbase.TestBase;


import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class NewsletterTest extends TestBase {

	@Test
	public void newsletterTest() {

		page.navigate("https://www2.hm.com/sv_se/customer-service/nyhetsbrev.html");

		Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Tillåt alla cookies"));

		if (acceptCookies.isVisible()) {
			acceptCookies.click();

			page.locator("#txt-email").type("behroz_m@hotmail.com");
			page.locator("#txt-postal-code").type("14351");

			page.locator("#cs-fashion-news").check();

			page.locator("input[type='submit'][value='Ja tack, jag vill prenumerera!']").click();

			Locator thankYouMessage = page.locator("p:has-text('TACK! Du prenumererar redan på Fashion News')");

			assertFalse(thankYouMessage.isVisible(), "TACK! Du prenumererar redan på Fashion News är inte synligt.");

		}
	}

}