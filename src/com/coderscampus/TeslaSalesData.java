package com.coderscampus;

import java.time.YearMonth;

public class TeslaSalesData {
	private YearMonth date;
	private int sales;


public TeslaSalesData (YearMonth date, int sales) {
	this.date = date;
	this.sales = sales;
}

public YearMonth getDate() {
	return date;
}

public int getSales() {
	return sales;
}

}
