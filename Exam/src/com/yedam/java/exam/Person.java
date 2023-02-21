package com.yedam.java.exam;

public class Person {
	
	//접근제한자 default 필드
	//주민등록번호
	String ssn;
	//이름
	String name;
	//주소
	String address;
	
	//기본 생성자
	Person() {}
	
	// 생성자를 통한 필드 초기화
	Person(String ssn, String name, String address){
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	//메소드
	//getter setter
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
