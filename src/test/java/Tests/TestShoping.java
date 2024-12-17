package Tests;

import Driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static Driver.DriverManager.driver;

public class TestShoping {

    public static void main(String[] args) {

        WebDriver driver = DriverManager.getDriver();

        String user_login = "standard_user";
        String user_password = "secret_sauce";
        String nombre = "Yoeli";
        String apellido = "Guzman";
        String codigo_postal = "CP 1101";


        try {
            // Navegar a la URL del formulario
            driver.get("https://www.saucedemo.com/");

            // Inicio de sesion
            driver.findElement(By.id("user-name")).sendKeys(user_login); // Nombre
            driver.findElement(By.id("password")).sendKeys(user_password); // Apellido
            driver.findElement(By.id("login-button")).click(); // Correo electrónico

            //Agregar item al carrito
            driver.findElement(By.linkText("Sauce Labs Backpack")).click();
            driver.findElement(By.name("add-to-cart")).click();

            //Ir atras
            driver.findElement(By.id("back-to-products")).click();

            //Ir al carrito
            driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
            driver.findElement(By.id("checkout")).click();

            //Datos de pago
            driver.findElement(By.name("firstName")).sendKeys(nombre);
            driver.findElement(By.name("lastName")).sendKeys(apellido);
            driver.findElement(By.name("postalCode")).sendKeys(codigo_postal);

            //Continuar
            driver.findElement(By.cssSelector("[data-test='continue']")).click();


            //Logear el total de la compra
            WebElement totalCompra = driver.findElement(By.cssSelector("[data-test='total-label']"));
            System.out.println("El valor de la compra es: " + totalCompra);

            //Terminar compra
            driver.findElement(By.name("finish")).click();

            //Validar titulo del resultado
            WebElement tituloCompra = driver.findElement(By.cssSelector(".complete-header"));  // Asegúrate de que el selector sea correcto
            if (tituloCompra.getText().equals("Thank you for your order!")) {
                System.out.println("Compra exitosa");
            } else {
                System.out.println("Algo falló, revisarlo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("La prueba ha finalizado exitosamente");
            // Cerrar el WebDriver al final
            DriverManager.cerrarDriver();
        }
    }
}