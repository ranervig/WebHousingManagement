package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LeaseDetails;
import model.Property;
import model.Tenant;

/**
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
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
		ListPropertyHelper lih = new ListPropertyHelper();
		PropertyHelper sh = new PropertyHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		LeaseDetails listToUpdate = dao.searchForItemById(tempId);

		String tenantName = request.getParameter("tenantName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		
		//find our add the new customer
		Tenant newTenant = sh.findTenant(tenantName);

		LocalDate leaseSingingDate;
		try {
			leaseSingingDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			leaseSingingDate = LocalDate.now();
		}
		
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Property> selectedItemsInList = new ArrayList<Property>();

			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Property c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}
			listToUpdate.setListOfUnits(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Property> selectedItemsInList = new ArrayList<Property>();
			listToUpdate.setListOfUnits(selectedItemsInList);
		}

		listToUpdate.setTenant(newTenant);		
		listToUpdate.setLeaseDate(leaseSingingDate);
		

		dao.updateItem(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
	

}
