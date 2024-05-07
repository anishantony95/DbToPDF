
package com.example.demo;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfService {
    public static ByteArrayInputStream employeePdfReport(List<PdfEntity> employees) {
        Document document=new Document();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font fontHeader=FontFactory.getFont(FontFactory.TIMES_BOLD,22);
            Paragraph para=new Paragraph("Employee Structure",fontHeader);
            para.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table=new PdfPTable(4); // Change to 4 columns since you have 4 properties

            Stream.of("ID","Name","Dept","PhoneNumber").forEach(headerTitle -> {
                PdfPCell header=new PdfPCell();
                Font headFont=FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.CYAN);
                header.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle,headFont));
                table.addCell(header);
            });
            for(PdfEntity employee: employees) {
                table.addCell(String.valueOf(employee.getId())); // ID
                table.addCell(employee.getName()); // Name
                table.addCell(employee.getDept()); // Department
                table.addCell(employee.getPhoneNumber()); // Phone Number
            }
            document.add(table);
            document.close();

        }
        catch(DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
