package com.osnat.javacourse.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osnat.javacourse.model.Portfolio;
import com.osnat.javacourse.service.PortfolioManager;
import com.osnat.*;


public class PortfolioServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws  IOException {
		
			resp.setContentType("text/html");
					
			PortfolioManager portfolioManager = new PortfolioManager();
			Portfolio portfolio = portfolioManager.getPortfolio();
			
			
			//create portfolio2 which is a copy of portfolio 01 
			Portfolio portfolio2= new Portfolio(portfolio);
			portfolio2.setTitle("Portfolio 02");
			
			//Print portfolio #1 and #2
			resp.getWriter().println(portfolio.getHtmlString(portfolio));
			resp.getWriter().println(portfolio2.getHtmlString(portfolio2));
			
			//removing first stock from portfolio1
			portfolio.removeStock(portfolio.getStock()[0]);
			
			//print again
			resp.getWriter().println(portfolio.getHtmlString(portfolio));
			resp.getWriter().println(portfolio2.getHtmlString(portfolio2));
			
			//change last stock's bid value of portfolio2 to 55.55
			portfolio2.getStock()[2].setBid(55.55F );
			
			//print again
			resp.getWriter().println(portfolio.getHtmlString(portfolio));
			resp.getWriter().println(portfolio2.getHtmlString(portfolio2));




			
	}


}
