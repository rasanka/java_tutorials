package com.ebees.designpattern.facade;

import com.ebees.designpattern.facade.HelperFacade.DBTypes;
import com.ebees.designpattern.facade.HelperFacade.ReportTypes;

public class FacadeTest {

	public static void main(String args[]) {
		String tableName = "EMPLOYEE";
		
		HelperFacade.generateReport(DBTypes.MYSQL, ReportTypes.PDF, tableName);
		HelperFacade.generateReport(DBTypes.ORACLE, ReportTypes.HTML, tableName);
	}
}
