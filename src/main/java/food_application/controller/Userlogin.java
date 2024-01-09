package food_application.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.FoodItemsCrud;
import food_application.dao.ManagerCrud;
import food_application.dao.UserCrud;
import food_application.dto.FoodItems;
import food_application.dto.HotelManager;
import food_application.dto.User;

@WebServlet("/user")
public class Userlogin extends HttpServlet {
	int count=0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd =req.getParameter("pwd");
		
		UserCrud crud=new UserCrud();
		FoodItemsCrud fc=new FoodItemsCrud();
		
		try {
		User log = crud.fetchEmail(email);
		if(log.getPwd().equals(pwd)) {
			List<FoodItems> list = fc.fetchFoodItems();
			System.out.println("About to display the food items");
			req.setAttribute("list", list);
			RequestDispatcher dis = req.getRequestDispatcher("userfood.jsp");
			dis.forward(req, resp);
			
			
		}
		else {
			    count++;
				if(count>=3) {
					RequestDispatcher dis = req.getRequestDispatcher("userUpdatePwd.html");
			          dis.include(req, resp);
					
				}
				else {
			          req.setAttribute("msg", "Password is incorrect");
			          RequestDispatcher dis = req.getRequestDispatcher("userlogin.jsp");
			          dis.include(req, resp);
				}
			
		}
	}catch (Exception e) {
		 req.setAttribute("msg", "email id is incorrect");
         RequestDispatcher dis = req.getRequestDispatcher("userlogin.jsp");
         dis.include(req, resp);
	}
		
	}
	}

