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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MarketItem extends Page {

    private static final long serialVersionUID = -6789253497863489056L;

    private PageElement logoImg = new PageElement(this, "Logo Image", Locator.xpath("//img[@alt='My Store']"));
    private PageElement itemHeader = new PageElement(this, "Item header", Locator.xpath("//h1[@itemprop='name']"));
    private PageElement addItem = new PageElement(this, "Add quantity", Locator.xpath("//a[@class='btn btn-default button-plus product_quantity_up']"));
    private PageElement delItem = new PageElement(this,"Remove quantity",Locator.xpath("//a[@class='btn btn-default button-minus product_quantity_down']"));
    private PageElement smallSize = new PageElement(this, "Small size", Locator.xpath("//option[@title='S']"));
    private PageElement mediumSize = new PageElement(this, "Medium size", Locator.xpath("//option[@title='M']"));
    private PageElement largeSize = new PageElement(this, "Large size", Locator.xpath("//option[@title='L']"));
    private PageElement addCartBtn = new PageElement(this,"Add to cart button",Locator.xpath("//button[@name='Submit']"));
    private PageElement correctAdded = new PageElement(this, "Correct added to cart", Locator.xpath("//h2[normalize-space()='Product successfully added to your shopping cart']"));
    private PageElement proceedCheckout = new PageElement(this, "Proceed to checkout", Locator.xpath("//a[@title='Proceed to checkout']"));
    private PageElement continueShopping = new PageElement(this, "Continue shopping", Locator.xpath("//span[@title='Continue shopping']"));

    public MarketItem(io.zahori.framework.core.TestContext testContext) {
        super(testContext);
    }

    public boolean pageLoaded() {
        return logoImg.waitElementVisible() && itemHeader.waitElementVisible();
    }

    public void addItems(int n){
        for (int i = 0; i < n; i++) {
            addItem.click();
        }
    }

    public void deleteItems(int n){
        for (int i = 0; i < n; i++) {
            delItem.click();
        }
    }

    public void changeSize(String size){
        switch (size.toUpperCase()) {
            case "SMALL":
                smallSize.clickNonVisible();
                break;
            case "MEDIUM":
                mediumSize.clickNonVisible();
                break;
            case "LARGE":
                largeSize.clickNonVisible();
                break;
            default:
                break;
        }
    }

    public void clickAddCart(){
        addCartBtn.click();
    }

    public boolean checkItemAdded(){
        return correctAdded.waitElementVisible();
    }

    public void continueCheckout() {
        proceedCheckout.click();
    }

    public void continueShop(){
        continueShopping.click();
    }

}
