package entity;

import java.io.Serializable;
import java.util.Date;

public class Trade implements Serializable {
	
	/**
	 * Automatic serialVersionUID generated
	 */
	private static final long serialVersionUID = -2436694200269838442L;
	
	private Date timeStamp;
	private Integer quantityOfShare;
	private Indicator indicator;
	private Double price;
	private Stock stock;
	
	public boolean check()
	{
		if(quantityOfShare <= 0)
			return false;
		
		if(price <= 0)
			return false;
		
		if(stock == null)
			return false;
		
		return stock.check();
	}
	
	public Trade()
	{
		timeStamp = new Date();
		quantityOfShare = 0;
		indicator = Indicator.BUY;
		price = 0.0;
		stock = new Stock();
	}
	
	public Trade(Date timeStamp, Integer quantityOfShare, 
			Indicator indicator, Double price, Stock stock)
	{
		this.timeStamp = timeStamp;
		this.quantityOfShare = quantityOfShare;
		this.indicator = indicator;
		this.price = price;
		this.stock = stock;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getQuantityOfShare() {
		return quantityOfShare;
	}

	public void setQuantityOfShare(Integer quantityOfShare) {
		this.quantityOfShare = quantityOfShare;
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
