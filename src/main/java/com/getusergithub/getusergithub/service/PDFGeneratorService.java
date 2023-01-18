package com.getusergithub.getusergithub.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.getusergithub.getusergithub.models.User;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response, User[] user) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph judul = new Paragraph("List USer Github", fontTitle);
        judul.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(judul);

        Font fontparagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontTitle.setSize(12);

        for(int i=0; i<user.length; i++){
            String space = "";
            if(i<9){
                space = "\t\t\t";
            }
            else{
                space = "\t";
            }
            String login = i+1+"."+space+"Login: "+user[i].getLogin();
            Paragraph textLogin = new Paragraph(login, fontparagraph);
            textLogin.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(textLogin);
            String id = "\t\t\t\t\t\tID: "+user[i].getId();
            Paragraph textID = new Paragraph(id, fontparagraph);
            textLogin.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(textID);
        }
        document.close();
    }
}
