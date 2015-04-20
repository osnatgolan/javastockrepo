package com.osnat.javacourse;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.osnat.javacourse.Stock;
import java.util.Calendar;


public class StockDetailsServlet extends HttpServlet {
	
	
	
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
			Calendar c= Calendar.getInstance();
			c.set(2014, 10, 15);
				
			
			Stock stock1= new Stock();
			Stock stock2= new Stock();
			Stock stock3= new Stock();
			
			
			stock1.setSymbol("PIH");
			stock1.setAsk((float) 13.1);
			stock1.setBid((float) 12.4);
			stock1.setDate(c.getTime());
			
			stock2.setSymbol("AAL");
			stock2.setAsk((float) 5.78);
			stock2.setBid((float) 5.5);
			stock2.setDate(c.getTime());
			
			stock3.setSymbol("CAAS");
			stock3.setAsk((float) 32.2);
			stock3.setBid((float) 31.5);
			stock3.setDate(c.getTime());
		
	
			resp.getWriter().println("The stocks details are: <br>");
			resp.getWriter().println(stock1.getHtmlDescription());
			resp.getWriter().println(stock2.getHtmlDescription());
			resp.getWriter().println(stock3.getHtmlDescription());
			
		resp.setContentType("text/html");
	
		
		}
		
}
