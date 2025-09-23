package com.learncicd;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_LoginTest extends BaseClass {

    @Test(priority = 1, description = "Login with valid credentials")
    public void loginTest()
    {
        pageFactory.getLoginPage().loginWithCredentials("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}
