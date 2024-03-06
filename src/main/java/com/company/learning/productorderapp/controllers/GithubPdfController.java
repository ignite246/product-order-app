package com.company.learning.productorderapp.controllers;

import com.itextpdf.text.DocumentException;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file-api/github-pdf")
public class GithubPdfController {

    @GetMapping("/create-pdf")
    public String createPdfFile(@RequestParam("text") String text, HttpServletResponse response) throws IOException, DocumentException {
        final Document document = new Document();
        String uuid = String.valueOf(UUID.randomUUID());
        String pdfName = uuid + "_test.pdf";

        //final ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 24);
        final Paragraph titlePara = new Paragraph("Sample Title", titleFont);
        titlePara.setAlignment(Element.ALIGN_CENTER);
        document.add(titlePara);

        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 20);

        final Paragraph contentPara = new Paragraph(text, contentFont);
        titlePara.setAlignment(Element.ALIGN_LEFT);
        document.add(contentPara);

        document.close();

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+pdfName+";";
        response.setHeader(headerKey, headerValue);

        return "pdf created with name :: " + pdfName;
    }
}
