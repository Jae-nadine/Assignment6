package com.coderscampus;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeslaSalesReport {
	
	public static void printYearlySalesReport(List<TeslaSalesData> salesData, String model) {
		System.out.println(model + "Yearly Sales Report");
		System.out.println("----------------------");
		
		Map<Integer, Integer> yearlySales = salesData.stream().collect(Collectors.groupingBy(
				data -> data.getDate().getYear(), Collectors.summingInt(TeslaSalesData::getSales)));
		yearlySales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
		TeslaSalesData bestMonth = salesData.stream().max(Comparator.comparingInt(TeslaSalesData::getSales)).orElse(null);
		TeslaSalesData worstMonth = salesData.stream().min(Comparator.comparingInt(TeslaSalesData::getSales)).orElse(null);
		
		System.out.println("The best month for " + model + " was: " + (bestMonth != null ? bestMonth.getDate() : "N/A"));
		System.out.println("The worst month for " + model + " was: " + (worstMonth != null ? worstMonth.getDate() : "N/A"));
		System.out.println();
	}

}
