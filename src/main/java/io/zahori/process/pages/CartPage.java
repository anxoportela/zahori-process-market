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

public class CartPage extends Page {

    private static final long serialVersionUID = -345345465237865L;

    private PageElement headerText = new PageElement(this, "Cart Header", Locator.xpath("//span[@class='title']"));
    private List<WebElement> itemRemoveBtns = this.getDriver().findElements(By.xpath("//button[contains(@class,'cart_button')]"));
    private PageElement checkoutBtn = new PageElement(this, "Checkout button", Locator.xpath("//button[@id='checkout']"));

    public CartPage(TestContext testContext) {
        super(testContext);
    }

    public boolean checkHeader() {
        return headerText.isVisible();
    }

    public void removeItems(){
        for(WebElement e : itemRemoveBtns){
            e.click();
        }
    }

    public void clickCheckout(){
        checkoutBtn.click();
    }


}