package com.ebees.designpattern.prototype;

import java.util.List;

public class PrototypeTest {

	public static void main(String args[]) throws CloneNotSupportedException {
		Employees empObj = new Employees();
		empObj.loadData();
		
		Employees empObj1 = (Employees) empObj.clone();
		Employees empObj2 = (Employees) empObj.clone();
		
		List<String> empList1 = empObj1.getEmpList();
		empList1.add("Rasa");
		
		List<String> empList2 = empObj2.getEmpList();
		empList2.add("Dil");
		
		System.out.println(empObj.getEmpList());
		System.out.println(empList1);
		System.out.println(empList2);
	}
}
