

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * Servlet implementation class DownloadPDF
 */
@WebServlet("/PDF")
public class DownloadPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Document document = new Document(new PdfDocument(new PdfWriter(response.getOutputStream())));
		document.add(new Paragraph("Sono nel PDF"));
		document.add(new Paragraph("Sono nel PDF"));
		document.add(new Paragraph("Sono nel PDF"));
		document.add(new Paragraph("Sono nel PDF"));
		document.add(new Paragraph("Sono nel PDF"));
		document.add(new Paragraph("Sono nel PDF"));
		document.add(new Paragraph("Sono nel PDF"));
		document.close();
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=prova.pdf");
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
