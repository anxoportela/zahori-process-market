package io.zahori.process;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.flows.*;
import io.zahori.process.framework.ZahoriProcess;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class MarketDemo extends ZahoriProcess {

    /*
     * Warning! Do not declare any variables here, values are overwritten when
     * several cases are executed in parallel.
     */

    @Override
    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import flows
        Login login = new Login();
        Search search = new Search();
        Item item = new Item();
        Cart cart = new Cart();

        // Getting flow type
        Map<String, String> data = caseExecution.getCas().getDataMap();
        String flow = data.get("Flow");

        // Flow execution
        switch (flow) {
            case "LOGIN":
                login.run(testContext, caseExecution);
                break;
            case "SEARCH":
                search.run(testContext, caseExecution);
                break;
            case "ITEM":
                item.run(testContext, caseExecution);
                break;
            case "CART":
                cart.run(testContext, caseExecution);
                break;
            default:
                break;

        }

    }
}
