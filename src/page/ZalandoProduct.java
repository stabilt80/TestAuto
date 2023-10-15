package page;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ZalandoProduct {
	
	final Page page;
	Locator inputSearch;
	Locator chooseOption;
	Locator chooseProduct;
	Locator sizeOption;
	Locator chooseSize;
	Locator addProduct;
	Locator goToCart;
	Locator assertProduct;
	
	public ZalandoProduct (Page page) {
		
		this.page = page;
		this.inputSearch = page.getByPlaceholder("Sök");
		this.chooseOption = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("jacka").setExact(true));
		this.chooseProduct =  page.locator(".I7OI1O > div:nth-child(2) > div").first();
		this.sizeOption = page.getByTestId("pdp-size-picker-trigger");	
		this.chooseSize = page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^S$"))).nth(2);
		this.addProduct = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Handla"));
		this.goToCart = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Till varukorgen"));
		this.assertProduct = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gå till kassan"));
	}
	

	public void openStartPage() {
        String loginUrl = "https://www.zalando.se/";
        page.navigate(loginUrl);
    }

    public void searchAndAddProduct() {
    	inputSearch.fill("jacka");
    	chooseOption.click();
    	chooseProduct.click();
    	sizeOption.click();
    	chooseSize.click();
    	addProduct.click();
    	goToCart.click();
 
    }
    
    public void assertProductBuyButton() {
    	
    	Assertions.assertTrue(assertProduct.isVisible());
    }

}