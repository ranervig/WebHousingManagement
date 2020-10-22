package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Property;

/**
 * Servlet implementation class navigationPropertyServlet
 */
@WebServlet("/navigationPropertyServlet")
public class navigationPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationPropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThisToProperty");		
		String path = "/viewAllPropertiesServlet";
		
		PropertyHelper dao = new PropertyHelper();
		if(act.equals("delete")) {	
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Property itemToDelete = dao.searchForPropertyById(tempId);
			dao.deleteProperty(itemToDelete);
			
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select a property");
			}		
		}
		else if (act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Property propertyToEdit = dao.searchForPropertyById(tempId);
			request.setAttribute("propertyToEdit", propertyToEdit);
			path = "/edit-property.jsp";
			
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select property");
			}			
		}
		else if (act.equals("add")) {				
			path = "/index.html";			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	
	}
}
