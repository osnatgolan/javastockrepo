package com.osnat.javacourse;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Stock {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
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
	
	
	public String getHtmlDescription(){
		 String StockDeatails= new String ("<b>Stock symbol  </b>:"+getSymbol()+ "<b>  Bid: </b> "+getBid()+"<b>  Ask: </b> "+getAsk()+"<b>  Date: </b> "+ df.format(getDate())+"<br>");
		 return StockDeatails;
	}
	
}
	
	


