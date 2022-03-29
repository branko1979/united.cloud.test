package pages;

import base.BasePage;
import utils.Locators;

public class ChooseProfile extends BasePage {
    /**
     * open new page for creating new profile
     * @return page CreateProfile
     */
    public CreateProfile newProfile (){
        click(Locators.NEW_PROFILE_BTN);
        return new CreateProfile();
    }

    public ProfilePage selectProfile(String text){
        click(Locators.PROFILE(text));
        return new ProfilePage();
    }

    public ProfilePage selectSecondProfile(){
        click(Locators.SECOND_PROFILE);
        return new ProfilePage();
    }

    public boolean existsAnotherProfile(){
        return checkVisible(Locators.SECOND_PROFILE);
    }
}
