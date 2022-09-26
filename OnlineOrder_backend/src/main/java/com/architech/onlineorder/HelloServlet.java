package com.architech.onlineorder;

//import jdk.jpackage.internal.IOUtils;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;


import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.architech.onlineorder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        /*response.setContentType("text/html");//data format
//
//        String username = request.getParameter("username");
//
//        // Hello read operation
//        PrintWriter out = response.getWriter();//handler object that can print data into response body
//        out.println("<html><body>");
//        out.println("<h1>Hello " + username + "</h1>");
//        out.println("</body></html>");*/
//        response.setContentType("application/json");//data format
//
////        String username = request.getParameter("username");
//
//        // Hello read operation
//        PrintWriter out = response.getWriter();//handler object that can print data into response body
//        JSONObject object = new JSONObject();
//        object.put("email","wangyuxuan1019@hotmail.com");
//        object.put("name","Lily");
//        object.put("age",30);
//        out.println(object);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer= new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }


    public void destroy() {
    }
}