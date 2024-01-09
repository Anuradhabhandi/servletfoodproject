package food_application.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.FoodItemsCrud;
import food_application.dto.FoodItems;

@WebServlet("/addfooditems")
public class AddfoodItems extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       String name=req.getParameter("name");
	       String quantity =req.getParameter("quantity");
	       String price=req.getParameter("price");
	       
	       FoodItemsCrud fc=new FoodItemsCrud();
	       fc.saveFoodItems(new FoodItems(name, Integer.parseInt(quantity), Integer.parseInt(price)));
	       
	       
	       
	}

}
