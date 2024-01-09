package food_application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.FoodItemsCrud;
import food_application.dto.FoodItems;

@WebServlet("/updatefooditems")
public class UpdateFoodItems extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		 FoodItemsCrud crud = new FoodItemsCrud();
		 FoodItems db = crud.fetchId(id);
		 System.out.println(db);
		if(db!=null) {
			req.setAttribute("fooditems",db);
			RequestDispatcher dis=req.getRequestDispatcher("updatefooditems.jsp");
			dis.forward(req, resp);
		}
		else {
			req.setAttribute("msg", "email is wrong");
			RequestDispatcher dis=req.getRequestDispatcher("login.jsp");
			dis.forward(req, resp);
		}
	}
	
}

//
//}
