package food_application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.ManagerCrud;
import food_application.dto.HotelManager;

@WebServlet("/managerrigis")
public class ManagerRegis extends HttpServlet{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  String fname=req.getParameter("fname");
    	  String des=req.getParameter("des");
    	  String email=req.getParameter("email");
    	  String pwd=req.getParameter("pwd");
    	  String hotelname=req.getParameter("hotelname");
    	  String phone=req.getParameter("phn");
    	  String address=req.getParameter("address");
    	  
    	  ManagerCrud crud=new ManagerCrud();
    	  crud.saveManager(new HotelManager(fname, des, email, pwd, hotelname, Long.parseLong(phone), address));
    	  RequestDispatcher dis = req.getRequestDispatcher("manlogin.jsp");
    	  dis.forward(req, resp);
    }
}
