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
public class Success extends HttpServlet {
    Connection connect;
    Statement stmt;
    ResultSet rs;
    PreparedStatement stmt1;
    @Override
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
            
           response.setContentType("text/html");  
            PrintWriter out = response.getWriter();                   
String name=request.getParameter("userfullname");  
String email=request.getParameter("useremail");     
String password=request.getParameter("userpassword");
String phone=request.getParameter("userphone");
String city=request.getParameter("city");
String[] interests = request.getParameterValues("interest");
String inter="";
try{
		connect = DriverManager.getConnection("jdbc:sqlserver://VATSAL; databaseName=NullPointers" , "sa" , "pass123");
		stmt = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
		rs=stmt.executeQuery("SELECT * FROM UserTable ORDER BY Name ASC");
                stmt1 = connect.prepareStatement("insert into UserTable values(?,?,?,?,?,?)");
                for(int i=0; i<interests.length;i++)
                {
                    switch(interests[i])
                    {
                        case "Politics" : inter=inter+"1"; 
                                          break;
                        case "Alumni Connect" : inter=inter+"2"; 
                                          break;
                        case "Books" : inter=inter+"3"; 
                                          break;                    
                        case "Games" : inter=inter+"4"; 
                                          break;            
                        case "Movies" : inter=inter+"5"; 
                                          break;
                        case "Health" : inter=inter+"6"; 
                                          break;
                        case "Pets" : inter=inter+"7"; 
                                          break;
                        case "Sports" : inter=inter+"8"; 
                                          break;
                        case "Careers" : inter=inter+"9"; 
                                          break;
                        default : break;                  
                                     
                                          
                    }
                }
                stmt1.setString(1,name);
                stmt1.setString(2,email);
                stmt1.setString(3,phone);
                stmt1.setString(4,inter);
                stmt1.setString(5,city);
                stmt1.setString(6,password);
                stmt1.executeUpdate();
                out.println("<p><center>You have been successfully registered. </center></p>");
               out.println("<a href=\"hac\"><center><button type=\"submit\" formaction=\"hac\">Login to Continue</button></center></a>");
}               
  catch(Exception e)
		{
			System.out.println(e+"1");
		}
        
        }

}
