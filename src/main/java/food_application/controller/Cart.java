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

@WebServlet("/cart")
public class Cart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FoodCrud f=new FoodCrud();
		List<Food> list=f.fetchFood();
		req.setAttribute("cart", list);
		RequestDispatcher dis = req.getRequestDispatcher("cart.jsp");
		dis.forward(req, resp);
				
	}
	

}
