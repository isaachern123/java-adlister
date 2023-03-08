package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String uname=request.getParameter("uname");
        String pword=request.getParameter("pword");
        if(uname.equals("admin") && pword.equals("password")){
            HttpSession session=request.getSession(true);
            session.setAttribute("uname", uname);
            session.setAttribute("pword", pword);
            response.sendRedirect("profile.jsp");
        }else{
            response.sendRedirect("login.jsp"); //error
            HttpSession  session=request.getSession(true);
            session.setAttribute("errorMessage", "Login Failed ");

        }
        //doGet(request, response);
    }

}