package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.Driver;

public class BrowserStepDefinition {

    @Given("Kariyer Baykar TR anasayfasina girilir")
    public void kariyerBaykarAnasayfasinaGirilir() {
        Driver.getDriver().get(ConfigReader.getProperty("kariyerBaykarURL"));
    }

    @Given("Acik pozisyonlar sayfasina girilir")
    public void acikPozisyonlarSayfasinaGirilir() {
        Driver.getDriver().get(ConfigReader.getProperty("acikPozisyonlarURL"));
    }

    @And("Tarayici Kapatilir")
    public void closeWebDriver() {
        Driver.quitDriver();
    }
}
