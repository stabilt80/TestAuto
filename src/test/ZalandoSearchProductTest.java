package test;

import org.junit.jupiter.api.Test;

import page.ZalandoProduct;

public class ZalandoSearchProductTest extends testbase.TestBase {
	
	
	@Test
public void zalandoProductTest() {
	
		ZalandoProduct zalandoSearchProductTest = new ZalandoProduct(page);
		zalandoSearchProductTest.openStartPage();
		zalandoSearchProductTest.searchAndAddProduct();
		zalandoSearchProductTest.assertProductBuyButton();
		
}

}