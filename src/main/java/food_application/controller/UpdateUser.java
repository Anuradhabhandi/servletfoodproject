package food_application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_application.dao.UserCrud;
import food_application.dto.User;

@WebServlet("/userUpdate")
public class UpdateUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		String pwd1=req.getParameter("pwd1");
		
		UserCrud uc=new UserCrud();
		User u=new User(email,pwd);
		System.out.println(pwd+pwd1);
		if(pwd!=null) {
			uc.update(email,pwd);
			System.out.println("UPdated");
//			from here i have to go to the food page
		}
		else {
			   req.setAttribute("Pwd", "Password didnt matched");
			 RequestDispatcher dis = req.getRequestDispatcher("userUpdatePwd.jsp");
			 dis.include(req, resp);
		}
	}

}
