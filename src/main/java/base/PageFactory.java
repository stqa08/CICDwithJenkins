package base;

import Pages.LoginPage;

public class PageFactory {

    private LoginPage loginPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

}