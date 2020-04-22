package com.dinesh.testng.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ExtentReportsParser {

	public static void main(String[] args) throws IOException {

		String reportLocation = "C:\\\\Dinesh\\";
		List<String> reportNameList = new ArrayList<String>();
		reportNameList.add("ExtentReport1.html");
		reportNameList.add("ExtentReport2.html");

		StringBuilder excelOutputFileName = new StringBuilder();
		excelOutputFileName.append("C:\\Dinesh\\ExecutionSummary_");
		excelOutputFileName.append(getTimeStamp());
		excelOutputFileName.append(".xlsx");

		Map<String, String> resultsMap = new HashMap<String, String>();

		for (String reportName : reportNameList) {
			Document doc = Jsoup.parse(new File(reportLocation.concat(reportName)), "utf-8");
			Elements ul = doc.select("div.wrapper > ul");
			Elements li = ul.select("li");

			for (int i = 0; i < li.size(); i++) {
				Elements spans = li.get(i).select("div > span");
				resultsMap.put(spans.get(0).text(), spans.get(1).text());
			}
		}
System.out.println("resultsMap "+resultsMap.toString());
		ExcelUtil.writeResults(resultsMap, excelOutputFileName.toString());
	}

	public static String getTimeStamp() {
		DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		String timeStamp = format.format(new Date());
		return timeStamp;
	}

}
