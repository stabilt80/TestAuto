package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ZalandoDyrastSkor {
    private final Page page;
    private Locator inputSearch;
    private Locator sortButton;
    private Locator högstapris;

    public ZalandoDyrastSkor(Page page) {
        this.page = page;
        this.inputSearch = page.locator("[placeholder='Sök']");
        this.sortButton = page.locator("[role='button'][name='Sortera']");
        this.högstapris = page.locator("text=Högsta pris");
    }

    public void openStartPage() {
        String url = "https://www.zalando.se";
        page.navigate(url);
    }

    public void searchProduct() {
        inputSearch.fill("skor");
        inputSearch.press("Enter");
    }

    public void sortProductsByPrice() {
        sortButton.click();
        högstapris.click();
    }
    
    
    
}
