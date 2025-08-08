package TestExecution;

import BrowserFactory.ChromeDriverManager;
import Pages.Formfill;
import Pages.Login;
import org.testng.annotations.Test;

public class TestCase_1 extends ChromeDriverManager {

    @Test
    public void Entervalueandcheckoutput() throws InterruptedException {
        Login login = new Login(getDriver());// pass initialized driver
        Formfill form = new Formfill(getDriver());
        login.login();
        form.fillformandsubit();
    }
}
