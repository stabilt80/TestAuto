package test;
import testbase.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class Navigation extends TestBase {

	@Test
	void navigation() {
		page.navigate("https://www2.hm.com/sv_se/index.html");

			Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("Tillåt alla cookies"));

		
			if (acceptCookies.isVisible()) {
			acceptCookies.click();

			page.click("text=Herr");

			String expectedUrl = "https://www2.hm.com/sv_se/herr.html";
			String currentUrl = page.url();
			assertTrue(currentUrl.contains(expectedUrl), "Failed to navigate to the Herr section");
		}
	}
}