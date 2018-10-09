package com.ebees.designpattern.facade;

import java.sql.Connection;

public class HelperFacade {

	public static enum DBTypes {
		MYSQL, ORACLE;
	}
	
	public enum ReportTypes {
		HTML, PDF;
	}
	
	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
		Connection con = null;
		switch (dbType) {
		case MYSQL : 
			con = MySQLHelper.getConnection();
			MySQLHelper mHelper = new MySQLHelper();
			switch (reportType) {
			case PDF : 
				mHelper.generatePDFReport(tableName, con);
				break;
			case HTML : 
				mHelper.generateHTMLReport(tableName, con);
				break;
			}
			break;
		case ORACLE : 
			con = OracleHelper.getConnection();
			OracleHelper oHelper = new OracleHelper();
			switch (reportType) {
			case PDF : 
				oHelper.generatePDFReport(tableName, con);
				break;
			case HTML : 
				oHelper.generateHTMLReport(tableName, con);
				break;
			}
			break;
		}
	}
}
