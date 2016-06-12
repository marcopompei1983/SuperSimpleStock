package control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Stock;
import model.ISuperSimpleStockLocal;


/**
 * Servlet implementation class SDividendYield
 */
@WebServlet("/SDividendYield")
public class SDividendYield extends HttpServlet {
	
	private static final long serialVersionUID = 4295122172070543088L;
	
	@EJB // Get the Ejb POJO
	private ISuperSimpleStockLocal superStockBean;
	
    /**
     * Default constructor. 
     */
    public SDividendYield() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Create one Stock Object by "Get" request/response and call the service
		Stock stock = new Stock(/* Built using parameters received */);
		
		try {
			superStockBean.getDividendYield(stock);
		} catch (Exception e) {
			// Managing the exception caught
		}
	}

}
