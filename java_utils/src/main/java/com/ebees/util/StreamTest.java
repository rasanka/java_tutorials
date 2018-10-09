package com.ebees.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class StreamTest {

	public static void main(String args[]) {
		
		StreamTest.TestDto T1 = new StreamTest().new TestDto("1","facebook","upper-bound","T1",100);
		StreamTest.TestDto T2 = new StreamTest().new TestDto("2","facebook","lower-bound","T2",50);
		
		StreamTest.TestDto T3 = new StreamTest().new TestDto("1","linkedin","upper-bound","T1",100);
		StreamTest.TestDto T4 = new StreamTest().new TestDto("2","linkedin","lower-bound","T2",50);
		
		StreamTest.TestDto T5 = new StreamTest().new TestDto("1","twitter","upper-bound","T1",100);
		StreamTest.TestDto T6 = new StreamTest().new TestDto("2","twitter","lower-bound","T2",50);
		
		List<TestDto> list = new ArrayList<>();
		list.add(T1);
		list.add(T2);
		
		list.add(T3);
		list.add(T4);
		
		list.add(T5);
		list.add(T6);
		
		System.out.println(validateAlerts(list));
		
	}
	
	private static boolean validateAlerts(List<TestDto> settingsList) {
		
		Map<String, List<TestDto>> settingsMap = settingsList.stream().collect(Collectors.groupingBy(TestDto::getAppKey, Collectors.toList()));
		
		for (Map.Entry<String, List<TestDto>> pair : settingsMap.entrySet()) {
			System.out.println(" KEY - "+pair.getKey());
			System.out.println(" VAL - "+pair.getValue());
			
			Optional<TestDto> upperData = pair.getValue().stream().filter(a -> a.getTriggerType().equals("upper-bound")).findFirst();
			Optional<TestDto> lowerData = pair.getValue().stream().filter(a -> a.getTriggerType().equals("lower-bound")).findFirst();
			
			if(upperData.isPresent() && lowerData.isPresent()) {
				System.out.println("VALIDATING - "+pair.getKey());
				if((upperData.get().getThreshold() < lowerData.get().getThreshold())) {
					return false;
				}
			}
		}
			
		return true;
	}
	
	
	
	class TestDto {
		String id;
		String appKey;
		String triggerType;
		String name;
		double threshold;
		
		public TestDto(String id, String appKey, String triggerType, String name, double threshold) {
			super();
			this.id = id;
			this.appKey = appKey;
			this.triggerType = triggerType;
			this.name = name;
			this.threshold = threshold;
		}
		public String getAppKey() {
			return appKey;
		}
		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}
		public double getThreshold() {
			return threshold;
		}
		public void setThreshold(double threshold) {
			this.threshold = threshold;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTriggerType() {
			return triggerType;
		}
		public void setTriggerType(String triggerType) {
			this.triggerType = triggerType;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}

