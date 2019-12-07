package by.bstu.project.file;

import by.bstu.project.entity.RoomVO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
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

            for (RoomVO roomVO : fullList) {
                Paragraph p = new Paragraph();
                p.add(formatString(roomVO));
                p.setAlignment(Element.ALIGN_LEFT);
                document.add(p);
            }

            document.close();

            System.out.println("Done");

        } catch (Exception e) {
            System.out.println("something goes wrong");
        }

    }

    private String formatString(RoomVO roomVO) {
        return "RoomId: " + roomVO.getId().toString() + "\n" +
                "Doctor FirstName: " + roomVO.getDoctorFirstName() + "\n" + "LastName " + roomVO.getDoctorLastName() + "\n" +
                "Doctor Specialization: " + roomVO.getDoctorSpecialization() + "\n" + "Doctor Age " + roomVO.getDoctorAge().toString() + "\n" +
                "Employee FirstName " + roomVO.getEmployeeFirstName() + "\n" + "Employee LastName: " + roomVO.getEmployeeLastName() + "\n" + "Employee position: " +
                roomVO.getEmployeePosition() + "\n" + "Employee age: " + roomVO.getEmployeeAge().toString() + "\n\n";
    }
}
