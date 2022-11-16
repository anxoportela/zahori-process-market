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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ItemsPage extends Page {

    private static final long serialVersionUID = -6789253497863489056L;

    private PageElement headerText = new PageElement(this, "Products Header", Locator.xpath("//span[@class='title']"));
    private List<WebElement> itemBtns = this.getDriver().findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
    private PageElement cartBtn = new PageElement(this, "Cart Button", Locator.xpath("//a[@class='shopping_cart_link']"));
    private PageElement cartQnty = new PageElement(this, "Cart quantity", Locator.xpath("//span[@class='shopping_cart_badge']"));

    public ItemsPage(TestContext testContext) {
        super(testContext);
    }

    public boolean checkHeader() {
        return headerText.isVisible();
    }

    public void selectRandomBtn() {
        Random rnd = new Random();
        WebElement rndElement = itemBtns.get(rnd.nextInt(itemBtns.size()));
        rndElement.click();
    }

    public boolean checkCartItems(){
        return cartQnty.getText().equals("1");
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

}
