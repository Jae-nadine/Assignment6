package com.coderscampus;

import java.io.BufferedReader;

import java.time.YearMonth;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TeslaSalesApp {
	
	private static List<TeslaSalesData> readSalesData(String filePath) {
		List<TeslaSalesData> salesDataList = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			String line;
			br.readLine();
			
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				
				YearMonth date = YearMonth.parse(data[0], formatter);
				int sales = Integer.parseInt(data[1]);
				salesDataList.add(new TeslaSalesData(date, sales));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return salesDataList;
	}

	public static void main(String[] args) {
		
		String model3Path = "model3.csv";
		String modelSPath = "modelS.csv";
		String modelXPath = "modelX.csv";
		
		FileService fileService = new FileService();
		
		List<TeslaSalesData> model3Sales = readSalesData(model3Path);
		List<TeslaSalesData> modelSSales = readSalesData(modelSPath);
		List<TeslaSalesData> modelXSales = readSalesData(modelXPath);
		
		TeslaSalesReport.printYearlySalesReport(model3Sales, "Model 3");
		TeslaSalesReport.printYearlySalesReport(modelSSales, "Model S");
		TeslaSalesReport.printYearlySalesReport(modelXSales, "Model X");
		

	}

}
