package Ads;

import Ads.Ads;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/advertisements")
public class ShowAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // Use the factory to get the dao object
        Ads adsDAO = DaoFactory.getAdsDao();
        // Use a method on the dao to get all the products
        List<Ad> ads = adsDAO.all();
        // Pass the data to the jsp
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/ads/index.jsp").forward(request, resp);
    }
}
