package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import static utilities.Driver.driver;

public class LanguageContentPage {

    public LanguageContentPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//li[@class='siteCustomLi']/a")
    static WebElement btnLanguage;

    public static void languageContentControl(){

        String initialText = btnLanguage.getText();
        String currentText = initialText;
        btnLanguage.click();

        while (true) {

            WebElement htmlElement = driver.findElement(By.tagName("html"));
            String htmlLang = htmlElement.getAttribute("lang");

            if (htmlLang.contains(initialText.toLowerCase())) {
                System.out.println("Dil değişimi başarılı! " + initialText + " dilinde sayfa yüklendi.");
                currentText = btnLanguage.getText();
                btnLanguage.click();
            } else {
                System.out.println("Hata! Sayfa belirtilen dilde yüklenmedi.");
            }

            if (currentText.equals("TR")) {
                System.out.println("Dil değişimi başarılı! " + currentText + " dilinde sayfa yüklendi.");
                break;
            }
        }

    }
}
