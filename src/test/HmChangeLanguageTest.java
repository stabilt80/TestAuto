package test;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;


public class HmChangeLanguageTest extends TestBase {
	@Test
	void hmChangeLanguageTest() {
		page.navigate("https://www2.hm.com/sv_se/index.html");

			Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("Tillåt alla cookies"));

		if (acceptCookies.isVisible()) {
			
			acceptCookies.click();

			Locator swedenButton = page.locator("button:has-text('Sverige')");
			swedenButton.scrollIntoViewIfNeeded();

			swedenButton.click();

			page.locator("button:has-text('EUROPE')").click();

			page.locator("span:has-text('Austria')").click();

			assertFalse(acceptCookies.isVisible(),
					"Cookie-meddelandet borde ha försvunnit efter att ha klickat på 'Tillåt alla cookies'.");

			assertTrue(page.url().contains("https://www2.hm.com/de_at/index.html"),
					"URL borde nu peka på den österrikiska versionen av webbplatsen.");
		}
	}
}