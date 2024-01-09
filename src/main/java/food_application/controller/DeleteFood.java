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

import food_application.dao.FoodCrud;
import food_application.dao.FoodItemsCrud;
import food_application.dto.Food;
import food_application.dto.FoodItems;

@WebServlet("/deletefood")
public class DeleteFood extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println();
		 FoodCrud crud = new FoodCrud();
		 Food db = crud.fetchId(id);
		 System.out.println(db);
		 crud.deleteFood(id);
		 
		 
		   
		  FoodItemsCrud fi=new FoodItemsCrud();
		   List<FoodItems> list = fi.fetchFoodItems();
		  
		      req.setAttribute("list",list);
			  RequestDispatcher dis = req.getRequestDispatcher("userfood.jsp");
			  dis.forward(req, resp);
			
			 
	}

}
