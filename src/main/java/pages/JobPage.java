package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class JobPage extends ParentPage{
    public JobPage(String partURL) {
        super(partURL);
    }

    SelenideElement requirements = $(byXpath(".//h3[text()='Requirements;']"));
    SelenideElement description = $(byXpath(".//h3[text()='Our Engineering Culture']"));
    SelenideElement applyButton = $(byXpath(".//a[text()='Apply for this job']"));
    SelenideElement applicationFormTitle = $(byXpath(".//div[@class='section page-centered application-form']/h4[text()='Submit your application']"));

    public boolean checkIfElementsDisplayed(){
        return requirements.isDisplayed()&&description.isDisplayed()&&applyButton.isDisplayed();
    }

    public boolean isApplicationFormDisplayed(){
        applicationFormTitle.waitUntil(Condition.visible,defaultTimeout);
        return applicationFormTitle.isDisplayed();
    }

    public void clickOnApplyButton(){
        applyButton.click();
    }


}
