package com.witold.vistar.contract;

import com.witold.vistar.contract.parsing.ParsingListInvoiceRU;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] arg) throws IOException, SAXException, ParserConfigurationException {


        ParsingListInvoiceRU invoiceRU = new ParsingListInvoiceRU("c:/Users/vi_st/Downloads/1/parsingRu.xml");
        invoiceRU.getListInvoices();
        System.out.println("99");

    }
}
