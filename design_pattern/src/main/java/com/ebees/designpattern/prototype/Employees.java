package com.ebees.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

	private List<String> empList;
	
	public Employees() {
		empList = new ArrayList<>();
	}
	
	public Employees(List<String> empList) {
		this.empList = empList;
	}
	
	public void loadData() {
		empList.add("Emp1");
		empList.add("Emp2");
	}
	
	public List<String> getEmpList() {
		return empList;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList<>();
		for(String emp : this.getEmpList()) {
			tempList.add(emp);
		}
		
		return new Employees(tempList);
	}
}
