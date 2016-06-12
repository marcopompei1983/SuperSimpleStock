package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

import entity.Stock;
import entity.StockType;
import entity.Trade;

@Stateless
public class CSuperSimpleStock implements ISuperSimpleStockLocal, ISuperSimpleStockRemote {

	// list of trade recorded
	private List<Trade> trades = new ArrayList<Trade>();

	// list of groups of stocks belonging to trades
	private Map<String, List<Stock>> stocks = new HashMap<String, List<Stock>>();

	public Double getDividendYield(Stock stock) throws Exception {

		if (stock.getTickerPrice() == 0.0f)
			throw new Exception("Division by zero has occurred");

		if (stock.getTickerPrice() < 0.0f)
			throw new Exception("TickerPrice can not be less than zero");

		// COMMON case
		if (stock.getStockType() == StockType.COMMON)
			return (stock.getLastDividend() / stock.getTickerPrice());

		// PREFERRED case
		return (stock.getFixedDividend() * stock.getParValue()) / stock.getTickerPrice();
	}

	public Double getPERatio(Stock stock) throws Exception {

		if (stock.getTickerPrice() == 0.0f)
			throw new Exception("Division by zero has occurred");

		if (stock.getTickerPrice() < 0.0f)
			throw new Exception("TickerPrice can not be less than zero");

		return (stock.getTickerPrice() / getDividendYield(stock));
	}

	public void recordingTrade(Trade trade) throws Exception {

		if (trade == null)
			throw new Exception("'trade' value can not be NULL");

		if (trade.getStock() == null)
			throw new Exception("'stock' value can not be NULL");

		if (trade.check()) {

			trades.add(trade);

			String stockSymbol = trade.getStock().getStockSymbol();

			if (!stocks.containsKey(stockSymbol)) {
				List<Stock> listStock = new ArrayList<Stock>();
				listStock.add(trade.getStock());

				stocks.put(stockSymbol, listStock);
			} else
				stocks.get(stockSymbol).add(trade.getStock());

			return;
		}

		throw new Exception("'trade' value is not compliant");
	}

	// 'rangeTime' will be < 0 every value will be enter. 0 means consider all 'Trade'
	public Double getStockPrice(String stockSymbol, Integer rangeTime) throws Exception {

		double tradePrices = 0.0;
		double shareQuantities = 0.0;

		if (rangeTime > 0)
			rangeTime = (-1) * rangeTime;

		// Get Date Format
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd-MM-yy HH.mm.ss");

		Calendar now = null;

		if (rangeTime != 0) {
			// Get at this moment
			now = Calendar.getInstance();

			// Get for 'rangeTime' minutes ago
			now.add(Calendar.MINUTE, rangeTime);
		}

		for (Trade trade : trades) {

			// which stock?
			if (trade.getStock().getStockSymbol() == stockSymbol)

				// Miss value if 'rangeTime' is != to 0 and 
				// happened before 'now'
				if (rangeTime != 0) {
					trade.getTimeStamp().before(now.getTime());
					continue;
				}

			tradePrices += (trade.getPrice() * trade.getQuantityOfShare());
			shareQuantities += trade.getQuantityOfShare();
		}

		if (shareQuantities == 0.0)
			throw new Exception("Division by zero has occurred");

		return (tradePrices / shareQuantities);
	}

	public Double getGBCEAllShareUsing() throws Exception {

		Double amount = 1.0;

		// For every type of Stock, find StockPrice and get geometricMean
		// Root has been distributed on every element trying to avoid, probably,
		// overload due by moltiply
		for (String stockKey : stocks.keySet())
			amount *= Math.pow(getStockPrice(stockKey, 0), (1 / stocks.size()));

		return amount;
	}
}
