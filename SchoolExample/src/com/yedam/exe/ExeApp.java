package com.yedam.exe;

import java.util.Scanner;

import com.yedam.student.StudentService;

public class ExeApp {
	
	
	private String menu = null;
	private Scanner sc = new Scanner(System.in);
	private StudentService ss = new StudentService();
	
	public void run() {
		
		while(true) {
			menu();
			
			if(menu.equals("1")) {
				//전체 학생 조회
				ss.getStudentList();
			}else if(menu.equals("2")) {
				//학번 조회
				ss.getStudent();
			}else if(menu.equals("3")) {
				//등록
				ss.insertStd();
			}else if(menu.equals("4")) {
				//제적
				ss.deleteStd();
			}else if(menu.equals("5")) {
				//전공변경
				ss.updateStd();
			}else if(menu.equals("6")) {
				ss.getAnalyze();
			}else {
				System.out.println("end of program");
			break;
			}
		}
	}
	
	private void menu() {
		//학생 정보 조회, 학생 등록, 제적, 전공 변경, 종료
		System.out.println("1. 전체 학생 조회 | 2. 학번 조회 | 3. 학생 등록 | 4. 제적 | 5. 전공 변경 | 6. 종료");
		System.out.println("입력>");
		menu = sc.nextLine();
	}
	
	
	
}
