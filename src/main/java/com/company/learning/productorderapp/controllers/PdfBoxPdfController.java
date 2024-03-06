package com.company.learning.productorderapp.controllers;

import com.itextpdf.text.DocumentException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file-api/pdfbox")
public class PdfBoxPdfController {

    @PostMapping("/create-pdf")
    public String createPdfFile(@RequestParam("text") String text) throws IOException, DocumentException {
        String uuid = String.valueOf(UUID.randomUUID());
        String pdfName = uuid + "_test.pdf";

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.valueOf("COURIER")),12);
        contentStream.beginText();
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();

        document.save(pdfName);
        document.close();

        return "pdf created with name :: " + pdfName;
    }
}
