package test;
import testbase.TestBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class FinnsPåLager extends TestBase {

    @Test
    void finnsPåLager() {
        page.navigate("https://www2.hm.com/sv_se/productpage.1160975001.html");

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Tillåt alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();
            
            page.locator("button[aria-label='Hitta en butik där du kan köpa den här varan']").click();

            Locator addressInput = page.locator("#addressAutocomplete");
            addressInput.fill("17453");

            Locator suggestionItem = page.locator("button.SuggestionItem-module--suggestion__180Vz");
            suggestionItem.click();

            
            String expectedText = "Det finns inga butiker som stämmer med dina sökkriterier.";
            Locator storeSearchTextLocator = page
                    .locator("p.BodyText-module--general__jkobl.StoreSearchContent-module--textGrey__b82Cq");
            String actualText = storeSearchTextLocator.innerText();
            Assertions.assertEquals(expectedText, actualText, "Texten matchar inte förväntat värde.");
          
        }
    }
}
