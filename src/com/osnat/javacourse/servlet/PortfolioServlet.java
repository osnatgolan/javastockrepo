package com.osnat.javacourse.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osnat.javacourse.model.Portfolio;
import com.osnat.javacourse.service.PortfolioManager;


public class PortfolioServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws  IOException {
		
			resp.setContentType("text/html");
					
			PortfolioManager portfolioManager = new PortfolioManager();
			
			Portfolio portfolio = portfolioManager.getPortfolio();
			
			resp.getWriter().println(portfolio.getHtmlString(portfolio));

			
	}


}
