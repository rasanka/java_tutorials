package com.ebees.designpattern.facade;

import java.sql.Connection;

public class OracleHelper {

	public static Connection getConnection() {
		return null;
	}
	
	public void generatePDFReport(String tableName, Connection con) {
		// Generate PDF
		System.out.println("Generating ORACLE PDF Report");
	}
	
	public void generateHTMLReport(String tableName, Connection con) {
		// Generate HTML
		System.out.println("Generating ORACLE HTML Report");
	}
}
