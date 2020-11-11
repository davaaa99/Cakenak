package controller.penjual;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbrepo.RepoCharge;
import model.Charge;

/**
 * generate cards
 * @KoTA109
 */


@WebServlet(name = "ChangeCards", urlPatterns = {"/penjual/ChangeCards"})
@MultipartConfig
public class ChangeCards extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7088400910436591301L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(" in servlets");
        PrintWriter out = response.getWriter();
        int selectedItem = 0;
        String randomNumberOfCards;
            int i = 0;
             boolean found=false;

        // get  data from jsp 
        int numberOfCards = Integer.parseInt(request.getParameter("numberofcard"));
        System.out.println(numberOfCards);

        if (request.getParameter("cards") != null) {
            selectedItem = Integer.parseInt(request.getParameter("cards"));

        }
         
         System.out.println(selectedItem );
        RepoCharge model = new RepoCharge();
        do {

            randomNumberOfCards = getCardNumber(16);
            if (model.numberOfCardIsFound(randomNumberOfCards)) {
                continue;
            } else {
                Charge obj = new Charge();
                obj.setNomorkartu(randomNumberOfCards);
                obj.setTaken(0);
                obj.setUsed(0);
                obj.setValue(selectedItem);
                model.addCard(obj);
                found=true;       

            }

            i++;

        } while (i < numberOfCards);
        if(found)
        {
            //set alert message
            request.getSession().setAttribute("AlertMessage", "Cards Added Successfully");
            //set alert type
            request.getSession().setAttribute("AlertType", "success");
            response.sendRedirect("charge.jsp");
        }
        

    }

  

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String getCardNumber(int numSize) {
        Random rand = new Random();
        StringBuffer number = new StringBuffer();

        while (number.length() < numSize) {
            // Generates a random number between 0x10 and 0x99
            int myRandomNumber = rand.nextInt(0x99) + 0x10;
            number.append(Integer.toHexString(myRandomNumber));
        }

        return number.toString();
    }

}
