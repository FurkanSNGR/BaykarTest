package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.NavbarPage;

public class NavbarStepDefinition {

    NavbarPage navbarPage = new NavbarPage();

    @Then("Navbar alanindaki butonlarin dogru sayfaya yonlendirdigi kontrol edilir")
    public void navbarButtonsControl() {
        navbarPage.navbarElementsControl();
    }
}
