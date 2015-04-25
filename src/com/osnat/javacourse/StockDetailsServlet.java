package com.osnat.javacourse;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.osnat.javacourse.Stock;
import java.util.Calendar;
import java.util.Date;


public class StockDetailsServlet extends HttpServlet {
	
	
	
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
			Calendar c= Calendar.getInstance();
			c.set(2014, 10, 15);
				
			
			Date date1 = c.getTime();
			Stock stock1= new Stock("PIH",(float) 13.1,(float) 12.4,date1 );
			
			Date date2 = c.getTime();
			Stock stock2= new Stock("AAL",(float) 5.78, (float) 5.5, date2);
			
			Date date3 = c.getTime();
			Stock stock3= new Stock("CAAS",(float) 32.2, (float) 31.5, date3);
			
			

	
		
	
			resp.getWriter().println("The stocks details are: <br>");
			resp.getWriter().println(stock1.getHtmlDescription());
			resp.getWriter().println(stock2.getHtmlDescription());
			resp.getWriter().println(stock3.getHtmlDescription());
			
		resp.setContentType("text/html");
	
		
		}
		
}
