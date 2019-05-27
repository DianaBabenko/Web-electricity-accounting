package p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import logic.*;
import java.math.BigDecimal;

/**
 * Servlet implementation class Energy
 */
@WebServlet("/add-month")
public class Addmonth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataForTheMonth dataForTheMonth;
	
    /**
     * Default constructor. 
     */
    public Addmonth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ElectricityAccounting electricityAccounting = (ElectricityAccounting)request.getSession().getAttribute("electricityAccounting");
		if (electricityAccounting == null) {
			electricityAccounting = new ElectricityAccounting();
		}
		String month = request.getParameter("month"); // enter data to dataForTheMonth 
		int year = Integer.parseInt(request.getParameter("year"));
		dataForTheMonth = new DataForTheMonth(month, year);
		int previousResult = Integer.parseInt(request.getParameter("previousResult"));//from jsp to servlet
		int currentResult = Integer.parseInt(request.getParameter("currentResult"));
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		
		dataForTheMonth.setResultOfCurrentCounter(currentResult); //from servlet to class
		dataForTheMonth.setResultOfCounters(previousResult, currentResult);
		dataForTheMonth.setPrice(price);
		
		dataForTheMonth.calcUsedEnergy(); 
    	dataForTheMonth.calcCostOfEnergy();
    	electricityAccounting.addMonthData(dataForTheMonth);
    	
    	request.setAttribute("month","Month: " + month);
    	request.setAttribute("year", "Year: " + year);
    	request.setAttribute("previousResult", "Previous result: " + previousResult);
    	request.setAttribute("currentResult", "Current result: " + currentResult);
    	request.setAttribute("energyPerMonth", "Energy per month: " + dataForTheMonth.getEnergyPerMonth());
    	request.setAttribute("price", "Price: " + price);
    	request.setAttribute("cost", "Cost: " + dataForTheMonth.getCostPerMonth());
    	
    	/*request.setAttribute("getCurrentMonthInfo", dataForTheMonth.getInfoMonth());*/
        request.getSession().setAttribute("electricityAccounting", electricityAccounting );
    	
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
