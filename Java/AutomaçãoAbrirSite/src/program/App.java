package program;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
    public static void main(String[] args) throws Exception {
        String senha, email;
        Robot bot = new Robot();
        WebDriver driver = (WebDriver) new FirefoxDriver();
        
        //entrar no site do senac
        driver.get("https://www.sp.senac.br/");
        
        //pegar o elemento do login e clicar
        driver.findElement(By.xpath("//*[@id=\"txtUsuarioNaoLogado\"]/div/a")).click();
        
        //colocar o email senac
        email = "";
        driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(email);
        
        
        //colocar a senha senac
        senha = "";
        driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(senha);
        
        //clicar no botao de login
        driver.findElement(By.xpath("//*[@id=\"btnLoginHeader\"]")).click();
        
        
        //criar uma pagina nova
        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.keyPress(KeyEvent.VK_T);
        bot.keyRelease(KeyEvent.VK_CONTROL);
        bot.keyRelease(KeyEvent.VK_T);
        
        
        //passar o driver para a proxima pagina
        List<String> paginas = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(paginas.get(1));
        driver.get("https://github.com/");
        
        //pegar o elemento de login e clicar
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div/a")).click();


        Thread.sleep(500);


        //colocar o email do github
        email = "";
        driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys(email);

        //colocar senha
        senha = "";
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(senha);;


        //clicar no botao de login
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]")).click();

        /*
        Thread.sleep(500);
        driver.close();
        */
    }
}