package databaseconnection.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getDataFromDatabase {

	public static void main(String[] args) throws SQLException, IOException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
		Statement stmt = con.createStatement();
		String s = "select * from customerinfo limit 1";
		ResultSet rs = stmt.executeQuery(s);
		while (rs.next()) {
			String Bookname = rs.getString("BookName");
			String purchasedate = rs.getString("purchasedDate");
			int amount = rs.getInt("Amount");
			String location = rs.getString("Location");

			System.out.println(Bookname + " " + purchasedate + " " + amount + " " + location);

		}
		con.close();
		/*
		 * read data from excel file
		 */
		File excelFile = new File("c:\\selenium\\data.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("data from excel is:  " + data0);

	}

}
