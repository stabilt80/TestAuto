package test;

import org.junit.jupiter.api.Test;

import page.HerokuNotificationMessage;
import testbase.TestBase;


public class HerokuNotificationMessageTest extends TestBase  {

      @Test
    public void herokuNotificationMessageTest () {
        
        HerokuNotificationMessage herokuNotificationMessageTest = new HerokuNotificationMessage(page);
        
        herokuNotificationMessageTest.openHerokuPage();
        herokuNotificationMessageTest.clickLink();
        
        herokuNotificationMessageTest.assertMessage();
        
        
        
    }
    

      
      
}