package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends ParentPage {
    public MainPage(String partURL) {
        super(partURL);
    }

    SelenideElement careerTab = $(byId("menu-item-21643"));
    SelenideElement getDemoButton = $(byXpath(".//div[@class='col span_12  left']//span[text()='GET A DEMO']"));

    public void clickOnCareerTab() {
        careerTab.click();
    }

    public boolean isGetDemoButtonVisible() {
        if (getDemoButton.isDisplayed()) {
            return true;
        }
        return false;
    }
}
