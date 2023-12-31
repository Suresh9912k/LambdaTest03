package LambdaTest04;

        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.Platform;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.HashMap;

public class LambdaTest05{
    public String username = "suresh9912k";
    public String accesskey = "DLreM2sKB4eGFV6G6tLSO636NM4TkmWdxwwen7HeJxyZjUIi44";

    private static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;


    @BeforeClass
    public void setUp() throws Exception {
        /*
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "116.0");
        capabilities.setCapability("platform", "Windows 10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "MyBuild06");
        capabilities.setCapability("project", "Project06");
        capabilities.setCapability("name", "Project06");
        capabilities.setCapability("smartUI.project", "MyProject06");

        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("console", true);
        capabilities.setCapability("tunnel", true);
        capabilities.setCapability("w3c", true);
        capabilities.setCapability("plugin", "java-testNG");
         */

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("116.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "suresh9912k");
        ltOptions.put("accessKey", "DLreM2sKB4eGFV6G6tLSO636NM4TkmWdxwwen7HeJxyZjUIi44");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("build", "MyBuild06");
        ltOptions.put("project", "Project06");
        ltOptions.put("smartUI.project", "MyProject06");
        ltOptions.put("name", "Test06");
        ltOptions.put("tunnel", true);
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);


//     //   System.out.println("Desired Caps: " + capabilities);
//        try {
//            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
//        } catch (MalformedURLException e) {
//            System.out.println("Invalid grid URL");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
    @Test
    public void testSimple() throws Exception {
        try {//Change it to production page
            driver.get("https://lambdatest.github.io/sample-todo-app/");
            //Let's mark done first two items in the list.
            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();
            // Let's add an item in the list.
            driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();
            // Let's check that the item we added is added in the list.
            String enteredText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
            if (enteredText.equals("Yey, Let's add it to list")) {
                status = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}