package test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import testbase.TestBase;

import org.junit.jupiter.api.Test;


//fick inte denna att fungera, 
//fick inte denna att fungera, 


public class Bokus extends TestBase {

	@Test
	void bokus() {
	    page.navigate("https://www.bokus.com");

	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla cookies")).click();

	    page.getByPlaceholder("Sök bland 10 miljoner böcker").fill("harry potter");
	    page.getByPlaceholder("Sök bland 10 miljoner böcker").press("Enter");

	    page.locator(".Item__cta > .btn").first().click();
	    page.locator("#message-goto-checkout").click();

	    page.waitForSelector("[data-testid='checkout-button']", new Page.WaitForSelectorOptions().setTimeout(10000)).click();

	    String currentURL = page.url();
	    assert currentURL.contains("/checkout") : "Du är inte på kassasidan.";
	}

}