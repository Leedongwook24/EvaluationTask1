package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ListDAO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     if(request.getAttribute("message")==null) {
				request.setAttribute("message", "No error");
			}
			try {
				ListDAO dao =new ListDAO();
				request.setAttribute("rows", dao.select());
			}catch(SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				request.setAttribute("message", "例外発生");
			}
			
		response.setContentType("text/html; charset=UTF-8");
		String view="WEB-INF/views/home.jsp";		
		RequestDispatcher dispatcher= request.getRequestDispatcher(view);
 	   	dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String janCode=request.getParameter("janCode");
		String isbnCode=request.getParameter("isbnCode");
		String bookName=request.getParameter("bookName");
		String bookKanaName=request.getParameter("bookKanaName");
		String price=request.getParameter("price");
		String issueDate=request.getParameter("issueDate");
		String createDateTime=request.getParameter("createDateTime");
		String updateDateTime=request.getParameter("updateDateTime");
		request.setAttribute("janCode",janCode);
		request.setAttribute("isbnCode", isbnCode);
		request.setAttribute("bookName", bookName);
		request.setAttribute("bookKanaName", bookKanaName);
		request.setAttribute("price",price);
		request.setAttribute("issueDate",issueDate);
		request.setAttribute("createDateTime",createDateTime);
		request.setAttribute("updateDateTime",updateDateTime);
		String view="WEB-INF/views/edit.jsp";		
		RequestDispatcher dispatcher= request.getRequestDispatcher(view);
 	   	dispatcher.forward(request,response);
	}

}
