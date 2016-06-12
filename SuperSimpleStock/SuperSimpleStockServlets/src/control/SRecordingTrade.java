package control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Trade;
import model.ISuperSimpleStockLocal;

/**
 * Servlet implementation class SRecordingTrade
 */
@WebServlet("/SRecordingTrade")
public class SRecordingTrade extends HttpServlet {

	private static final long serialVersionUID = 1426063381263737988L;

	@EJB // Get the Ejb POJO
	private ISuperSimpleStockLocal superStockBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SRecordingTrade() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Create one Trade Object by "Get" request/response and call the service
		Trade trade = new Trade(/* Built using parameters received */);

		try {
			superStockBean.recordingTrade(trade);
		} catch (Exception e) {
			// Managing the exception caught
		}
	}

}
