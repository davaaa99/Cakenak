package controller.penjual;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbrepo.RepoAds;
import model.Advertisement;

/**
 * display all ads
 * @KoTA109
 */
@WebServlet("/penjual/ShowAdvertisement")
@MultipartConfig
public class ShowAdvertisement extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7119360475260654485L;
	ArrayList<Advertisement> arr;
    RepoAds model;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        model = new RepoAds();
        arr = model.getAllAdvertisements();
        request.setAttribute("allAdsPenjual", arr);
        String nextJSP = "/penjual/ads.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

    }



}
