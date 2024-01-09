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
import food_application.dto.FoodItems;
import food_application.dto.HotelManager;

@WebServlet("/empty")
public class FetchFoodItem extends HttpServlet {
		  @Override 
		  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   String email=req.getParameter("email");
		   String pwd=req.getParameter("pwd");
		   ManagerCrud crud=new ManagerCrud();
			FoodItemsCrud fc=new FoodItemsCrud();
		
			try {
				HotelManager log = crud.fetchEmail(email);
				if(log.getPwd().equals(pwd)) { 
					  List<FoodItems> list = fc.fetchFoodItems(); 
					  req.setAttribute("list", list); 
					  RequestDispatcher dis = req.getRequestDispatcher("fooditemsdisplay.jsp"); 
					  dis.forward(req, resp);
				}
			} catch (Exception e) {
				  RequestDispatcher dis = req.getRequestDispatcher("manlogin.jsp"); 
				  dis.forward(req, resp);
			}
			
			
		  
		 }
		

}
