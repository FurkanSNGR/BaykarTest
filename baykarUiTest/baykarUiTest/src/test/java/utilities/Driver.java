package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver() {  // Default constructor'u devre dısı bırakmak yani SingletonPattern yapmak icin kullanılıyor

    }

    public static WebDriver driver;   // static olmalı cunku getDriver() ve closeDriver() methodu static

    /*
    Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu için her test methodu
    için yeni bir pencere(driver) açıyor. Eğer driver'a bir değer atanmamışsa yani driver==null ise
    bir kere driver'i çalıştır diyerek bir kere if içini çalıştıracak. Ve driver artık bir kere
    çalıştığı için ve değer atandığı için null olmayacak ve direk return edecek ve diğer
    teslerimiz aynı pencere(driver) üzerinde çalışacak
     */

    public static WebDriver getDriver() {  // void yapmıyoruz cunku biz driver ile methodlari çalıştıracağız. Bize driver
        // dondurmesi lazim ki, getDriver() methodundan sonra driver methodlarina ulasabilelim

        if (driver == null) {               // burda driverin değeri null ise yani driver açık değilse bize driveri açsın,çalıştırsın
            switch (ConfigReader.getProperty("browser")) {
                case "chrome" :
                    driver = new ChromeDriver();
                    break;

                case "safari" :
                    driver = new SafariDriver();
                    break;
                case "firefox" :
                    driver = new FirefoxDriver();
                    break;
                case "edge" :
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver () {

        if (driver != null) { //burasi getDriver() ile driver calistiginda driverin değeri null değildir. Yani driver açıktır.
            // o halde test sonunda closeDriver() methodunu kullandığımızd çalışsn
            driver.close();
            driver = null; // değer olarak null atiyoruz cunku getDriver() methodunun if bodysi devreye girsin ve driver çalışsın

        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void tabHandle() {
        driver.switchTo().newWindow(WindowType.TAB);
    }


}
