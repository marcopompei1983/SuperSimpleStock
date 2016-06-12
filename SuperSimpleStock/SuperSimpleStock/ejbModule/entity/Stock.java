package entity;

import java.io.Serializable;

public class Stock implements Serializable{

	/**
	 * Automatic serialVersionUID generated
	 */
	private static final long serialVersionUID = 5371760452556603094L;
	
	private String stockSymbol;
	private StockType stockType;
	private Integer lastDividend;
	private Integer fixedDividend;
	private Integer parValue;
	private Double tickerPrice;
	
	public boolean check()
	{
		if(stockSymbol == "" || stockSymbol == null)
			return false;
		
		if(lastDividend < 0)
			return false;
		
		if(fixedDividend < 0)
			return false;
		
		if(parValue < 0)
			return false;
		
		return true;
	}
	
	public Stock()
	{
		stockSymbol = "";
		stockType = StockType.COMMON;
		lastDividend = 0;
		fixedDividend = 0;
		parValue = 0;
		tickerPrice = 0.0;
	}
	
	public Stock(String stockSymbol, StockType stockType, 
			Integer lastDividend, Integer fixedDividend, 
			Integer parValue, Double tickerPrice, Trade trade)
	{
		this.stockSymbol = stockSymbol;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.tickerPrice = tickerPrice;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public Integer getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Integer lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Integer getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Integer fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Integer getParValue() {
		return parValue;
	}

	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}
	
	public Double getTickerPrice() {
		return tickerPrice;
	}

	public void setTickerPrice(Double tickerPrice) {
		this.tickerPrice = tickerPrice;
	}
}
