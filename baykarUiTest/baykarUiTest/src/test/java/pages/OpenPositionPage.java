package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

import static utilities.Driver.driver;

public class OpenPositionPage {

    public OpenPositionPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    public static void getAndFilterOpenPositions() {

        List<WebElement> departments = driver.findElements(By.xpath("//ul[@id='myUL2']/div"));

        String[] departmentNames = new String[departments.size()];

        for (int i = 0; i < departments.size(); i++) {
            departmentNames[i] = departments.get(i).getText();
        }

        filterPositions(departmentNames);
    }

    public static void trimLastSpaceIndex(String[] departmentLastName) {
        for (int i = 0; i < departmentLastName.length; i++) {
            String originalString = departmentLastName[i];
            int lastSpaceIndex = originalString.lastIndexOf(' ');

            if (lastSpaceIndex != -1) {
                String trimmedString = originalString.substring(0, lastSpaceIndex);
                departmentLastName[i] = trimmedString;
            }
        }
    }

    public static void filterPositions(String[] departmentNames) {

            trimLastSpaceIndex(departmentNames);

        for (String departmentName : departmentNames) {
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='myInput2']"));
            searchBox.sendKeys(departmentName);

            String filterSearch = String.format("//input[@type='checkbox' and @value='%s']", departmentName);
            WebElement txtJobTitle = driver.findElement(By.xpath(filterSearch));
            txtJobTitle.click();

            List<WebElement> resultDepartments = driver.findElements(By.xpath("//ul[@id='myUL']/li/div/div[2]"));
            String[] resultDepartmentNames = new String[resultDepartments.size()];

            for (int i = 0; i < resultDepartments.size(); i++) {
                resultDepartmentNames[i] = resultDepartments.get(i).getText();
            }

            if (departmentName.equals(resultDepartmentNames[0])) {
                System.out.println(departmentName + "Filtreleme işlemi başarılı");
            } else {
                System.out.println("Filtreleme işlemi başarısız");
            }

            txtJobTitle.click();
            searchBox.clear();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
