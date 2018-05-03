package com.witold.vistar.contract;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] arg) throws IOException, SAXException, ParserConfigurationException {

        Contract contract = ParsingInvoice.getContract("c:\\Users\\vi_st\\Downloads\\1\\VistarXML.xml");
        System.out.println(contract.toString());
        contract.getGoods().forEach(System.out::println);
    }
}
