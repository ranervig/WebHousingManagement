package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LeaseDetails;

/**
 * Servlet implementation class listNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class listNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listNavigationServlet() {
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
		ListLeaseDetailsHelper dao = new ListLeaseDetailsHelper();
		String act = request.getParameter("doThisToList");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPropertiesServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				LeaseDetails listToDelete = dao.searchForItemById(tempId);
				dao.deleteItem(listToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllPropertiesServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				LeaseDetails listToEdit = dao.searchForItemById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("month", listToEdit.getLeaseDate().getMonthValue());
				request.setAttribute("date", listToEdit.getLeaseDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getLeaseDate().getYear());
				
				ListPropertyHelper daoForItems = new ListPropertyHelper();				
				request.setAttribute("allItems", daoForItems.showAllItems());						
				if(daoForItems.showAllItems().isEmpty()){
						request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-property.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllPropertiesServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			
			ListPropertyHelper daoForItems = new ListPropertyHelper();				
			request.setAttribute("allItems", daoForItems.showAllItems());						
			if(daoForItems.showAllItems().isEmpty()){
					request.setAttribute("allItems", " ");
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}
	}

}
