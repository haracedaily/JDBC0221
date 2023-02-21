package com.yedam.java.exam;

public class Card {

	//필드
	String cardNo;
	int validDate;
	int cvc;
	
	//생성자를 통한 필드 초기화
	Card(String cardNo, int validDate, int cvc){
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}
	//메소드
	//getter
	public String getCardNo() {
		return cardNo;
	}

	public int getValidDate() {
		return validDate;
	}

	public int getCvc() {
		return cvc;
	}
	
	//메소드 시그니처
	public void showCardInfo() {
		System.out.println("카드정보 ( Card No : "+ cardNo + ", 유효기간 : " + validDate + ", CVC : " + cvc +" )");
	}
}
