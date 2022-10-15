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
import org.openqa.selenium.Keys;

public class MarketCart extends Page {

    private static final long serialVersionUID = -345345465237865L;

    private PageElement logoImg = new PageElement(this, "Logo Image", Locator.xpath("//img[@alt='My Store']"));
    private PageElement cartHeader = new PageElement(this, "Login Header", Locator.xpath("//h1[@id='cart_title']"));
    private PageElement decreaseQuantity = new PageElement(this, "Decrease item quantity", Locator.xpath("//i[@class='icon-minus']"));
    private PageElement increaseQuantity = new PageElement(this, "Increase item quantity", Locator.xpath("//i[@class='icon-plus']"));
    private PageElement writeQuantity = new PageElement(this, "Input item quantity", Locator.xpath("//input[contains(@class,'cart_quantity_input')]"));
    private PageElement deleteItem = new PageElement(this, "Delete item from cart", Locator.xpath("//i[@class='icon-trash']"));
    private PageElement continueCheckout = new PageElement(this, "Continue with checkout", Locator.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
    private PageElement continueShopping = new PageElement(this, "Continue shopping", Locator.xpath("//a[normalize-space()='Continue shopping']"));

    public MarketCart(io.zahori.framework.core.TestContext testContext) {
        super(testContext);
    }

    public boolean pageLoaded() {
        return logoImg.waitElementVisible() && cartHeader.waitElementVisible();
    }

    public void rmQuantity(int n){
        for (int i = 0; i < n; i++) {
            decreaseQuantity.click();
        }
    }

    public void addQuantity(int n){
        for (int i = 0; i < n; i++) {
            increaseQuantity.click();
        }
    }

    public void inputQuantity(int n){
        writeQuantity.write(Integer.toString(n));
    }

    public void rmItem(){
        deleteItem.click();
    }

    public void clickCheckout(){
        continueCheckout.click();
    }

    public void clickReturnShop(){
        continueShopping.click();
    }



}
