package com.yedam.java.exam;

public class GenderExample {

	public static void main(String[] args) {
		String[] arr = {"010102-4", "991012-1", "960304-1", "881012-2", "040403-3"};
		genderStr1(arr);
		genderStr2(arr);
	}
	
	//String API 두가지 방법
	public static void genderStr1(String[] arr) {
		int male = 0;
		int female = 0;
		
		for(String person : arr) {
			char gender = person.charAt(7);
			switch(gender) {
			case '1':
			case '3':
				male++;
				break;
			case '2':
			case '4':
				female++;
				break;
			}
		}
		
		System.out.println("남 " + male + " 여 " + female);
	}
	//"010102-4"
	public static void genderStr2(String[] arr) {
		int male = 0;
		int female = 0;
//		String[] arr = {"010102-4", "991012-1", "960304-1", "881012-2", "040403-3"};
		for(int i=0; i<arr.length; i++) {
			
			String gender = arr[i].substring(7);
			
			if(gender.equals("1") || gender.equals("3"))
				male++;
			else
				female++;
		}
		System.out.println("남 " + male + " 여 " + female);
	}
	
}
