package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoopGurka {


	final Page page;
	Locator inputsearch;
	Locator searchConfirm;
	Locator selectGurka;
	Locator imgAltassert;
	
	public CoopGurka (Page page) {
		
	this.page = page;
    this.inputsearch = page.locator("[data-test=\"searchHeader\"]").getByPlaceholder("Sök recept, varor, butiker och artiklar");
    this.searchConfirm = page.locator("#portal").getByPlaceholder("Sök recept, varor, butiker och artiklar");
    this.selectGurka = page.getByLabel("Gurka", new Page.GetByLabelOptions().setExact(true));
    this.imgAltassert = page.locator("img[alt='Gurka']");
	
}
	
	public void openCoopPage () {
	
	String openUrl = "https://www.coop.se/";
	page.navigate(openUrl);
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla cookies")).click();

	
}
	
	public void selectGurkaproduct() {
	
	inputsearch.click();
	inputsearch.fill("gurka");
	searchConfirm.press("Enter");
	selectGurka.click();
	
}

	public void assertImgGurka () {
		
	       assertNotNull(imgAltassert);

           String altText = imgAltassert.getAttribute("alt");

           assertEquals("Gurka", altText);
		
		
	}

}

