package control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ISuperSimpleStockLocal;

/**
 * Servlet implementation class SGBCEAllShareUsing
 */
@WebServlet("/SGBCEAllShareUsing")
public class SGBCEAllShareUsing extends HttpServlet {
	
	private static final long serialVersionUID = -2326496618610959189L;
	
	@EJB // Get the Ejb POJO
	private ISuperSimpleStockLocal superStockBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SGBCEAllShareUsing() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// call the service
		try {
			superStockBean.getGBCEAllShareUsing();
		} catch (Exception e) {
			// Managing the exception caught
		}
	}

}
