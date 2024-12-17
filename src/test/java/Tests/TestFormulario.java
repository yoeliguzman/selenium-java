package Tests;

// Investigar sobre screen play - Julian mesa automation

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import Driver.DriverManager; // Importar la clase de WebDriver

public class TestFormulario {

    public static void main(String[] args) {
        // Obtener el WebDriver desde DriverManager
        WebDriver driver = DriverManager.getDriver();

        // Definir los datos a ingresar
        String nombre = "Yoeli Ismael";
        String apellido = "Guzman Chavez";
        String correo = "yoeli@ejemplo.com";
        String telefono = "5037788445";
        String nacimiento = "25 Aug 1988";
        String asunto = "Computer";

        try {
            // Navegar a la URL del formulario
            driver.get("https://demoqa.com/automation-practice-form");

            // Rellenar los campos del formulario
            driver.findElement(By.id("firstName")).sendKeys(nombre); // Nombre
            driver.findElement(By.id("lastName")).sendKeys(apellido); // Apellido
            driver.findElement(By.id("userEmail")).sendKeys(correo); // Correo electrónico
            driver.findElement(By.id("userNumber")).sendKeys(telefono); // Teléfono

            // Seleccionar la fecha de nacimiento
            WebElement dateInput = driver.findElement(By.id("dateOfBirthInput"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateInput);
            dateInput.click();

            // Seleccionar asignatura "Computer Science"
            WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
            subjectsInput.sendKeys(asunto);
            driver.findElement(By.xpath("//div[text()='Computer Science']")).click();

            // Selección de hobbies
            WebElement hobbiesCheckbox = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbiesCheckbox);
            hobbiesCheckbox.click();

            // Subir una imagen
            WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
            uploadElement.sendKeys(new File("prueba.jpg").getAbsolutePath()); // Subir la imagen

            // Ingresar la dirección
            driver.findElement(By.id("currentAddress")).sendKeys("Prueba");

            // Seleccionar género (Masculino)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateInput);
            driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();

            // Seleccionar estado "Haryana"
            WebElement stateDropdown = driver.findElement(By.id("state"));
            Actions actions = new Actions(driver);
            actions.moveToElement(stateDropdown).click().perform();
            driver.findElement(By.xpath("//div[text()='Haryana']")).click();

            // Seleccionar ciudad "Rajasthan"
            WebElement cityDropdown = driver.findElement(By.id("city"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityDropdown);
            actions.moveToElement(cityDropdown).click().perform();
            driver.findElement(By.xpath("//div[text()='Karnal']")).click();

            // Enviar el formulario
            driver.findElement(By.id("submit")).click();

            // Desplazarse hacia abajo (si es necesario)
            actions.moveToElement(driver.findElement(By.id("submit"))).click().perform();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("La prueba ha finalizado exitosamente");

            // Cerrar el WebDriver al final
            DriverManager.cerrarDriver();
        }
    }
}
