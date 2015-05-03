package com.osnat.javacourse.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Stock {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	private int recomendation=0;
	private int stockQuantity=0;
	private final static int BUY= 0;
	private final static int SELL= 1;
	private final static int REMOVE= 2;
	private final static int HOLD= 3;
	
	
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
	
	
	public int getRecomendation() {
		return recomendation;
	}
	public void setRecomendation(int recomendation) {
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
				
			}
	
	//Copy constructor
	public Stock(Stock stock){
		
		this.setSymbol(stock.getSymbol());
		this.setBid(stock. getBid());
		this.setAsk(stock.getAsk());
		this.setDate(stock.getDate());
	}
	
	//printing stocks
	public String getHtmlDescription(){
		 String StockDeatails= new String ("<b>Stock symbol  </b>:"+this.getSymbol()+ "<b>  Bid: </b> "+this.getBid()+"<b>  Ask: </b> "+this.getAsk()+"<b>  Date: </b> "+ df.format(this.getDate())+"<br>");
		 return StockDeatails;
	}
	
}
	
	


