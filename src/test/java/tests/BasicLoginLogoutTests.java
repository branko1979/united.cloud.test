package tests;

import base.WebDriverTest;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import utils.Strings;

public class BasicLoginLogoutTests extends WebDriverTest {
    @Before
    public void goToStartPage() {openPage("https://qa-interview.united.cloud/");}
    @Test
    public void t001TryToLoginWithWrongUsername(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.WRONG_USERNAME,Strings.PASSWORD)
                .newProfile();
    }

    @Test
    public void t002TryToLoginWithWrongPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.USERNAME,Strings.WRONG_PASSWORD)
                .newProfile();
    }

    @Test
    public void t003LoginAndLogout(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.USERNAME,Strings.PASSWORD)
                .selectProfile(Strings.PROFILE_NAME_FAMILY)
                .logout();
    }

}
