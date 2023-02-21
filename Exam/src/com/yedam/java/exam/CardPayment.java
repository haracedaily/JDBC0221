package com.yedam.java.exam;

public class CardPayment implements Payment {
	//필드
	double cardRatio;
	
	//생성자를 통한 필드 초기화
	CardPayment(double cardRatio){
		this.cardRatio = cardRatio;
	}

	//메소드 오버라이딩
	@Override
	public int online(int price) {
		return (int) (price - price * (Payment.ONLINE_PAYMENT_RATIO + cardRatio));
	}

	@Override
	public int offline(int price) {
		return (int) (price - price * (Payment.OFFLINE_PAYMENT_RATIO + cardRatio));
	}

	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보 ");
		System.out.println("온라인 결제시 총 할인율 : " + (Payment.ONLINE_PAYMENT_RATIO + cardRatio));
		System.out.println("오프라인 결제 시 총 할인율 : " + (Payment.OFFLINE_PAYMENT_RATIO + cardRatio));

	}

}
