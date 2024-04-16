package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EditDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String janCode=request.getParameter("janCode");
		String isbnCode=request.getParameter("isbnCode");
		String bookName=request.getParameter("bookName");
		String bookKanaName=request.getParameter("bookKanaName");
		String price=request.getParameter("price");
		String issueDate=request.getParameter("issueDate");
		String createDateTime=request.getParameter("createDateTime");
		
		if(request.getAttribute("message")==null) {
			request.setAttribute("message", "No error");
		}
		try {
			EditDAO dao =new EditDAO();
			dao.update(janCode,bookName,bookKanaName,Integer.parseInt(price),issueDate);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			request.setAttribute("message", "例外発生");
		}
		
		response.sendRedirect("Home");
	}

}
