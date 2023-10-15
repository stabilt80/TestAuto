package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ZalandoLogin {
	
	private final Page page;
	Locator loginPageButton;
	Locator userEmail;
	Locator userPassword;
	Locator sendButton;
	Locator respons;
	
	public ZalandoLogin(Page page) {
		
		this.page = page;
		this.loginPageButton = page.getByTestId("user-account-icon");
		this.userEmail = page.getByPlaceholder("E-postadress");
		this.userPassword = page.getByPlaceholder("Lösenord");
		this.sendButton = page.getByTestId("login_button");
		this.respons = page.locator("//*[@id='sso']/div/div[2]/main/div/div[2]/div/div/div/form/div[2]/div/div[2]/span");
	}

	public void opetStartPage() {
		
		String url = "https://www.zalando.se";
		page.navigate(url);
		
	}
	
	public void pageLogin(String inputEmail, String inputPassword) {
		
		loginPageButton.click();
		userEmail.fill(inputEmail);
		userPassword.fill(inputPassword);
		sendButton.click();
		
	}
	
}
