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
 * Servlet implementation class SStockPrice
 */
@WebServlet("/SStockPrice")
public class SStockPrice extends HttpServlet {

	private static final long serialVersionUID = -1214512140587937926L;

	@EJB // Get the Ejb POJO
	private ISuperSimpleStockLocal superStockBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SStockPrice() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create one Trade Object by "Get" request/response and call the service
		Stock stock = new Stock(/* Built using parameters received */);

		try {
			superStockBean.getPERatio(stock);
		} catch (Exception e) {
			// Managing the exception caught
		}
	}

}
