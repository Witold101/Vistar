/**
 * Интерфейс получения данных для контракта
 */

package com.witold.vistar.contract.parsing;


import com.witold.vistar.contract.entity.Contract;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface GetDateForContract {

    Contract getDateForContract() throws ParserConfigurationException, IOException, SAXException;

}
