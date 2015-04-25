package com.osnat.javacourse;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Stock {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	private int recomendation;
	private int stockQuantity;
	private final static int BUY= 0;
	private final static int SELL= 1;
	private final static int REMOVE= 2;
	private final static int HOLD= 3;
	
	
	DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
	
	public Stock(String symbol, float ask, float bid, Date date) {
				this.symbol = symbol;
				this.bid = bid;
				this.ask = ask;
				this.date = date;
				
			}
	
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
	
	
	public String getHtmlDescription(){
		 String StockDeatails= new String ("<b>Stock symbol  </b>:"+getSymbol()+ "<b>  Bid: </b> "+getBid()+"<b>  Ask: </b> "+getAsk()+"<b>  Date: </b> "+ df.format(getDate())+"<br>");
		 return StockDeatails;
	}
	
}
	
	


