package org.example.Functions;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.example.Item;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileNotFoundException;
import java.util.List;

public class PDFCreator {
    String text;
    String dest = "receipt.pdf";
    public PDFCreator(String text) throws FileNotFoundException {
        this.text = text;
    }

    public void createPDF(List<Item> Items) throws FileNotFoundException {
        try {
            LocalDateTime now = LocalDateTime.now();
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph(text));
            document.add(new Paragraph("Shop: 'Little Lemon'"));
            document.add(new Paragraph("Date: " + now.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            document.add(new Paragraph("Time: " + now.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"))));
            document.add(new Paragraph("Order №: 1287936"));
            for (Item item : Items) {
                document.add(new Paragraph((item.getName() + " - " + item.getPrice() + item.getCurrency())));
            }
            document.close();
            System.out.println("PDF successfully created: " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
