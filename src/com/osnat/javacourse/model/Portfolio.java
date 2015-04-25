package com.osnat.javacourse.model;

import com.osnat.javacourse.Stock;
import java.util.Date;

public class Portfolio {
	
	String title;
	private final static int MAX_PORTFOLIO_SIZE=5;
	private Stock[] stocks;
    int portfolioSize=0;
	
	public Portfolio(String title){
		stocks= new Stock[MAX_PORTFOLIO_SIZE];
		this.title= title;
	}
	
	
	
	public void addStock(Stock stk){
			
			this.stocks[this.portfolioSize]=stk;
			this.portfolioSize++;	
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

}
