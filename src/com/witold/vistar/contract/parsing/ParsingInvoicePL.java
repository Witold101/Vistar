package com.witold.vistar.contract.parsing;

import com.witold.vistar.contract.entity.Contract;
import com.witold.vistar.contract.entity.Contractor;
import com.witold.vistar.contract.entity.Good;
import com.witold.vistar.contract.entity.Um;
import com.witold.vistar.contract.localisationClass.Languages;
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
import java.util.ArrayList;
import java.util.List;


public class ParsingInvoicePL implements GetDateForContract {
    private String fileName;
    private int language;

    public ParsingInvoicePL(String fileName, int language) {
        this.fileName = fileName;
        this.language = language;
    }

    //Return Contract from file
    public Contract getDateForContract() throws ParserConfigurationException, IOException,
            SAXException {

        Contract contract = new Contract();
        File file = new File(this.fileName);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        Node node = document.getElementsByTagName("number").item(0);
        contract.setNumber(node.getTextContent());

        node = document.getElementsByTagName("place").item(0);
        contract.setPlace(node.getTextContent());

        node = document.getElementsByTagName("sell-date").item(0);
        contract.setDate(node.getTextContent());

        node = document.getElementsByTagName("payment-type").item(0);
        contract.setPaymentType(node.getTextContent());

        node = document.getElementsByTagName("price-net").item(0);
        contract.setPriceNet(node.getTextContent());

        node = document.getElementsByTagName("currency").item(0);
        contract.setCurrency(node.getTextContent());

        //------------ seller ----------------
        Contractor seller = new Contractor();

        node = document.getElementsByTagName("seller-name").item(0);
        seller.setFullName(node.getTextContent());

        node = document.getElementsByTagName("seller-tax-no").item(0);
        seller.setVat(node.getTextContent());

        node = document.getElementsByTagName("seller-person").item(0);
        seller.setEmployee(node.getTextContent());

        node = document.getElementsByTagName("seller-bank").item(0);
        seller.setBank(node.getTextContent());

        node = document.getElementsByTagName("seller-bank-account").item(0);
        seller.setAccount(node.getTextContent());

        node = document.getElementsByTagName("seller-street").item(0);
        seller.setAddress(node.getTextContent());

        node = document.getElementsByTagName("seller-post-code").item(0);
        seller.setAddressPostCode(node.getTextContent());

        node = document.getElementsByTagName("seller-city").item(0);
        seller.setAddressesCity(node.getTextContent());

        node = document.getElementsByTagName("seller-country").item(0);
        seller.setAddressesCountry(node.getTextContent());

        contract.setSeller(seller);

        //-------------- end seller -----------------

        //------------ buyer ----------------
        Contractor buyer = new Contractor();

        node = document.getElementsByTagName("buyer-name").item(0);
        buyer.setFullName(node.getTextContent());

        node = document.getElementsByTagName("buyer-tax-no").item(0);
        buyer.setVat(node.getTextContent());

        node = document.getElementsByTagName("buyer-person").item(0);
        buyer.setEmployee(node.getTextContent());

        node = document.getElementsByTagName("buyer-bank").item(0);
        buyer.setBank(node.getTextContent());

        node = document.getElementsByTagName("buyer-bank-account").item(0);
        buyer.setAccount(node.getTextContent());

        node = document.getElementsByTagName("buyer-street").item(0);
        buyer.setAddress(node.getTextContent());

        node = document.getElementsByTagName("buyer-post-code").item(0);
        buyer.setAddressPostCode(node.getTextContent());

        node = document.getElementsByTagName("buyer-city").item(0);
        buyer.setAddressesCity(node.getTextContent());

        node = document.getElementsByTagName("buyer-country").item(0);
        buyer.setAddressesCountry(node.getTextContent());

        contract.setBuyer(buyer);
        //-------------- end buyer -----------------

        //--------------- goods--------------------
        List<Good> goods = new ArrayList<>();

        NodeList nodeList = document.getElementsByTagName("position");

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element positionElement = (Element) nodeList.item(i);
                Good good = new Good();
                good.setId(i);
                NodeList childNodes = positionElement.getChildNodes();
                for (int k = 0; k < childNodes.getLength(); k++) {
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {

                        Element child = (Element) childNodes.item(k);
                        switch (child.getNodeName()) {
                            case "name": {
                                good.setName(this.language, child.getTextContent());
                            }
                            break;
                            case "price-net": {
                                good.setCost(child.getTextContent());
                            }
                            break;
                            case "quantity": {
                                good.setValue(child.getTextContent());
                            }
                            break;
                            case "total-price-net": {
                                good.setSum(child.getTextContent());
                            }
                            break;
                            case "quantity-unit": {
                                Um um = new Um();
                                um.setFullName(Languages.LANGUAGES_PL,child.getTextContent());
                                um.setName(Languages.LANGUAGES_PL,child.getTextContent());
                                um.setCod("0");
                                good.setUm(um);
                            }
                            break;
                        }

                    }
                }
                goods.add(good);
                contract.setGoods(goods);
            }
        }
        //------------------- end goods --------------------------------------

        return contract;
    }
}
