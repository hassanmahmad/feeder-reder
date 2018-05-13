/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.core.feed.FeedBean;
import javax.ejb.EJB;

/**
 *
 * @author Hassan
 */
@WebServlet(urlPatterns = {"/FeedServlet"})
public class FeedServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private FeedBean feedBean;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        PrintWriter out = res.getWriter();
        
        int i = Integer.parseInt(req.getParameter("t1"));
        int j = Integer.parseInt(req.getParameter("t2"));
        String l = req.getParameter("t3");
          
        int k = feedBean.calAdd(i,j);
        List<String> lis = feedBean.calAdList(l); 
        ListIterator<String> itr=lis.listIterator();
        List<String> ts = feedBean.getTime();
        ListIterator<String> itt = ts.listIterator();
        out.println("Addition is: " + k + "\n");
        
        out.println("\nAddition done by following people at following time: ");
        while (itr.hasNext())
        {
            out.println("\n" + itr.next() + " on time: " + itt.next());
        }
    }
}
