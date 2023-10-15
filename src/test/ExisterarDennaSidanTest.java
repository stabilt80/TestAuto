package test;
import testbase.TestBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExisterarDennaSidanTest extends TestBase {

	@Test
	public void existerarDennaSidanTest() {
	
		page.navigate("https://www.zalando.se/man-home/");
		page.waitForTimeout(5000); 

		boolean isHomePageLoaded = page.isVisible("body");


		Assertions.assertTrue(isHomePageLoaded, "Hemsidan laddades inte korrekt eller visades inte på skärmen.");
	}
}