package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // extract the queryString.
        String queryString = request.getQueryString();

        // Set the name value
        String name;
        if(queryString != null){
            name = queryString.split("=")[1];
        }else {
            name = "No one";
        }

        // return the response
        response.getWriter().append("Hello, " + name);
    }
}
