package com.osnat.javacourse.model;

import java.util.Date;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.osnat.*;
import com.osnat.javacourse.exception.BalanceException;
import com.osnat.javacourse.exception.PortfolioFullException;
import com.osnat.javacourse.exception.StockAlreadyExistsException;
import com.osnat.javacourse.exception.StockNotExistException;
import com.osnat.javacourse.model.Stock.ALGO_RECOMMENDATION;

public class Portfolio implements PortfolioInterface{
	
	String title;
	private final static int MAX_PORTFOLIO_SIZE=5;
	private StockInterface[] stocks;
    int portfolioSize=0;
    
    private float balance;
    
    
    
    public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	//getters and Setters
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public StockInterface[] getStocks() {
		return stocks;
	}


	/*public void setStocks(StockInterface[] stocks) {
		this.stocks = stocks;
	}*/
	
	public void setStocks(StockInterface[] stocks) {
		this.stocks = stocks;
	}
	

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	

	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}

//empty constructor
	public Portfolio (){
		stocks = new Stock [MAX_PORTFOLIO_SIZE];

 	}
	
//constructor that gets stockaray
	
	public Portfolio(Stock[] stockArray){
		// TODO Auto-generated constructor stub
		this();
		this.title= new String();
		this.portfolioSize=stockArray.length;
		this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
		this.balance=0;
		for(int i = 0; i<this.portfolioSize; i++){
 			this.stocks[i]= new Stock ((Stock)stockArray[i]);
		}
	}
		

	//Copy constructor
	public Portfolio(Portfolio portfolio)throws StockNotExistException, StockAlreadyExistsException, BalanceException, PortfolioFullException{
	
		this.setTitle(portfolio.getTitle());
		setPortfolioSize(portfolio.getPortfolioSize());
		setBalance(portfolio.getBalance());
		
		this.setStocks(portfolio.stocks);
		
		for(int i=0; i<portfolio.getPortfolioSize(); i++){
			//stocks[i]= new Stock(portfolio.getStock()[i]);	
			Stock tmp = new Stock(((Stock)portfolio.stocks[i]));
			this.addStock(tmp);
		}
		
	}
	
	//Constructor
/*	public Portfolio(String title){
		
		this();
		this.stocks= new Stock[MAX_PORTFOLIO_SIZE];
		this.title= title;
		this.portfolioSize=0;
		this.balance=0;
	}*/
	
	

	
	
	public void updateBalance(float amount) throws BalanceException{
		
			this.balance+=amount;
			
			if(this.balance<0)
			{
				throw new BalanceException();
			}
	}
	
	
	public void addStock(Stock stk) throws PortfolioFullException, StockAlreadyExistsException{
		
		if(this.portfolioSize== MAX_PORTFOLIO_SIZE){
			throw new PortfolioFullException(MAX_PORTFOLIO_SIZE);
		}
		
		else if (stk==null){
			System.out.println("“ERROR!- NULL sock received!”");
			 return;
		}
		else{
			for(int i=0; i<this.portfolioSize; i++)
			{
				if(stk.getSymbol().equals(this.stocks[i].getSymbol()))
				{
					throw new StockAlreadyExistsException(stk.getSymbol());
				}
			}
			
			this.stocks[this.portfolioSize]=stk;
			((Stock)stocks[this.portfolioSize]).setStockQuantity(0);
			this.portfolioSize++;
			return;
			
		}
	}
	
	

	public StockInterface[] getStock(){
		return this.stocks;
	}
	
	public String getHtmlString(/*Portfolio portfolio*/){
		
		String str= new String("<br>"+"<h>"+ this.title +"<h>"+ "<br/>");
		
		for(int i=0; i<this.portfolioSize; i++){
			str=str+ ((Stock)this.stocks[i]).getHtmlDescription();
		}
		
		str+= "<br>"+"<h>"+"Total Portfolio Value :"+"<h>"+this.getTotalValue()+ "$.<br>"+"<h>"+"Total Stocks Value :"+"<h>"+this.getStocksValue()+"$. <br>"+"<h>"+"Balance :"+"<h>"+this.balance+"$.";
		
		return str;
	}
	

	
	public void removeStock(String symbol) throws StockAlreadyExistsException, StockNotExistException, PortfolioFullException, BalanceException{
		boolean res=false;
		
		for(int i=0; i < portfolioSize; i++)
		{
			if(this.stocks[i].getSymbol().equals(symbol)==true)
			{
				this.sellStock(this.stocks[i].getSymbol(), -1);
				
				//set stock reference at i to null
				
				//move last stock in array (if found) to i location.
				
				if(i != portfolioSize-1 && portfolioSize > 1){
					this.stocks[i]=null;
					this.stocks[i] = new Stock(((Stock)this.stocks[portfolioSize-1]));
				}
				else{
					this.stocks[i]=null;
				}
					
			res=true;
			}
		}
		
		if(res=true){
			this.portfolioSize--;
			
		}
		
		else{
			throw new StockNotExistException(symbol);
		}
		return;
		//return res;
	}

	
	
	
	public void sellStock(String symbol, int quantity) throws StockNotExistException, BalanceException{
		
		if(symbol==null || quantity <-1)
		{
			throw new StockNotExistException(symbol);
			//return false;
		}
		
		for(int i=0; i<this.portfolioSize; i++){
			
			if(this.stocks[i].getSymbol().equals(symbol)== true){
				
				if(((Stock)this.stocks[i]).getStockQuantity()-quantity <0 ){
					System.out.println("Not enough stocks to sell!!”"+"<br>");
					//return false;
				}
				
				else if (quantity==-1){
					this.balance+= ((Stock)this.stocks[i]).getStockQuantity() * ((Stock)this.stocks[i]).getBid();
					((Stock)this.stocks[i]).setStockQuantity(0);
					((Stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.SELL);
					System.out.println("The whole stock "+ symbol +" holdings was sold succefully"+"<br>");
					return;
				    //return  true;
				}
				
				else{
					this.balance+= quantity * this.stocks[i].getBid();
					((Stock)this.stocks[i]).setStockQuantity(((Stock)this.stocks[i]).getStockQuantity()-quantity);
					((Stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.SELL);
					System.out.println("Stock "+ symbol +" "+quantity+" holdings was sold succefully"+"<br>");
					return;
				    //return  true;
				}
				
			}
		}
		throw new StockNotExistException(symbol);
		//return false; 
	}
	
	
	
	
	public void buyStock(Stock stock, int quantity) throws StockNotExistException, BalanceException, PortfolioFullException, StockAlreadyExistsException{
		
		int howManyToBuy=0;

		if(stock==null || quantity <-1)
		{
			throw new StockNotExistException(stock.getSymbol());
			//System.out.println("ERROR! Please chack the stock you wish to buy or the quantity entered!"+"<br>");
			//return false;
			
		}
		
		if( stock.getAsk()* quantity > this.balance){
			throw new BalanceException();
			//System.out.println("ERROR! Not enough balance to process the purchas!"+"<br>");
			//return ;
		}
		
		for(int i=0; i<this.portfolioSize; i++){
			
			if (this.stocks[i].getSymbol().equals(stock.getSymbol())){
				
				if(quantity==-1){
					 howManyToBuy= (int)this.balance/ (int)this.stocks[i].getAsk();
					 //this.balance-= howManyToBuy * this.stocks[i].getAsk();
					 this.updateBalance(-(howManyToBuy * this.stocks[i].getAsk()));
					 ((Stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.BUY);
					 ((Stock)this.stocks[i]).setStockQuantity(((Stock)this.stocks[i]).getStockQuantity() + howManyToBuy);
					 System.out.println("You bought the whole holdings for stock "+stock.getSymbol()+" seccsesfully! "+"<br>");
					 return;
					 //return true;
				}
				
				if(quantity>0)
				{
					this.balance-= quantity * this.stocks[i].getAsk();
					//this.updateBalance(-(quantity * this.stocks[i].getAsk()));
					((Stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.BUY);
					((Stock)this.stocks[i]).setStockQuantity(((Stock)this.stocks[i]).getStockQuantity() + quantity);
					 System.out.println("You bought the requested holding for stock "+stock.getSymbol()+" seccsesfully! "+"<br>");
					 return;
					 //return true;
				}
			}
		}
		
		addStock(stock);
		//this.balance-=this.stocks[this.portfolioSize-1].getAsk()*quantity;
		this.updateBalance(- (float)(this.stocks[this.portfolioSize-1].getAsk()*quantity));
		((Stock)this.stocks[this.portfolioSize-1]).setStockQuantity( quantity);
		System.out.println("The requested  stock "+stock.getSymbol()+" was added to the Portfolio seccsesfully! "+"<br>");
		return;
		 //return true;
		
	}
	
	
	public float getStocksValue(){
		
		float total = 0;
		
		for (int i=0; i<this.portfolioSize; i++){
			
			total += this.stocks[i].getBid() * ((Stock)this.stocks[i]).getStockQuantity() ;
		}
		return total;
	}
	

	public float getTotalValue(){
		
		return this.getStocksValue() + this.getBalance();
	}
	
	//this function finds stock in the array, returns NULL in case the stock does not exist
	public StockInterface findStock(String stockSymbol){
		
		for(int i=0; i<this.portfolioSize; i++)
		{
			if(getStocks()[i].getSymbol().equals(stockSymbol)){
				return this.getStocks()[i];
			}
		}
		
		return null;
		
	}
	
}
