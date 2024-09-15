package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileService {

    public List<TeslaSalesData> readSalesData(String filePath) {
        List<TeslaSalesData> salesDataList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); // Skip header

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
}