package io.zahori.process.pages;

/*-
 * #%L
 * zahori-process
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2021 PANEL SISTEMAS INFORMATICOS,S.L
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import io.zahori.framework.core.Locator;
import io.zahori.framework.core.Page;
import io.zahori.framework.core.PageElement;
import io.zahori.framework.core.TestContext;

public class HomePage extends Page {

    private PageElement logoImg = new PageElement(this, "Logo Image", Locator.xpath("//div[@class='bot_column']"));
    private PageElement inputUsername = new PageElement(this, "Input username", Locator.css("#user-name"));
    private PageElement inputPassword = new PageElement(this, "Input password", Locator.xpath("//input[@name='password']"));
    private PageElement loginButton = new PageElement(this, "Login Button", Locator.id("login-button"));
    private PageElement errorLoginBox = new PageElement(this, "Login error box", Locator.xpath("//h3[@data-test='error']"));

    public HomePage(TestContext testContext) {
        super(testContext);
    }

    public boolean pageLoaded() {
        return logoImg.waitElementVisible();
    }

    public void fillUsername(String username){
        inputUsername.write(username);
    }

    public void fillPassword(String password){
        inputPassword.write(password);
    }

    public void clickLoginBtn(){
        loginButton.click();
    }

    public void doLogin(String username, String password, String userType){
        fillUsername(username);
        fillPassword(password);
        clickLoginBtn ();

        if (userType.equals("banned")){
            isBanned();
        } else if (userType.equals("invalid")) {
            notRegUser();
        }
    }

    public boolean isBanned(){
        return errorLoginBox.getText().contains("Sorry, this user has been locked out");
    }

    public boolean notRegUser(){
        return errorLoginBox.getText().contains("Username and password do not match any user in this service");
    }


}
