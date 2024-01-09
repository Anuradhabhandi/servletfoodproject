package food_application.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.FoodCrud;
import food_application.dto.Food;


@WebServlet("/editfood")
public class AddToCart  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String quantity=req.getParameter("quantity");
		String price=req.getParameter("price");
		
		Food fi=new Food(name, Integer.parseInt(quantity), Double.parseDouble(price));
		fi.setId(Integer.parseInt(id));
		FoodCrud fc=new FoodCrud();
		fc.saveFood(fi);
		
		 List<Food> food = fc.fetchFood();
		 req.setAttribute("list", food);
		 RequestDispatcher dis = req.getRequestDispatcher("cart.jsp");
		 dis.forward(req, resp);
		
	}

}
