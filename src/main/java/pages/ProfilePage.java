package pages;

import base.BasePage;
import utils.Locators;

public class ProfilePage extends BasePage {
    /**
     * delete profile and go to home page
     * @return
     */
    public ChooseProfile deleteProfile(){
        click(Locators.DELETE_PROFILE_BTN);
        return new ChooseProfile();
    }

    public LoginPage logout(){
        click(Locators.LOGOUT_PROFILE_BTN);
        return new LoginPage();
    }

    public CreateProfile createAnotherProfile(){
        click(Locators.CREATE_PROFILE_BTN_PROFILE_P);
        return new CreateProfile();
    }

    public ChooseProfile chooseProfile(){
        click(Locators.CHOOSE_PROFILE_BTN_PROFILE_P);
        return new ChooseProfile();
    }
}
