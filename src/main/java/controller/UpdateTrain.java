package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/updatetrain")
public class UpdateTrain extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int trainNumber=Integer.parseInt(req.getParameter("tnumber"));
		String trainName=req.getParameter("tname");
		int trainSeat=Integer.parseInt(req.getParameter("tseat"));
		String[] trainStations=req.getParameter("tstation").replace(" ", "").split(",");
		String[] trainPrice=req.getParameter("tprice").replace(" ", "").split(",");
		String[] trainTime=req.getParameter("ttime").replace(" ", "").split(",");
		String[] trainDays=req.getParameter("tdays").replace(" ", "").split(",");
		
		Train tr=new Train();
		tr.setDays(trainDays);
		tr.setName(trainName);
		tr.setNumber(trainNumber);
		tr.setPrice(trainPrice);
		tr.setSeat(trainSeat);
		tr.setStations(trainStations);
		tr.setTime(trainTime);
		
		TrainDao dao=new TrainDao();
		dao.update(tr);
	}
}
