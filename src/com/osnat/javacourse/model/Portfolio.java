package com.osnat.javacourse.model;

import java.util.Date;
import com.osnat.*;

public class Portfolio {
	
	String title;
	private final static int MAX_PORTFOLIO_SIZE=5;
	private Stock[] stocks;
    int portfolioSize=0;
    
    
    //getters and Setters
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Stock[] getStocks() {
		return stocks;
	}


	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}


	public int getPortfolioSize() {
		return portfolioSize;
	}


	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	

	//Constructor
	public Portfolio(String title){
		
		
		this.stocks= new Stock[MAX_PORTFOLIO_SIZE];
		this.title= title;
		this.portfolioSize=0;
	}
	
	
	//Copy constructor
	public Portfolio(Portfolio portfolio){
	
		this(portfolio.getTitle());
		setPortfolioSize(portfolio.getPortfolioSize());
		
		for(int i=0; i<portfolio.getPortfolioSize(); i++){
			stocks[i]= new Stock(portfolio.getStock()[i]);			
		}
		
	}
	
	
	
	public void addStock(Stock stk){
			
		if(this.portfolioSize<MAX_PORTFOLIO_SIZE && stk != null )
		{
			this.stocks[this.portfolioSize]=stk;
			this.portfolioSize++;	
		}
		else
			System.out.println("Portfolio is full!");
	}
	

	public Stock[] getStock(){
		return this.stocks;
	}
	
	public String getHtmlString(Portfolio portfolio){
		
		String str= new String("<h>"+ this.title +"<h>"+ "<br/>");
		
		
		for(int i=0; i<this.portfolioSize; i++){
			str=str+ this.stocks[i].getHtmlDescription();
		}
		
		return str;
	}
	
	//Removes Stock from portfolio
	public void removeStock(Stock stock)
		{
			for(int i=0; i < portfolioSize; i++)
			{
				if(this.stocks[i].getSymbol().equals(stock.getSymbol()))
				{
					if(i != portfolioSize-1 && portfolioSize > 1)
						
							this.stocks[i] = new Stock(this.stocks[portfolioSize-1]);
						
				}
			}
			this.portfolioSize--;
		}

	
}
