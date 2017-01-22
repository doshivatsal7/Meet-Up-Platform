/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vatsal
 */
public class Profile extends HttpServlet {

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
        try{
    PrintWriter out = response.getWriter();
    response.setContentType("text/html;charset=UTF-8");
    Connection connect;
    boolean flag=false;
    Statement stmt;
    int cnt=0;
    ResultSet rs,rs1;
    PreparedStatement stmt1;
    String name="",city="",mobile="", interest="";
    String interests[]=new String[10];
    String email=request.getParameter("username");     
    String password=request.getParameter("password");
    connect = DriverManager.getConnection("jdbc:sqlserver://VATSAL; databaseName=NullPointers" , "sa" , "pass123");
    stmt = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);   
    rs=stmt.executeQuery("SELECT * FROM UserTable ORDER BY Name ASC");
    rs.first();
    

    do{
            if(rs.getString(2).equals(email))
            {
                if(rs.getString(6).equals(password)){
                    flag=true;
                    name=rs.getString(1);
                    mobile=rs.getString(3);
                    city=rs.getString(5);
                    
                    long inter=Long.parseLong(rs.getString(4));
                   
                    while(inter!=0){
                    long d =inter%10;
                    switch((int)d)
                    {
                        case 1:interests[cnt]="Politics";
                                break;
                        case 2:interests[cnt]="Alumni Connect";
                                break;
                        case 3:interests[cnt]="Books";
                                break;
                        case 4:interests[cnt]="Games";
                               break;
                        case 5:interests[cnt]="Movies";
                                break;
                        case 6:interests[cnt]="Health";
                                break;  
                        case 7:interests[cnt]="Pets";
                                break;
                        case 8:interests[cnt]="Sports";
                                break;  
                        case 9:interests[cnt]="Careers";
                                break;          
                    }
                    cnt++;
                    inter=inter/10;
                   }
                    for(int i=0;i<cnt;i++)
                    {
                       interest=interest+", "+interests[i];
                    }
        out.println("<!doctype HTML>");
        out.println("<head>");
	out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
	out.println("<title>Welcome User</title>");
	out.println("<link rel=\"stylesheet\" href=\"stylesheet_profile.css\">");	
	out.println("<link href=\"https://fonts.googleapis.com/css?family=Ubuntu\" rel=\"stylesheet\">");
	out.println("<link href=\"https://fonts.googleapis.com/css?family=Noto+Sans\" rel=\"stylesheet\">");
        out.println("</head>");

        out.println("<body>");
	out.println("<div class=\"container-fluid\">");
			out.println("<div class=\"row headerleft\">");
			out.println("<div class=\"col-xs-8\">");
			out.println("<p>"+email+"</p>");
			out.println("</div>");
			out.println("<div class=\"col-xs-2 headerright\">");
			//out.println("<a href=\"Profile\"><p>My Profile</p></a>");
			out.println("</div>");
			out.println("<div class=\"col-xs-2 headerright\">");
			out.println("<a href=\"hac\"><p>SignOut</p></a>");
			out.println("</div>");
		out.println("</div>");
		
		out.println("<div class=\"row\">");
		out.println("<div class=\"col-xs-3\">");
		out.println("</div>");
			out.println("<div class=\"col-xs-6 well\">");
			out.println("<p>Name : "+name+"</p>");
			out.println("<p>E-mail : "+email+" </p>");
			out.println("<p>Phone : "+mobile+"</p>");
			out.println("<p>City : "+city+" </p>");
			out.println("<p>Interests : "+interest+" </p>");
			out.println("</div>");
			out.println("<div class=\"col-xs-3\">");
			out.println("</div>");
		
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<div class=\"row\">");
		out.println("<div class=\"col-xs-2\">");
		out.println("</div>");
		out.println("<div class=\"col-xs-8 well\">");   
                break;}
            }
            
        }while(rs.next());
        rs1=stmt.executeQuery("SELECT * FROM MeetUps ORDER BY Location ASC");
        rs1.first();
        if(flag){out.println("<p class=\"meets_header\">Upcoming Meets</p>");
				
				out.println("<table width=\"100%\">");
					out.println("<tr>");
					out.println("<th>Category</th>");
					out.println("<th>Location</th>");
					out.println("<th>Date</th>");
					out.println("<th>Time</th>");
					out.println("</tr>");}
        else
            {
               
               out.println("<p><center>Username OR Password is incorrect</center></p>");
               out.println("<a href=\"hac\"><center><button type=\"submit\" formaction=\"hac\">Back to Home</button></center></a>");
               
            }
					
        do{
            if(city.equals(rs1.getString(2))){
                for(int j=0;j<cnt;j++)
                {   
                    if(interests[j].equals(rs1.getString(1)))
                    {
                                        out.println("<tr>");
					out.println("<td>"+rs1.getString(1)+"</td>");
					out.println("<td>"+rs1.getString(2)+"</td>");
					out.println("<td>"+rs1.getString(3)+"</td>");
					out.println("<td>"+rs1.getString(4)+"</td>");
					out.println("</tr>");
	
                    }
                }
            }
           
        }while(rs1.next());
        out.println("</table>");
				
			out.println("</div>");
			out.println("<div class=\"col-xs-2\">");
				
			out.println("</div>");
		out.println("</div>");
		
		
	out.println("</div>");
out.println("</body>");
    }//try     
        catch(Exception e){}
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
        processRequest(request, response);
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
    }
}


