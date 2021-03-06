package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbrepo.RepoKue;

/**
 * delete product
 * 
 * @KoTA109
 */
@WebServlet(name = "DeleteProduk", urlPatterns = { "/admin/DeleteProduk" })
public class DeleteProduct extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 20669054058460992L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		if (new RepoKue().deleteKue(id)) {
			// redirect to Success
			// set alert message
			request.getSession().setAttribute("AlertMessage", "Kue Deleted Successfully");
			// set alert type
			request.getSession().setAttribute("AlertType", "success");
			response.sendRedirect("AdminKueServlet");

		} else {
			// can't add product
			// set alert message
			request.getSession().setAttribute("AlertMessage", "canot Delete product ..An Error occure");
			// set alert type
			request.getSession().setAttribute("AlertType", "danger");
			response.sendRedirect("AdminKueServlet");

		}

	}

}
