package by.bstu.project.file;

import by.bstu.project.entity.RoomVO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class PdfWrite {
    public void write(String fileName, List<RoomVO> fullList) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(fileName + ".pdf")));

            document.open();
            Paragraph p = new Paragraph();

            for (RoomVO roomVO : fullList) {
                p.add(roomVO.toString()+"\n");
                p.setAlignment(Element.ALIGN_LEFT);
                document.add(p);
            }

            document.close();

            System.out.println("Done");

        } catch (Exception e) {
            System.out.println("something goes wrong");
        }

    }
}
