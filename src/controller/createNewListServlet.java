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
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListPropertyHelper lih = new ListPropertyHelper();
		
		String tenantName = request.getParameter("tenantName");
		System.out.println("Tenant Name: "+ tenantName);
		
		String price;
		double rent = Double.parseDouble(request.getParameter("price"));		
		System.out.println("Rent Price per Month: "+ rent);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		
		LocalDate leaseSingingDate;
		try {
			leaseSingingDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			leaseSingingDate = LocalDate.now();
		}
		
		LocalDate rentStart;
		try {
			rentStart = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			rentStart = LocalDate.now();
		}
		
		LocalDate rentEnd;
		try {
			rentEnd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			rentEnd = LocalDate.now();
		}
		
		String aptNo = request.getParameter("aptNo");
		System.out.println("Apartment No.: "+ aptNo);
		
		String[] selectedProperty = request.getParameterValues("allItemsToAdd");
		List<Property> selectedPropertyInList = new ArrayList<Property>();
		
		for(int i = 0; i<selectedProperty.length; i++) {
			System.out.println(selectedProperty[i]);
			Property c = lih.searchForItemById(Integer.parseInt(selectedProperty[i]));
			selectedPropertyInList.add(c);			
		}
		
		Tenant tenant = new Tenant(tenantName, rent, rentStart, rentEnd, aptNo);
		LeaseDetails sld = new LeaseDetails(aptNo, leaseSingingDate, tenant);
		sld.setListOfUnits(selectedPropertyInList);
		ListLeaseDetailsHelper slh = new ListLeaseDetailsHelper();
		slh.insertItem(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllPropertiesServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
