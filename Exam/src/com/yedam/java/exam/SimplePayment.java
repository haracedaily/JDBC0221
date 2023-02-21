package com.yedam.java.exam;

public class SimplePayment implements Payment {
	//필드
	double simplePaymentRatio;

	//생성자를 통한 필드 초기화
	SimplePayment(double simplePaymentRatio){
		this.simplePaymentRatio = simplePaymentRatio;
	}

	//메소드 오버라이딩
	@Override
	public int online(int price) {
		return (int) (price - price * (Payment.ONLINE_PAYMENT_RATIO + simplePaymentRatio));
	}

	@Override
	public int offline(int price) {
		return (int) (price - price * (Payment.OFFLINE_PAYMENT_RATIO + simplePaymentRatio));
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보 ");
		System.out.println("온라인 결제시 총 할인율 : " + (Payment.ONLINE_PAYMENT_RATIO + simplePaymentRatio));
		System.out.println("오프라인 결제 시 총 할인율 : " + (Payment.OFFLINE_PAYMENT_RATIO + simplePaymentRatio));

	}

}
