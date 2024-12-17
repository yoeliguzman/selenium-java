package Tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestAlerts {

    public static void main(String[] args) {
        // Configuración del WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe"); // Reemplaza con la ruta a tu chromedriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navegar a la página de ejemplo
            driver.get("https://demoqa.com/alerts");

            // Maximizar la ventana del navegador
            driver.manage().window().maximize();

            // Manejar la alerta (Alert)
            driver.findElement(By.id("alertButton")).click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alerta: " + alert.getText());
            alert.accept(); // Aceptar la alerta

            // Manejar la confirmación (Confirm)
            driver.findElement(By.id("confirmButton")).click();
            Alert confirm = driver.switchTo().alert();
            System.out.println("Confirmación: " + confirm.getText());
            confirm.accept(); // Aceptar la confirmación (también puedes usar confirm.dismiss() para cancelar)

            // Manejar el prompt (Prompt)
            driver.findElement(By.id("promtButton")).click();
            Alert prompt = driver.switchTo().alert();
            System.out.println("Prompt: " + prompt.getText());
            prompt.sendKeys("Yoeli Ismael Guzman"); // Introducir texto en el prompt
            prompt.accept(); // Aceptar el prompt

            // Esperar un poco para visualizar el resultado
            Thread.sleep(2000);

            // (Opcional) Captura de pantalla
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", ""); // Scroll para ver el resultado si es necesario
            // No hay una captura de pantalla directa en Selenium como en Playwright, pero puedes usar bibliotecas como AShot o herramientas del sistema.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}
