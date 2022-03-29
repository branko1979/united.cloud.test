package pages;

import base.BasePage;
import utils.Locators;
import utils.Strings;

public class LoginPage extends BasePage {
    public ChooseProfile loginToPage(String username, String password){
        typeText(Locators.USERNAME_FLD, username);
        typeText(Locators.PASSWORD_FLD,password);
        click(Locators.SUBMIT_BTN);
        return new ChooseProfile();
    }
}
