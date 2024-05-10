package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

import static utilities.Driver.driver;

public class NavbarPage {
    public NavbarPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    public static void navbarElementsControl(){

        List<WebElement> navbarElements = driver.findElements(By.xpath("//div[@id='navbar-menu']/ul/li"));

        for (WebElement element : navbarElements) {

            if (element.isEnabled()) {
                element.click();
            }

            System.out.println(element.getText());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
