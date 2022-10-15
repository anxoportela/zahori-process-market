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


    public MarketCart(io.zahori.framework.core.TestContext testContext) {
        super(testContext);
    }

    public boolean pageLoaded() {
        return logoImg.waitElementVisible() && cartHeader.waitElementVisible();
    }



}
