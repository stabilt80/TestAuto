package page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HerokuNotificationMessage {
	
	private final Page page;
	private Locator linkNotificationMessages;
	private Locator clickHereButton;
	
	 
	
	
	public HerokuNotificationMessage (Page page) {
		
		this.page = page;
		this.setLinkNotificationMessages(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Notification Messages")));
		this.setClickHereButton(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Click here")));
	}


	public void openHerokuPage () {
		
		String loginUrl = "https://the-internet.herokuapp.com/";
		page.navigate(loginUrl);
		
	}

	
	public void clickLink() {
		linkNotificationMessages.click();
		clickHereButton.click();
		
	}
	
	
	
	public void assertMessage() {
		
		String successMessage = "Action successful";
		String errorMessage = "Action unsuccessful, please try again";

		boolean successMessageFound = page.waitForSelector("text=" + successMessage) != null;
		boolean errorMessageFound = page.waitForSelector("text=" + errorMessage) != null;

		if (successMessageFound || errorMessageFound) {
		    if (successMessageFound) {
		        System.out.println(successMessage + " found! Success Message");
		        assertEquals(true, successMessageFound);
		    } else {
		        System.out.println(errorMessage + " found! Error Message");
		        assertEquals(true, errorMessageFound);
		    }
		} else {
		    
		    System.out.println("Neither message found!");
		    assertNotEquals(true, successMessageFound);
		}
	}
	
	
		
	
	
	
	
	
	

	public Locator getLinkNotificationMessages() {
		return linkNotificationMessages;
	}

	public void setLinkNotificationMessages(Locator linkNotificationMessages) {
		this.linkNotificationMessages = linkNotificationMessages;
	}

	public Locator getClickHereButton() {
		return clickHereButton;
	}

	public void setClickHereButton(Locator clickHereButton) {
		this.clickHereButton = clickHereButton;
	}

	public Page getPage() {
		return page;
	}

}
