package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.Utils;
import java.time.Duration;

public class LoginPage {

    Duration tempo = Duration.ofSeconds(5);
    String userName = "Qa Test";

    String loginButton = "//a[@class='login']";
    String emailInput = "//input[@id='email']";
    String passwdInput = "//input[@id='passwd']";
    String submitLoginButton = "//button[@id='SubmitLogin']";

    public void fazerLogin() {
        Utils.initDriver().get("http://www.automationpractice.pl/index.php");
        Utils.esperarElemento(tempo, By.xpath(loginButton));
        Utils.clickButton(loginButton);
        Utils.esperarElemento(tempo, By.xpath(emailInput));
        Utils.validarTitulo("Login - My Shop");
        Utils.sendKeys(emailInput, "automatedTest@qa.com");
        Utils.sendKeys(passwdInput, "12345");
        Utils.clickButton(submitLoginButton);

        assertUserNameInLoginButton();
    }

    public void assertUserNameInLoginButton(){
        String userNameLoginButton = Utils.getElement(By.xpath("//a[@class='account']/span")).getText();
        Assert.assertEquals(userName, userNameLoginButton);
    }

}
