import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLLIElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstAndroidTest {
    public static AppiumDriver driver;
    public static boolean isLoggedIn;
    private static final int languageId = 1;
    DesiredCapabilities caps = new DesiredCapabilities();
    @BeforeTest
    public  void setUp()throws MalformedURLException {
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","13");
        caps.setCapability("deviceName","R58R63TKBKH");//R58R63TKBKH
        caps.setCapability("browserName","Chrome");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    @Test
    public void StockReturnCalculatorTest() throws InterruptedException
    {
        if(!isLoggedIn) {
            LoginTest();
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //النمو والتوزيعات
        //Growth and Dividends
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("57",linkText);
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                WebElement CalculateReturn = driver.findElement(By.id("butnclick"));
                WebElement searchInput = driver.findElement(By.id("searchInput"));
                searchInput.click();
                WebElement chkBoxCompanyList = driver.findElement(By.id("3509_companylist"));
                chkBoxCompanyList.click();

                Thread.sleep(100);
                CalculateReturn.click();
//                WebElement searchInput2 = driver.findElement(By.id("searchInput"));
//                searchInput2.click();
//                WebElement chkBoxCompanyList2 = driver.findElement(By.id("81_companylist"));
//                chkBoxCompanyList2.click();
//                CalculateReturn.click();
//                WebElement searchInput3 = driver.findElement(By.id("searchInput"));
//                searchInput3.click();
//                WebElement chkBoxCompanyList3 = driver.findElement(By.id("600_companylist"));
//                chkBoxCompanyList3.click();
//                CalculateReturn.click();
//                WebElement searchInput4 = driver.findElement(By.id("searchInput"));
//                searchInput4.click();
//                WebElement chkBoxCompanyList4 = driver.findElement(By.id("577_companylist"));
//                chkBoxCompanyList4.click();
//                CalculateReturn.click();
//                WebElement searchInput5 = driver.findElement(By.id("searchInput"));
//                searchInput5.click();
//                WebElement chkBoxCompanyList5 = driver.findElement(By.id("104_companylist"));
//                chkBoxCompanyList5.click();
//                CalculateReturn.click();

                WebElement comparisonPopUp = driver.findElement(By.id("comparison_popup"));
                String style = comparisonPopUp.getAttribute("style");
                Thread.sleep(10);
                js.executeScript("$('#comparison_popup').attr('style','display:none')");
                Thread.sleep(10);
                Thread.sleep(100);
                break;
            }
           //driver.close();
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
       // String parent = driver.getWindowHandle();
        //System.out.println(driver.getWindowHandles().size());
        //Set<String> windowHandles = driver.getWindowHandles();
//        Iterator<String> I1 = windowHandles.iterator();
//        while (I1.hasNext()) {
//            String child_window = I1.next();
//            if (!parent.equals(child_window)) {
//                driver.switchTo().window(child_window);
//                Thread.sleep(100);


                /*WebElement id3 = driver.findElement(By.id("companyid-577"));
                js.executeScript("$('#companyid-577')[0].scrollIntoView();", id3);
                Thread.sleep(100);
                WebElement id5 = driver.findElement(By.id("companyid-600"));
                js.executeScript("$('#companyid-600')[0].scrollIntoView();", id5);
                Thread.sleep(100);
                WebElement id2 = driver.findElement(By.id("companyid-81"));
                js.executeScript("$('#companyid-81')[0].scrollIntoView();", id2);
                Thread.sleep(100);
                WebElement id1 = driver.findElement(By.id("companyid-3509"));
                js.executeScript("$('#companyid-3509')[0].scrollIntoView();", id1);
                Thread.sleep(100);
                WebElement id4 = driver.findElement(By.id("companyid-77"));
                js.executeScript("$('#companyid-77')[0].scrollIntoView();", id4);
                Thread.sleep(100);*/

//            }
        }
    @Test
    public void DividentYield() throws InterruptedException
    {
        if(!isLoggedIn) {
            LoginTest();
        }

        Thread.sleep(500);
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("51",linkText);
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {

            if(!originalWindow.contentEquals(windowHandle)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                driver.switchTo().window(windowHandle);
                Thread.sleep(100);
                WebElement linkTab5Years = FindElementById("5years");
                linkTab5Years.click();
                Thread.sleep(100);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);window.scroll(0,0);");

                Thread.sleep(100);
                WebElement linkTab7Years = FindElementById("7years");
                linkTab7Years.click();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);window.scroll(0,0);");

                Thread.sleep(100);
                WebElement linkTab10Years = FindElementById("10years");
                linkTab10Years.click();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);window.scroll(0,0);");

                Thread.sleep(100);
                WebElement linkTab12Years = FindElementById("12years");
                linkTab12Years.click();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);window.scroll(0,0);");

                Thread.sleep(100);
                WebElement linkTab15Years = FindElementById("15years");
                linkTab15Years.click();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);window.scroll(0,0);");

                Thread.sleep(100);
                WebElement linkTab20Years = FindElementById("20years");
                linkTab20Years.click();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);window.scroll(0,0);");
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);

        //wait.until(titleIs("العائد الكلي (ترتيب الشركات)"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        System.out.println(driver.getWindowHandles().size());
//        Thread.sleep(500);
//        js.executeScript("$('button.menu-toggle').click()");
//        WebElement link = driver.findElement(By.id("51"));
//        link.click();
//        System.out.println(driver.getWindowHandles().size());
//
//        String parent = driver.getWindowHandle();
//
//        Set<String> windowHandles = driver.getWindowHandles();
//        Iterator<String> I1 = windowHandles.iterator();
//
//        while (I1.hasNext()) {
//            String child_window = I1.next();
//            if (!parent.equals(child_window)) {
//                System.out.println("child window");
//                driver.switchTo().window(child_window);
//                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
//
//            }
//        }


    }
    @Test
    public void DividentYieldDetailed() throws InterruptedException
    {
        if(!isLoggedIn) {
            LoginTest();
        }
        Thread.sleep(500);
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("52",linkText);
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
        //wait.until(titleIs("العائد الكلي حسب الشركة"));
    }
    @Test
    public void CompanyPerformanceById() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        Thread.sleep(100);
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("45",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
        //wait.until(titleIs("أداء السوق والشركات الشهري والفصلي"));
    }
    @Test
    public void TopGrowthCompanies() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        Thread.sleep(100);
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("26",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
        //wait.until(titleIs("الشركات الأعلى نمواً"));
    }
    @Test
    public void TopLoosingCompanies() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        Thread.sleep(100);
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("27",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
        //wait.until(titleIs("الشركات الأكثر تسجيلا للخسائرً"));
    }
    @Test
    public void DividendHistory() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("28",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
        //wait.until(titleIs("التوزيعات النقدية التاريخيةً"));
    }
    @Test
    public void TopDividendCompanies() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "النمو والتوزيعات" : "Growth and Dividends";
        GetNewWindowClick("29",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ConsumerandMortgageLoans() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "بيانات اقتصادية" : "Economic data";
        GetNewWindowClick("58",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void Inflation() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "بيانات اقتصادية" : "Economic data";
        GetNewWindowClick("13",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void MonetaryAndEconomicStatistics() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "بيانات اقتصادية" : "Economic data";
        GetNewWindowClick("10",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ConsumerSpending() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "بيانات اقتصادية" : "Economic data";
        GetNewWindowClick("12",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void MacroEconomyData() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "بيانات اقتصادية" : "Economic data";
        GetNewWindowClick("11",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ExportsAndImports() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "بيانات اقتصادية" : "Economic data";
        GetNewWindowClick("14",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void PetroChemicalPricesAndQuantities() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البتروكيماويات" : "PetroChemical";
        GetNewWindowClick("43",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void PetroChemicalRanking() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البتروكيماويات" : "PetroChemical";
        GetNewWindowClick("20",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void PetroChemicalRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البتروكيماويات" : "PetroChemical";
        GetNewWindowClick("21",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ReitsRanking() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "صناديق الريتس" : "REITs";
        GetNewWindowClick("39",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ReitsEssentialRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "صناديق الريتس" : "REITs";
        GetNewWindowClick("41",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ReitPropertyValuation() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "صناديق الريتس" : "REITs";
        GetNewWindowClick("38",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void SaiborAndLaiborRates() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البنوك" : "Banks";
        GetNewWindowClick("56",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ImpliedPricesForBanks() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البنوك" : "Banks";
        GetNewWindowClick("40",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ValuationsOfBanksComparisons() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البنوك" : "Banks";
        GetNewWindowClick("37",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void BanksAggregatedData() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البنوك" : "Banks";
        GetNewWindowClick("36",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void BanksEssentialRatiosAndComparisons() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البنوك" : "Banks";
        GetNewWindowClick("5",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void BanksRanking() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "البنوك" : "Banks";
        GetNewWindowClick("8",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void BusinessSegmentsForInsuranceCompanies() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "التأمين" : "Insurance";
        GetNewWindowClick("50",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void InsuranceCompaniesRanking() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "التأمين" : "Insurance";
        GetNewWindowClick("49",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void AggregatedDataForInsuranceSector() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "التأمين" : "Insurance";
        GetNewWindowClick("46",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void InsuranceCompaniesEssentialRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "التأمين" : "Insurance";
        GetNewWindowClick("48",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void PriceToEarningsRatio() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "المؤشرات المالية" : "Financial Ratios";
        GetNewWindowClick("32",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ReturnOnAssetsAndEquity() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "المؤشرات المالية" : "Financial Ratios";
        GetNewWindowClick("33",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void PricePerBookRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "المؤشرات المالية" : "Financial Ratios";
        GetNewWindowClick("34",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void NetDebtPerEquity() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "المؤشرات المالية" : "Financial Ratios";
        GetNewWindowClick("35",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void OilGasAndFuelPricesData() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "النفط والغاز" : "Oil and Gas";
        GetNewWindowClick("9",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void CementStatistics() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "الأسمنت" : "Cement";
        GetNewWindowClick("7",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void CementCompaniesEssentialRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "الأسمنت" : "Cement";
        GetNewWindowClick("19",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void CementRankings() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "الأسمنت" : "Cement";
        GetNewWindowClick("15",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void FoodPrices() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "السلع الاستهلاكية" : "Consumer Goods";
        GetNewWindowClick("16",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void ConstructionMaterials() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "السلع الاستهلاكية" : "Consumer Goods";
        GetNewWindowClick("18",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void NonFoodPrices() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "السلع الاستهلاكية" : "Consumer Goods";
        GetNewWindowClick("17",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void RetailRankings() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "التجزئة" : "Retails";
        GetNewWindowClick("22",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void RetailRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "التجزئة" : "Retails";
        GetNewWindowClick("23",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void GroceryRanking() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "المواد الغذائية" : "Grocery Retailers";
        GetNewWindowClick("24",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void GroceryRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "المواد الغذائية" : "Grocery Retailers";
        GetNewWindowClick("25",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void MedCareRanking() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "الرعاية الصحية" : "Med Care";
        GetNewWindowClick("30",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public void MedCareRatios() throws InterruptedException
    {
        if (!isLoggedIn) {
            LoginTest();
        }
        System.out.println(driver.getWindowHandles().size());
        Thread.sleep(500);
        String linkText = languageId == 1 ? "الرعاية الصحية" : "Med Care";
        GetNewWindowClick("31",linkText);

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(500);
                break;
            }
        }
        Thread.sleep(100);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
    @Test
    public static boolean LoginTest() {
        driver.get("https://toolsqa.edanat.com/");
        driver.findElement(By.className("menu-toggle")).click();
        driver.findElement(By.id("loginBtn")).click();
        driver.findElement(By.id("UserName")).sendKeys("admin@argaam.com");
        driver.findElement(By.id("pass")).sendKeys("Admin123$");
        driver.findElement(By.id("btnSubmit")).click();
        return isLoggedIn = true;
    }
    public void GetNewWindowClick(String elementId, String liElementTextByLanguageId) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(100);
        assert driver.getWindowHandles().size() == 1;
        js.executeScript("$('button.menu-toggle').click()");

        WebElement nomuLink = driver.findElement(By.linkText(liElementTextByLanguageId));
        nomuLink.click();
        WebElement link = driver.findElement(By.id(elementId));

        link.click();

        //wait.until(numberOfWindowsToBe(2));



    }
    public WebElement FindElementById(String Identifier)
    {
        WebElement element = driver.findElement(By.id(Identifier));
        return element;
    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            //driver.quit();
        }
    }
}
