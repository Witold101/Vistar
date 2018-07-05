/**
 * Интерфейс который должны соблюдать любые классы читающие список инвойсов
 */

package com.witold.vistar.contract.parsing;

import com.witold.vistar.contract.entity.Invoice;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface ReaderOfInvoices {
    List<Invoice> getListInvoices() throws ParserConfigurationException, IOException, SAXException;
}
