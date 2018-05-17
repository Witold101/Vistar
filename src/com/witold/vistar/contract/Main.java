package com.witold.vistar.contract;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] arg) throws IOException, SAXException, ParserConfigurationException, DocumentException {

        //Contract contract = ParsingInvoice.getContract("c:\\Users\\vi_st\\Downloads\\1\\VistarXML.xml");
        //System.out.println(contract.toString());
        //contract.getGoods().forEach(System.out::println);

        Document document = new Document(PageSize.A4,50,50,50,50);
        PdfWriter writer = PdfWriter.getInstance (document, new FileOutputStream("C:\\ITextTest.pdf"));
        final BaseFont bf = BaseFont.createFont("c:\\Windows\\Fonts\\tahoma.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(bf);

        document.open();
        Anchor anchorTarget = new Anchor("First page of the document.");
        anchorTarget.setName("BackToTop");
        Paragraph paragraph1 = new Paragraph();

        paragraph1.setSpacingBefore(50);

        paragraph1.add(anchorTarget);
        document.add(paragraph1);



        document.add(new Paragraph("Привет ОЛЬКА.",font));
        document.close();
    }
}
