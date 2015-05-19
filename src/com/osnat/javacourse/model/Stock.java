package com.osnat.javacourse.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.algo.model.StockInterface;


public class Stock implements StockInterface{
	
	public enum ALGO_RECOMMENDATION{
		BUY, SELL, REMOVE, HOLD
	}

	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	private ALGO_RECOMMENDATION recomendation;
	private int stockQuantity=0;
	
	
	DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
	
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public ALGO_RECOMMENDATION getRecomendation() {
		return recomendation;
	}
	public void setRecomendation(ALGO_RECOMMENDATION recomendation) {
		this.recomendation = recomendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	//Constructor
	public Stock(String symbol, float ask, float bid, Date date) {
				this.setSymbol(symbol);
				this.setBid( bid);
				this.setAsk(ask);
				this.setDate(date);
				this.stockQuantity=0;
				this.recomendation=ALGO_RECOMMENDATION.HOLD;
				
			}
	
	//Copy constructor
	public Stock(Stock stock){
		
		this.setSymbol(stock.getSymbol());
		this.setBid(stock. getBid());
		this.setAsk(stock.getAsk());
		this.setDate(stock.getDate());
		this.setStockQuantity(stock.getStockQuantity());
		this.setRecomendation(stock.getRecomendation());
	}
	
	//printing stocks
	public String getHtmlDescription(){
		 String StockDeatails= new String ("<br>"+"<b>Stock symbol  </b>:"+this.getSymbol()+ "<b>  Bid: </b> "+this.getBid()+"<b>  Ask: </b> "+this.getAsk()+"<b>  Date: </b> "+ df.format(this.getDate())+"<b>  Quantity: </b> "+ this.getStockQuantity()+"<br>");
		 return StockDeatails;
	}
	
}
	
	


