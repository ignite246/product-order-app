package com.company.learning.productorderapp.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file-api/itext")
public class ItextPdfController {

    @PostMapping("/create-pdf")
    public Map<String, String> createPdfFile(@RequestParam("text") String text) throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A4);

        String uuid = String.valueOf(UUID.randomUUID());
        String pdfName = uuid + "_test.pdf";
        String folder = "D:\\Projects\\Sheeba\\ProductOrderApp\\pdfs\\";

        PdfWriter.getInstance(document, new FileOutputStream(folder + pdfName));
        document.open();

        //Preparing Title of the pdf page
        Font titleFont = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
        Paragraph title = new Paragraph("Sample Title", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        //Preparing Main Content of the pdf page
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Paragraph content = new Paragraph(text, font);
        content.setAlignment(Element.ALIGN_LEFT);

        document.add(content);
        document.close();

        final HashMap<String, String> response = new HashMap<>(2);
        response.put("filename", pdfName);
        response.put("location", folder.replaceAll("\\\\","/"));
        return response;
    }
}
