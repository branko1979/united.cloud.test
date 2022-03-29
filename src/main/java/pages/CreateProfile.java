package pages;

import base.BasePage;
import utils.Locators;


public class CreateProfile extends BasePage {
    /**
     * Type profile name in profile name field
     */
    public CreateProfile enterProfileName(String name){
        typeText(Locators.PROFILE_NAME,name);
        return this;
    }

    /**
     * Select Age from the list
     * @param text - different ages that can be selected
     * @return same page
     */
    public CreateProfile selectAge(String text){
        click(Locators.AGE(text));
        return this;
    }

    /**
     * enter years of users in profile
     * @param text - years of users
     * @return
     */
    public CreateProfile enterAgeProfUser(String text){
        typeText(Locators.BIRTH_YEAR_FLD,text);
        return this;
    }

    /**
     * Select icon with midle age guy on it
     * @return same page
     */
    public CreateProfile selectMidleAgeAvatar(){
        click(Locators.MIDDLE_AGED_GUY_ICON);
        return this;
    }

    public CreateProfile selectSpaceKidAvatar(){
        click(Locators.SPACE_KID_ICON);
        return this;
    }

    public ProfilePage submit(){
        click(Locators.SUBMIT_BTN_CREATE_P);
        return new ProfilePage();
    }

    public CreateProfile submitAndVerifyMaximumAcounts(){
        click(Locators.SUBMIT_BTN_CREATE_P);
        waitForVisible(Locators.MAXIMUM_NUMBER_PROFILE,10);
        return this;
    }

    public ProfilePage backToProfilePage(){
        click(Locators.HOME_BTN);
        return new ProfilePage();
    }

}
