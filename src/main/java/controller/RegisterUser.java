package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String pwd1 = req.getParameter("pwd1");
		String pwd2 = req.getParameter("pwd2");
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		// LocalDate.now().getYear()-dob.toLocalDate().getYear();

		if (pwd1.equals(pwd2)) {
			if (age >= 18) {

				User u=new User();
				u.setAge(age);
				u.setDob(dob);
				u.setFirstName(firstName);
				u.setGender(gender);
				u.setLastName(lastName);
				u.setMobile(mobile);
				u.setPassword(pwd1);
				u.setEmail(email);
				
				UserDao dao=new UserDao();
				dao.save(u);
				
				resp.getWriter().print("<h1 style='color:green'>Account created</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
				
			} else {
				resp.getWriter().print("<h1 style='color:red'>You are not old enough to create account</h1>");
				req.getRequestDispatcher("Register.html").include(req, resp);
			}
		} else {
			resp.getWriter().print("<h1 style='color:red'>Password mismatch</h1>");
			req.getRequestDispatcher("Register.html").include(req, resp);
		}
	}
}
