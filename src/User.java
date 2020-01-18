import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;


public class User {

    ChromeDriver driver = new ChromeDriver();
    // JavaScriptExecutor jest odpowiedzialny za scrollowanie strony
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void TestQA() {
        System.setProperty("webdriver.chrome.driver", "/Users/mac/IdeaProjects/MiloPages/chromedriver");
        // Wejście na stronę localhost:8080
        driver.get("localhost:8080");
        // powiększenie okna
        driver.manage().window().maximize();
    }

    // Metoda odpowiadajaca za login
    public void login() {
        // Znalezienie i zapisanie w zmiennej xpatha do inputu z loginem
        WebElement element = driver.findElementByXPath("//*[@id=\"firstName\"]");
        // wpisanie w input "user"
        element.sendKeys("user");
        // nacisniecie na button zaloguj
        driver.findElementByXPath("/html/body/div/form/div/div/button").click();
    }

    // Metoda dodajaca nowe zapytanie
    public void newTeslaQuery() {
        // nacisniecie na przycisk dodaj zapytanie
        driver.findElementByXPath("/html/body/div/div[7]/div/div/a").click();
        // nacisniecie na wybor marki auta
        driver.findElementByXPath("//*[@id=\"brand\"]").click();
        // wybor czwartej opcji w menu rozwijanym
        driver.findElementByXPath("//*[@id=\"brand\"]/option[4]").click();
        // zapisanie do zmiennej xpatha do inputa z dystansem od
        WebElement dystansOd = driver.findElementByXPath("//*[@id=\"distanceFrom\"]");
        // wyczyszczenie inputa
        dystansOd.clear();
        // wpisane do inputa wartosci 100
        dystansOd.sendKeys("100");
        WebElement dystansDo = driver.findElementByXPath("//*[@id=\"distanceTo\"]");
        dystansDo.clear();
        dystansDo.sendKeys("10000");
        WebElement minKoniMechanicznych = driver.findElementByXPath("//*[@id=\"minHorsePowers\"]");
        minKoniMechanicznych.clear();
        minKoniMechanicznych.sendKeys("100");
        WebElement maxKoniMechanicznych = driver.findElementByXPath("//*[@id=\"maxHorsePowers\"]");
        maxKoniMechanicznych.clear();
        maxKoniMechanicznych.sendKeys("10000");
        WebElement cenaOd = driver.findElementByXPath("//*[@id=\"priceFrom\"]");
        cenaOd.clear();
        cenaOd.sendKeys("100000");
        WebElement cenaDo = driver.findElementByXPath("//*[@id=\"priceTo\"]");
        cenaDo.clear();
        cenaDo.sendKeys("300000");

        // nacisniecie przycisku dodaj zapytanie
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/button").click();
        js.executeScript("window.scrollBy(0,320)");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Metoda odpowiedzalna za wejscie na dana strone i sprawdzenie czy znajduje sie na niej dany text
    public void enterToQuery() {
        driver.get("http://localhost:8080/matchedCars/queryId=332");
        // sprawdzenie czy dany text znajduje sie na stronie
        if (driver.getPageSource().contains("Model 3 (Long Range Dual Motor)")) {
            System.out.println("Text is Present");
        } else {
            System.out.println("Text is not Present");
        }
        if (driver.getPageSource().contains("Model 3 (Standard Range)")) {
            System.out.println("Text is Present");
        } else {
            System.out.println("Text is not Present");
        }
    }

    // Metoda odpowiadajaca za edycje zapytania.
    public void editQuery() {
        driver.get("http://localhost:8080/userQueries");
        // Wejscie w "Edytuj"
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/table/tbody/tr[2]/td[3]/a").click();
        // nacisniecie na wybor marki auta
        driver.findElementByXPath("//*[@id=\"brand\"]").click();
        // wybor czwartej opcji w menu rozwijanym
        driver.findElementByXPath("//*[@id=\"brand\"]/option[6]").click();
        // zapisanie do zmiennej xpatha do inputa z dystansem od
        WebElement dystansOd = driver.findElementByXPath("//*[@id=\"distanceFrom\"]");
        // wyczyszczenie inputa
        dystansOd.clear();
        // wpisane do inputa wartosci 100
        dystansOd.sendKeys("10");
        WebElement dystansDo = driver.findElementByXPath("//*[@id=\"distanceTo\"]");
        dystansDo.clear();
        dystansDo.sendKeys("300000");
        WebElement minKoniMechanicznych = driver.findElementByXPath("//*[@id=\"minHorsePowers\"]");
        minKoniMechanicznych.clear();
        minKoniMechanicznych.sendKeys("50");
        WebElement maxKoniMechanicznych = driver.findElementByXPath("//*[@id=\"maxHorsePowers\"]");
        maxKoniMechanicznych.clear();
        maxKoniMechanicznych.sendKeys("350");
        WebElement cenaOd = driver.findElementByXPath("//*[@id=\"priceFrom\"]");
        cenaOd.clear();
        cenaOd.sendKeys("100000");
        WebElement cenaDo = driver.findElementByXPath("//*[@id=\"priceTo\"]");
        cenaDo.clear();
        cenaDo.sendKeys("500000");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/button").click();
        // Tutaj uzywam sleepa do sprawdzenia czy faktycznie udalo sie edytowac zapytanie
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // przeskrolowanie strony
        js.executeScript("window.scrollBy(0,600)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuery() {
        driver.get("http://localhost:8080/userQueries");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/table/tbody/tr[5]/td[4]/a").click();
    }

    public void logout() {
        driver.get("http://localhost:8080/userQueries");
        driver.findElementByXPath("/html/body/div/div[2]/div[2]/p/a[2]").click();
    }
}



