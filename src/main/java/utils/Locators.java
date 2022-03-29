package utils;

public class Locators {
    public static final String USERNAME_FLD="//input[@id='username']";
    public static final String PASSWORD_FLD="//input[@id='password']";
    public static final String SUBMIT_BTN="//button[@type='submit']";
    public static final String NEW_PROFILE_BTN="//button[text()='Create new profile']";
    public static final String PROFILE_NAME="//input[@name='name']";
    public static final String AGE(String text){
       return String.format ("//label[text()='%s']",text);
    }
    public static final String BIRTH_YEAR_FLD="//input[@name='year']";
    public static final String MIDDLE_AGED_GUY_ICON="//label[@for='9']";
    public static final String SPACE_KID_ICON="//label[@for='2']";
    public static final String HOME_BTN="//button[@class='header__button button button--primary button--small router-link-active']";
    public static final String SUBMIT_BTN_CREATE_P="//button[@type='submit']";
    public static final String DELETE_PROFILE_BTN="//button[@class='card__delete button button--delete button--small']";
    public static final String LOGOUT_PROFILE_BTN="//div[@class='card']//button[@class='button button--primary button--small']";
    public static final String CREATE_PROFILE_BTN_PROFILE_P="//header//button[@class='button button--primary button--small' and text()='Create profile']";
    public static final String CHOOSE_PROFILE_BTN_PROFILE_P="//header//button[@class='button button--primary button--small' and text()='Choose profile']";
    public static final String PROFILE(String text){
        return String.format("//div[@class='profiles__profile-inner']//span[text()='%s']",text);
    }
    public static final String SECOND_PROFILE="(//div[@class='profiles__profile-inner'])[2]";
    public static final String MAXIMUM_NUMBER_PROFILE="//span[@class='form__error' and text()='Maximum number of profiles reached for this user.']";
}
