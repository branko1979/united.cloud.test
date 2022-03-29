package tests;

import base.WebDriverTest;
import org.junit.Before;
import org.junit.Test;
import pages.ChooseProfile;
import pages.LoginPage;
import utils.Strings;

public class LoginCreateDeleteLogoutTest extends WebDriverTest {
    @Before
    public void goToStartPage() {openPage("https://qa-interview.united.cloud/");}
    @Test
    public void t001LoginCreateDeleteLogoutTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.USERNAME,Strings.PASSWORD)
                .newProfile()
                .enterProfileName(Strings.PROFILE_NAME)
                .selectAge(Strings.PROFILE_AGE)
                .enterAgeProfUser(Strings.PROFILE_YEARS)
                .selectMidleAgeAvatar()
                .submit()
                .deleteProfile()
                .selectProfile(Strings.PROFILE_NAME_FAMILY)
                .logout();

    }

    @Test
    public void t002CreateMultipleAcountsAndDeleteALL(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.USERNAME,Strings.PASSWORD)
                .newProfile()
                .enterProfileName(Strings.PROFILE_NAME)
                .selectAge(Strings.PROFILE_AGE)
                .enterAgeProfUser(Strings.PROFILE_YEARS)
                .selectMidleAgeAvatar()
                .submit()
                .createAnotherProfile()
                .enterProfileName(Strings.PROFILE_NAME2)
                .selectAge(Strings.PROFILE_AGE2)
                .selectSpaceKidAvatar()
                .submit()
                .chooseProfile()
                .selectProfile(Strings.PROFILE_NAME2)
                .deleteProfile()
                .selectProfile(Strings.PROFILE_NAME)
                .deleteProfile()
                .selectProfile(Strings.PROFILE_NAME_FAMILY)
                .logout()
        ;

    }


    @Test
    public void t003CreateAcountWithAbsurdYearsOfBirth () {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.USERNAME, Strings.PASSWORD)
                .newProfile()
                .enterProfileName(Strings.PROFILE_NAME)
                .selectAge(Strings.PROFILE_AGE)
                .enterAgeProfUser(Strings.PROFILE_YEARS3)
                .selectMidleAgeAvatar()
                .submit()
                .deleteProfile()
                .selectProfile(Strings.PROFILE_NAME_FAMILY)
                .logout();

        }

    @Test
    public void t004Make5sameAconuntsAndTryNewOne () {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.USERNAME, Strings.PASSWORD)
                .newProfile()
                .enterProfileName(Strings.PROFILE_NAME2)
                .selectAge(Strings.PROFILE_AGE2)
                .selectSpaceKidAvatar()
                .submit()
                .createAnotherProfile()
                .enterProfileName(Strings.PROFILE_NAME2)
                .selectAge(Strings.PROFILE_AGE2)
                .selectSpaceKidAvatar()
                .submit()
                .createAnotherProfile()
                .enterProfileName(Strings.PROFILE_NAME2)
                .selectAge(Strings.PROFILE_AGE2)
                .selectSpaceKidAvatar()
                .submit()
                .createAnotherProfile()
                .enterProfileName(Strings.PROFILE_NAME2)
                .selectAge(Strings.PROFILE_AGE2)
                .selectSpaceKidAvatar()
                .submit()
                .createAnotherProfile()
                .enterProfileName(Strings.PROFILE_NAME2)
                .selectAge(Strings.PROFILE_AGE2)
                .selectSpaceKidAvatar()
                .submit()
                .createAnotherProfile()
                .enterProfileName(Strings.PROFILE_NAME2)
                .selectAge(Strings.PROFILE_AGE2)
                .selectSpaceKidAvatar()
                .submitAndVerifyMaximumAcounts()
                .backToProfilePage()
                .logout();
        ;

    }
    @Test
    public void t005DeleteAllProfiles () {
        LoginPage loginPage = new LoginPage();
        ChooseProfile chooseProfile= loginPage.loginToPage(Strings.USERNAME, Strings.PASSWORD);
        while (chooseProfile.existsAnotherProfile()){
            chooseProfile.selectSecondProfile()
                         .deleteProfile() ;
        }
        chooseProfile.selectProfile(Strings.PROFILE_NAME_FAMILY)
                .logout();
    }

    @Test
    public void t006HugeNumberOfYearsAndWRONGMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPage(Strings.USERNAME, Strings.PASSWORD)
                .newProfile()
                .enterProfileName(Strings.PROFILE_NAME)
                .selectAge(Strings.PROFILE_AGE)
                .enterAgeProfUser(Strings.PROFILE_YEARS_HUGE)
                .selectMidleAgeAvatar()
                .submitAndVerifyMaximumAcounts();
    }

}
