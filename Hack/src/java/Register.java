import java.io.*;    
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
public class Register extends HttpServlet { 
    
    @Override
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();

out.println("<!doctype HTML>");

out.println("<head>");
	out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
	out.println("<title>Register for NULLPOINTERS</title>");
	out.println("<link rel=\"stylesheet\" href=\"stylesheet_register.css\">");	
	out.println("<link href=\"https://fonts.googleapis.com/css?family=Ubuntu\" rel=\"stylesheet\">");

out.println("</head>");

out.println("<body>");
	out.println("<div class=\"container-fluid\">");
		out.println("<div class=\"row\">");
			out.println("<div class=\"col-xs-3\">");
			out.println("</div>");
			out.println("<div class=\"col-xs-6 well signupform\">");
				out.println("<h3><strong>Sign Up for NULLPOINTERS</strong></h3>");
				out.println("<form>");
					out.println("Full Name:");
					out.println("<input type=\"text\" name=\"userfullname\" placeholder=\"Enter your full name\"><br><br>");
					out.println("E-mail:");
					out.println("<input type=\"text\" name=\"useremail\" placeholder=\"Enter your email\"><br><br>");
					out.println("Password:");
					out.println("<input type=\"password\" name=\"userpassword\" placeholder=\"Enter your password\"><br><br>");
					out.println("Phone:");
					out.println("<input type=\"text\" name=\"userphone\" placeholder=\"Enter your phone number\"><br><br>");
					out.println("City:");
					out.println("<select name=\"city\">");
						out.println("<option value=\"Mumbai\">Mumbai</option>");
						out.println("<option value=\"Delhi\">Delhi</option>");
						out.println("<option value=\"Kolkata\">Kolkata</option>");
						out.println("<option value=\"Chennai\">Chennai</option>");
					out.println("</select><br><br>");
					out.println("Interests(Select all that apply):<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Politics\">Politics<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Alumni Connect\">Alumni Connect<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Books\">Books<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Games\">Games<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Movies\">Movies<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Health\">Health<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Pets\">Pets<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Sports\">Sports<br>");
					out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Careers\">Careers<br>");
					//out.println("<input class=\"cb\" type=\"checkbox\" name=\"interest\" value=\"Hobbies\">Hobbies<br>");
					out.println("<input type=\"submit\" formaction=\"Success\" value=\"Register\" class=\"btn-success rb\">");
				out.println("</form>");
			out.println("</div>");
		
			out.println("<div class=\"col-xs-3\">");
			out.println("</div>");
		out.println("</div>");
	
	
	out.println("</div>");
out.println("</body>");

}
}