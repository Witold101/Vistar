/**
 * Класс парсит данные в XML о списке invoices из 1С.
 */
package com.witold.vistar.contract.parsing;

import com.witold.vistar.contract.db.GoodDB;
import com.witold.vistar.contract.db.UmDB;
import com.witold.vistar.contract.entity.Good;
import com.witold.vistar.contract.entity.Invoice;
import com.witold.vistar.contract.entity.Um;
import com.witold.vistar.contract.localisationClass.Languages;
import com.witold.vistar.contract.localisationClass.LocalText;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParsingListInvoiceRU implements ReaderOfInvoices {

    private String fileName;

    public ParsingListInvoiceRU(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Invoice> getListInvoices() throws ParserConfigurationException, IOException, SAXException {

        UmDB umDB = UmDB.getInstance();
        GoodDB goodDB = GoodDB.getInstance();

        File file = new File(this.fileName);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        NodeList nodes;
        Node node;
        NodeList nodeChildList;
        String code = "";
        LocalText name = null;
        LocalText fullName = null;

//-------------------------------- Заполняем единицы измерения --------------------------------------
        nodes = document.getElementsByTagName("CatalogObject.КлассификаторЕдиницИзмерения");
        for (int i = 0; i < nodes.getLength(); i++) {
            node = nodes.item(i);
            nodeChildList = node.getChildNodes();
            for (int j = 0; j < nodeChildList.getLength(); j++) {
                if (nodeChildList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeChildList.item(j);
                    switch (element.getTagName()) {
                        case "Ref": {
                            code = element.getTextContent();
                        }
                        break;
                        case "Description": {
                            name = new LocalText();
                            name.setLocal(Languages.LANGUAGES_RU, element.getTextContent());
                        }
                        break;
                        case "НаименованиеПолное": {
                            fullName = new LocalText();
                            fullName.setLocal(Languages.LANGUAGES_RU, element.getTextContent());
                        }
                        break;
                    }
                }
            }
            Um um = new Um(name,fullName,code);
            if (!umDB.isElement(um)){
                umDB.add(um);
            }
        }
//--------------------------------------------------------------------------------------

//---------------------- Заполняем номенклатуру ----------------------------------------
        nodes = document.getElementsByTagName("CatalogObject.Номенклатура");
        Um um = null;
        for (int i = 0; i < nodes.getLength(); i++) {
            node = nodes.item(i);
            nodeChildList = node.getChildNodes();
            for (int j = 0; j < nodeChildList.getLength(); j++) {
                if (nodeChildList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeChildList.item(j);
                    switch (element.getTagName()) {
                        case "Ref": {
                            code = element.getTextContent();
                        }
                        break;
                        case "Description": {
                            name = new LocalText();
                            name.setLocal(Languages.LANGUAGES_RU, element.getTextContent());
                        }
                        break;
                        case "НаименованиеПолное": {
                            fullName = new LocalText();
                            fullName.setLocal(Languages.LANGUAGES_RU, element.getTextContent());
                        }
                        break;
                        case "ЕдиницаИзмерения": {
                            um = umDB.getElementFromCod(element.getTextContent());
                        }
                        break;
                    }
                }
            }
            Good good = new Good(name,fullName,um,"0","0","0","0",code);
            if (!goodDB.isElement(good)){
                goodDB.add(good);
            }
        }
        return null;
    }
}
