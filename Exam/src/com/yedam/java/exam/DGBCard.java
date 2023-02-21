package com.yedam.java.exam;

public class DGBCard extends Card {
	//필드
	String company;
	String cardStaff;
	
	//생성자를 통한 필드 초기화
	DGBCard(String cardNo, int validDate, int cvc, String cardStaff){
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
		this.company = "대구은행";
	}

	//메소드 시그니처 오버라이딩
	@Override
	public void showCardInfo() {
		super.showCardInfo();
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}
}
