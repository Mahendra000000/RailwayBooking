package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/fetchalltrain")
public class FetchAllTrain extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TrainDao dao=new TrainDao();
		List<Train> list=dao.fetchAll();
		
		if(list.isEmpty())
		{
			resp.getWriter().println("<h1 style='color:red'>No train to display</h1>");
			req.getRequestDispatcher("ManagementHome.html").include(req, resp);
		}
		else{
			req.setAttribute("list", list);
			req.getRequestDispatcher("FetchRailwayInfo.jsp").forward(req, resp);
		}
	}
}
