package food_application.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.FoodItemsCrud;
import food_application.dto.FoodItems;

@WebServlet("/delete")
public class EditFoodItems1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String quantity=req.getParameter("quantity");
		String price=req.getParameter("price");
		
		FoodItems fi=new FoodItems(name, Integer.parseInt(quantity), Double.parseDouble(price));
		fi.setId(Integer.parseInt(id));
		
		FoodItemsCrud fc=new FoodItemsCrud();
		System.out.println("deleted....");
		fc.deleteFoodItems(Integer.parseInt(id));
		
	}
}
