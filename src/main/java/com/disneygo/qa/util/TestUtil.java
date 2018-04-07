package com.disneygo.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.disneygo.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITLY_WAIT=10;
	public static String TESTDATA_SHEET_PATH = "/Users/deepamohan/eclipse-workspace/DisneyGoTest"
			+ "/src/main/java/com/disneygo/qa/testdata/DisneyGoTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void SwitchToFrame() {
		driver.switchTo().frame("__bkframe");
	}
	
public static void verifyLink(String urlLink) {
        //Sometimes we may face exception "java.net.MalformedURLException". 
	//Keep the code in try catch block to continue the broken link analysis
        try {
 //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
 URL link = new URL(urlLink);
 // Create a connection using URL object (i.e., link)
 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
 //Set the timeout for 2 seconds
 httpConn.setConnectTimeout(2000);
 //connect using connect method
 httpConn.connect();
 //use getResponseCode() to get the response code. 
 if(httpConn.getResponseCode()== 200) { 
 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
 }
 if(httpConn.getResponseCode()== 404) {
 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
 }
 }
 //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
 catch (Exception e) {
 //e.printStackTrace();
 }
	}

public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}

public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
	}

}
