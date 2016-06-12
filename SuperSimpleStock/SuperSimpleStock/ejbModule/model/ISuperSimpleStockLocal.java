package model;

import javax.ejb.Local;

import entity.Stock;
import entity.Trade;

@Local
public interface ISuperSimpleStockLocal {

	public Double getDividendYield(Stock stock) throws Exception;
	public Double getPERatio(Stock stock) throws Exception;
	public void recordingTrade(Trade trade) throws Exception;
	public Double getStockPrice(String stockSymbol, Integer rangeTime) throws Exception;
	public Double getGBCEAllShareUsing() throws Exception;
};
