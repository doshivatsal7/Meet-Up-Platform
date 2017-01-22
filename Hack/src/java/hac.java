/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vatsal
 */
public class hac extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!doctype HTML>");
out.println("<head>");
	out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
	out.println("<title>Login to NULLPOINTERS</title>");
	out.println("<link rel=\"stylesheet\" href=\"stylesheet_index.css\">");	
	out.println("<link href=\"https://fonts.googleapis.com/css?family=Ubuntu\" rel=\"stylesheet\">");

out.println("</head>");

out.println("<body>");
	out.println("<div class=\"container-fluid\">");
		out.println("<div class=\"row\">");
			out.println("<div class=\"col-xs-1\">");
				
			out.println("</div>");
			
			
			out.println("<div class=\"col-xs-10 well\">");
				out.println("<div>");
				
					out.println("<p><strong>Login to access NULLPOINTERS</strong></p>");
					out.println("<div class=\"row\">");
						out.println("<div class=\"col-xs-3\">");
						out.println("</div>");
						out.println("<div class=\"col-xs-6\">");
						out.println("	<form>");
							out.println("	<h4>");
									out.println("Username:");
								out.println("</h4>");
								out.println("<input type=\"text\" name=\"username\" placeholder=\"Username\">");
								out.println("<h4>");
								out.println("	Password:");
								out.println("</h4>");
								out.println("<input type=\"password\" name=\"password\" placeholder=\"Password\">");
								out.println("<br>");
								out.println("<br>");
                                                             
								out.println("<button type=\"submit\" class=\"btn-success\" formaction=\"Profile\">");
                                                                out.println("Login");
                                                                out.println("</button>");
                                                                out.println("OR");
								
                                                                    
                                                                out.println("<button type=\"submit\" class=\"btn-success\" formaction=\"Register\">");
                                                               out.println("Sign Up");
                                                                out.println("</button>");
                                                                
							out.println("</form>");
						
						
						out.println("</div>");
						out.println("<div class=\"col-xs-3\">");
						out.println("</div>");
					out.println("</div>");
				out.println("</div>");
			out.println("</div>");
			
			
			out.println("<div class=\"col-xs-1\">");
				
			out.println("</div>");
		out.println("</div>");
        

out.println("</body>");
   }
    catch(Exception e)
    {}}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
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
