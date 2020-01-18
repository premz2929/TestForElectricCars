
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Admin {

    ChromeDriver driver = new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "/Users/mac/IdeaProjects/MiloPages/chromedriver");
        // Wejście na stronę localhost:8080
        driver.get("localhost:8080");
        // powiększenie okna
        driver.manage().window().maximize();
    }

    public void login() {
        // Znalezienie i zapisanie w zmiennej xpatha do inputu z loginem
        WebElement element = driver.findElementByXPath("//*[@id=\"firstName\"]");
        // wpisanie w input "user"
        element.sendKeys("admin");
        // nacisniecie na button zaloguj
        driver.findElementByXPath("/html/body/div/form/div/div/button").click();
    }

    public void getString() {
        String liczbaAut = driver.findElementByXPath("/html/body/div/div[7]/form/div/div[3]/p").getText();
        System.out.println(liczbaAut);
        String liczbaUzytkownikow = driver.findElementByXPath("/html/body/div/div[7]/form/div/div[5]/p").getText();
        System.out.println(liczbaUzytkownikow);
        String liczbaZapytan = driver.findElementByXPath("/html/body/div/div[7]/form/div/div[7]/p").getText();
        System.out.println(liczbaZapytan);
        String liczbaSpelnionychZapytan = driver.findElementByXPath("/html/body/div/div[7]/form/div/div[9]/p").getText();
        System.out.println(liczbaSpelnionychZapytan);
    }

    public void addNewCar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // wejscie na podstrone "baza samochodow"
        driver.get("http://localhost:8080/cars");
        // nacisniecie na przycisk "dodaj samochod"
        driver.findElementByXPath("/html/body/div/div[6]/div/div/div/a").click();
        WebElement marka = driver.findElementById("brand");
        marka.sendKeys("Volkswagen");
        WebElement model = driver.findElementById("model");
        model.sendKeys("Test");
        WebElement cena = driver.findElementById("price");
        cena.clear();
        cena.sendKeys("136400");
        WebElement maxPredkosc = driver.findElementById("max_speed");
        maxPredkosc.clear();
        maxPredkosc.sendKeys("200");
        WebElement konieMechaniczne = driver.findElementById("horsePowers");
        konieMechaniczne.clear();
        konieMechaniczne.sendKeys("140");
        WebElement zasieg = driver.findElementById("distance_per_km");
        zasieg.clear();
        zasieg.sendKeys("140");
        WebElement przyspieszenieWSekundach = driver.findElementById("acceleration_in_seconds");
        przyspieszenieWSekundach.clear();
        przyspieszenieWSekundach.sendKeys("9.2");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/button").click();
        if (driver.getPageSource().contains("VOLKSWAGEN")) {
            System.out.println("Text is Present");
        } else {
            System.out.println("Text is not Present");
        }
    }

    public void editCar() {
        driver.get("http://localhost:8080/cars");
        driver.findElementByXPath("/html/body/div/div[6]/div/div/form/table/tbody/tr[17]/td[9]/a").click();
        WebElement marka = driver.findElementById("brand");
        marka.clear();
        marka.sendKeys("Test");
        WebElement model = driver.findElementById("model");
        model.clear();
        model.sendKeys("Test");
        WebElement cena = driver.findElementById("price");
        cena.clear();
        cena.sendKeys("200000");
        WebElement maxPredkosc = driver.findElementById("max_speed");
        maxPredkosc.clear();
        maxPredkosc.sendKeys("450");
        WebElement konieMechaniczne = driver.findElementById("horsePowers");
        konieMechaniczne.clear();
        konieMechaniczne.sendKeys("310");
        WebElement zasieg = driver.findElementById("distance_per_km");
        zasieg.clear();
        zasieg.sendKeys("400");
        WebElement przyspieszenieWSekundach = driver.findElementById("acceleration_in_seconds");
        przyspieszenieWSekundach.clear();
        przyspieszenieWSekundach.sendKeys("4.0");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/button").click();
    }

    public void deleteCar() {
        // wejscie na podstrone "baza samochodow"
        driver.get("http://localhost:8080/cars");
        driver.findElementByXPath("/html/body/div/div[6]/div/div/form/table/tbody/tr[17]/td[10]/a").click();
    }
    public void addNewUser() {
        driver.get("http://localhost:8080/users");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/a").click();
        WebElement imieUzytkownika = driver.findElementById("name");
        imieUzytkownika.clear();
        imieUzytkownika.sendKeys("Test");
        WebElement adresEmail = driver.findElementById("email");
        adresEmail.clear();
        adresEmail.sendKeys("test@test.pl");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/button").click();
    }
    public void editUser() {
        driver.get("http://localhost:8080/users");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/table/tbody/tr[4]/td[5]/a").click();
        WebElement imieUzytkownika = driver.findElementById("name");
        imieUzytkownika.clear();
        imieUzytkownika.sendKeys("TestTest");
        WebElement adresEmail = driver.findElementById("email");
        adresEmail.clear();
        adresEmail.sendKeys("testTest@test.pl");
        driver.findElementByXPath("/html/body/div/div[7]/div/div/form/button").click();
    }

    public void newTeslaQuery() {

        driver.findElementByXPath("/html/body/div/div[6]/div/div[7]/a").click();
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
