package org.example.Functions;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.borders.SolidBorder;
import java.util.UUID;


import org.example.Item;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileNotFoundException;
import java.util.List;

public class PDFCreator {
    String text;
    String dest = "receipt.pdf";

    public PDFCreator(String text) {
        this.text = text;
    }

    public void createPDF(List<Item> items) throws FileNotFoundException {
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);
            LocalDateTime now = LocalDateTime.now();
            document.setMargins(40, 40, 40, 40);

            Paragraph title = new Paragraph("Receipt")
                    .setFontSize(24)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            Paragraph shopInfo = new Paragraph("Shop: 'Little Lemon'")
                    .setFontSize(12)
                    .setBold()
                    .setMarginBottom(10)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(shopInfo);

            Paragraph dateTime = new Paragraph("Date: " + now.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    " | Time: " + now.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"))).setFontSize(10);
            dateTime.setTextAlignment(TextAlignment.CENTER);
            document.add(dateTime);

            String orderId = UUID.randomUUID().toString();
            document.add(new Paragraph("Order №: " + orderId).setMarginBottom(10).setTextAlignment(TextAlignment.CENTER));

            Table table = new Table(UnitValue.createPercentArray(new float[]{3, 2, 2})).useAllAvailableWidth();
            table.addHeaderCell(createHeaderCell("Item"));
            table.addHeaderCell(createHeaderCell("Price"));
            table.addHeaderCell(createHeaderCell("Currency"));

            for (Item item : items) {
                table.addCell(createBodyCell(item.getName()));
                table.addCell(createBodyCell(String.valueOf(item.getPrice())));
                table.addCell(createBodyCell(item.getCurrency()));
            }
            document.add(table);

            // Лінія розділу
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Thank you for shopping with us!")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(14)
                    .setMarginTop(20));

            String logoPath = "little-lemon-vertical-logo.png";
            ImageData imageData = ImageDataFactory.create(logoPath);
            Image logo = new Image(imageData);
            logo.setHorizontalAlignment(HorizontalAlignment.CENTER);
            logo.setWidth(50);
            logo.setMarginTop(30);
            document.add(logo);

            document.close();
            System.out.println("PDF successfully created: " + dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Cell createHeaderCell(String content) {
        return new Cell()
                .add(new Paragraph(content).setBold())
                .setBackgroundColor(new DeviceRgb(200, 200, 200))
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(new SolidBorder(1));
    }

    private Cell createBodyCell(String content) {
        return new Cell()
                .add(new Paragraph(content))
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(Border.NO_BORDER);
    }
}
