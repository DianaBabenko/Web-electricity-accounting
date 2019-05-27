package p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.DataForTheMonth;
import logic.ElectricityAccounting;
//import java.math.BigDecimal;
import java.util.List;


/**
 * Servlet implementation class GetInfoForPeriod
 */
@WebServlet("/period-data")
public class PeriodData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeriodData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ElectricityAccounting electricityAccounting = (ElectricityAccounting)session.getAttribute("electricityAccounting");
		
		if (electricityAccounting == null) {
			electricityAccounting = new ElectricityAccounting();
		} 
		int firstYear = Integer.parseInt((String)request.getParameter("first_year"));
		int lastYear = Integer.parseInt((String)request.getParameter("last_year"));
		String firstMonth = request.getParameter("first_month");
		String lastMonth = request.getParameter("last_month");
					
		request.setAttribute("firstYear", firstYear);
		request.setAttribute("firstMonth", firstMonth);
		request.setAttribute("lastYear", lastYear);
		request.setAttribute("lastMonth", lastMonth);
			    
		List<DataForTheMonth> dataForPeriod = electricityAccounting.getElectricityDataForPeriod(firstYear, firstMonth, lastYear, lastMonth);
			
		ElectricityAccounting electricityAccountingPeriod = new ElectricityAccounting(dataForPeriod);
			
		electricityAccountingPeriod.getUsedEnergy();
		electricityAccountingPeriod.getCost();
			
		request.setAttribute("get_energy", electricityAccountingPeriod.getTotalNumberOfEnergy());
		request.setAttribute("get_cost", electricityAccountingPeriod.getTotalCostOfEnergy());
		request.setAttribute("dataForPeriod", dataForPeriod);
		
		getServletContext().getRequestDispatcher("/infoForPeriod.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
