package com.yedam.exam;

public class Exam01 {
	public static void main(String[] args) {
		// 1. 두개 변수, 사칙연산을 활용한 정수 출력
		int num1 = 10;
		double num2 = 2.0;

		System.out.println((int) (num1 + num2));
		System.out.println((int) (num1 - num2));
		System.out.println((int) (num1 * num2));
		System.out.println((int) (num1 / num2));

		// 2. 비교연산자의 결과 적어 제출
		// 10과 20에 대해서 같은지 다른지, 논리부정연산자

		// 3. 주어진 금액 -> 동전으로 바꾸었을때 몇개 필요한지
		// 500,100,50,10 -> 0:500, 1:100, 2:50, 3:10
		int[] coinUnit = new int[4];
		int money = 2680;
		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			// 1. 제일 큰 금액부터 차감
			// 2680 -> 500원 몇개 있는지 -> 남은 금액에 대해서
			// 100원 몇개 있는지 -> 남은 금액에 대해서....
			if (money > 500) {
				// 몫이면서 500원짜리의 갯수
				coinUnit[i] = money / 500;
				money = money - (coinUnit[i] * 500);
				System.out.println("500원 : " + coinUnit[i] + "개");
				// money = 180 if문 내에서만 180이 아니라 for문에서 180?
			} else if (money > 100) {
				// 몫이 100원짜리의 갯수
				coinUnit[i] = money / 100;
				money = money - (coinUnit[i] * 100);
				System.out.println("100원 : " + coinUnit[i] + "개");
			} else if (money > 50) {
				// 몫이 50원짜리의 갯수
				coinUnit[i] = money / 50;
				money = money - (coinUnit[i] * 50);
				System.out.println("50원 : " + coinUnit[i] + "개");
			} else if (money > 10) {
				// 몫이 10원짜리의 갯수
				coinUnit[i] = money / 10;
				money = money - (coinUnit[i] * 10);
				System.out.println("10원 : " + coinUnit[i] + "개");
			}
		}
		
		// 4. 5단 -> 5*1 ~ 5*5
		// 8단 -> 8*1 ~ 8*8
		// 2~9단까지 진행하는 반복문
		for (int m = 2; m <= 9; m++) {
			System.out.println("***"+m+"단***");
			for (int n = 1; n <= m; n++) {
				System.out.print(m+" * "+n+" = " + (m*n) + "\t");
			}
			System.out.println();
		}
	}
}
