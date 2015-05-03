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
		
		Portfolio myportfolio= new Portfolio("Portfolio 01");
		
		Calendar c= Calendar.getInstance();
		c.set(2014, 10, 15);
		
		
		Date date1 = c.getTime();
		Stock stock1= new Stock("PIH",(float) 13.1,(float) 12.4,date1 );
		
		Date date2 = c.getTime();
		Stock stock2= new Stock("AAL",(float) 5.78, (float) 5.5, date2);
		
		Date date3 = c.getTime();
		Stock stock3= new Stock("CAAS",(float) 32.2, (float) 31.5, date3);
			
		
	myportfolio.addStock(stock1);
	myportfolio.addStock(stock2);
	myportfolio.addStock(stock3);

		
		return myportfolio;
	}
	
	

}