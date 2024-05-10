package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.LanguageContentPage;

public class LanguageStepDefinition {

    LanguageContentPage languageContentPage = new LanguageContentPage();

    @Then("Sayfa Dili degistirilir ve icerigin dogru oldugu kontrol edilir")
    public void navbarButtonsControl() {
        languageContentPage.languageContentControl();
    }
}
