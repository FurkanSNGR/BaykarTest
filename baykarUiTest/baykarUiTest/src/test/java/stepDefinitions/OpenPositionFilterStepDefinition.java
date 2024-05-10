package stepDefinitions;

import io.cucumber.java.en.*;
import pages.OpenPositionPage;

public class OpenPositionFilterStepDefinition {

    OpenPositionPage openPositionPage = new OpenPositionPage();

    @Then("Tum pozisyonların verisi cekilir ve ilgili pozisyon aranarak filtreleme islemi yapilir")
    public void getOpenPositions() {
        openPositionPage.getAndFilterOpenPositions();

    }

}
