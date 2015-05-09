package com.osnat.javacourse.service;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osnat.javacourse.model.Portfolio;
import com.osnat.javacourse.model.Stock;
import com.osnat.*;

import java.util.Calendar;
import java.util.Date;

public class PortfolioManager {
	
	public void portfolioManager(){
		
	}
	
	public Portfolio getPortfolio(){
		
		 Portfolio myPortfolio = new Portfolio("Exercise 7 portfolio");
		 myPortfolio.setBalance(10000);

		

		Calendar c= Calendar.getInstance();
		c.set(2014, 11, 15);
		
		
		Date date1 = c.getTime();
		Stock stock1= new Stock("PIH",(float) 10.0,(float) 8.5,date1 );
		
		Date date2 = c.getTime();
		Stock stock2= new Stock("AAL",(float) 30.0, (float) 25.5, date2);
		
		Date date3 = c.getTime();
		Stock stock3= new Stock("CAAS",(float) 20.0, (float) 15.5, date3);
			
		
	myPortfolio.buyStock(stock1,20);
	myPortfolio.buyStock(stock1,30);
	myPortfolio.buyStock(stock1,40);
	
	myPortfolio.sellStock("AAL", -1);
	
	myPortfolio.removeStock("CAAS");

		
		return myPortfolio;
	}
	
	

}
