package food_application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.FoodItemsCrud;
import food_application.dao.ManagerCrud;
import food_application.dto.FoodItems;
import food_application.dto.HotelManager;

@WebServlet("/manloginjsp")
public class ManagerLogin extends HttpServlet{
	int count=0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd =req.getParameter("pwd");
		ManagerCrud crud=new ManagerCrud();
		FoodItemsCrud fc=new FoodItemsCrud();
		try {
		HotelManager log = crud.fetchEmail(email);
		count++;
		if(log.getPwd().equals(pwd)) {
			//display food items
			RequestDispatcher dis = req.getRequestDispatcher("fooditems.jsp");//updatedelete   outside table --one button -add food
			dis.forward(req, resp);
		}
		else {
			 System.out.println(count);
				if(count>=3) {
					RequestDispatcher dis = req.getRequestDispatcher("manUpdatePwd.html");
			          dis.include(req, resp);
					
				}
				else {
			          req.setAttribute("msg", "Password is incorrect");
			          RequestDispatcher dis = req.getRequestDispatcher("manlogin.jsp");
			          dis.include(req, resp);
				}
			
		}
	}catch (Exception e) {
		 req.setAttribute("msg", "email id is incorrect");
         RequestDispatcher dis = req.getRequestDispatcher("manlogin.jsp");
         dis.include(req, resp);
	}
		
	}

}
