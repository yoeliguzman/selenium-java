package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    public static WebDriver driver;

    // Método para inicializar el driver
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\131.0.6778.87\\chromedriver.exe"); // Configura la ruta de tu chromedriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    // Método para cerrar el driver
    public static void cerrarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
