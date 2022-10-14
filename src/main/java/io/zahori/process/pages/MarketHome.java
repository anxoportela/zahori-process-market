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

public class MarketHome extends Page {

    private static final long serialVersionUID = -27893645236578346L;

    private PageElement logoImg = new PageElement(this, "Logo Image", Locator.xpath("//img[@alt='My Store']"));
    private PageElement loginButton = new PageElement(this, "Login Button", Locator.className("login"));
    private PageElement contactButton = new PageElement(this, "Contact Button", Locator.xpath("//a[@title='Contact Us']"));
    private PageElement womenButton = new PageElement(this, "Women Button", Locator.xpath("//a[@title='Women']"));
    private PageElement dressesButton = new PageElement(this, "Dresses Button", Locator.xpath("//a[@title='Dresses']"));
    private PageElement tshirtsButton = new PageElement(this, "T-Shirts Button", Locator.xpath("//a[@title='T-shirts']"));
    private PageElement popularTab = new PageElement(this, "Popular Tab", Locator.xpath("//a[normalize-space()='Popular']"));
    private PageElement bestSellTab = new PageElement(this, "Best Sellers Tab", Locator.xpath("//a[normalize-space()='Best Sellers']"));
    private PageElement searchInput = new PageElement(this, "Search Input", Locator.id("search_query_top"));
    private PageElement searchBtn = new PageElement(this, "Search Button", Locator.name("submit_search"));

    public MarketHome(io.zahori.framework.core.TestContext testContext) {
        super(testContext);
    }

    public boolean pageLoaded() {
        return logoImg.waitElementVisible();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickContact() {
        contactButton.click();
    }

    public void clickWomenBtn() {
        womenButton.click();
    }

    public void clickDressesBtn() {
        dressesButton.click();
    }

    public void clickTshirtBtn() {
        tshirtsButton.click();
    }

    public void clickPopularTab() {
        popularTab.click();
    }

    public void clicKBestSellTab() {
        bestSellTab.click();
    }

    public void writeSearchInput(String text) {
        searchInput.write(text);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

}
