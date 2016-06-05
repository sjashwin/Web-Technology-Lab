/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement ;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ashwin
 */
@WebServlet(urlPatterns = {"/ServerApplication"})
public class ServerApplication extends HttpServlet {
    Statement createStatement ;
    Connection connection ;
    PrintWriter out  ;
    String DB_URL ;
    String sql ;
    ResultSet result ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     */
    @Override
    public void init(){
        DB_URL = "jdbc:derby://localhost:1527/sample" ;
        sql = "SELECT * FROM customer" ;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        out = response.getWriter() ;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;
            connection = DriverManager.getConnection(DB_URL, "app", "app") ;
            createStatement = connection.createStatement() ;
            result = createStatement.executeQuery(sql) ;
            out.print("<table style='border:1px solid black;'>");
            
            while(result.next()){
                out.println("<tr>") ;
                out.print("<td style='border: 1px solid black;'>") ;
                out.println(result.getString("NAME")+"<br>") ;
                out.println("</td>") ;
                out.print("</tr>" );
            }
            
            out.println("</table>") ;
        }catch(SQLException | NullPointerException | ClassNotFoundException ex){
            out.println(ex.getMessage()) ;
        }
        out.println( request.getParameter("name") ) ;  
    } 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
