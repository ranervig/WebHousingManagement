package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Property;

/**
 * Servlet implementation class editPropertyServlet
 */
@WebServlet("/editPropertyServlet")
public class editPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPropertyServlet() {
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
		PropertyHelper dao = new PropertyHelper();		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Property propertyToUpdate = dao.searchForPropertyById(tempId);
		propertyToUpdate.setName(name);
		propertyToUpdate.setAddress(address);
		
		dao.updatePropertys(propertyToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPropertiesServlet").forward(request, response);
	}

}
