package com.yedam.student;


import java.util.List;
import java.util.Scanner;

public class StudentService {
	Scanner sc = new Scanner(System.in);

	//전체 학생 조회
	public void getStudentList() {
		List<Student> list = StudentDAO.getInstance().getStudentList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());//Generate에서 toString구문 사용하면 전체 출력 수월해짐
		}
		
	}
	
	
	//학번 조회
	public void getStudent() {
		int stdNo=0;
		System.out.println("학번 입력>");
		stdNo=Integer.parseInt(sc.nextLine());
		Student std = StudentDAO.getInstance().getStudent(stdNo);
		
		System.out.println(std.toString());
		
	}
	
//	STD_ID    NOT NULL NUMBER       
//	STD_NAME  NOT NULL VARCHAR2(15) 
//	STD_MAJOR          VARCHAR2(30) 
//	STD_POINT          NUMBER(2,1)  

	//등록
	public void insertStd() {
		Student std = new Student();
		System.out.println("=== 신규 등록 ===");
		System.out.println("학번 입력 >");
		std.setStdId(Integer.parseInt(sc.nextLine()));
		System.out.println("이름 입력 >");
		std.setStdName(sc.nextLine());
		System.out.println("전공 입력 > ");
		std.setStdMajor(sc.nextLine());
		System.out.println("점수 입력>");
		std.setStdPoint(sc.nextDouble());
		int result = StudentDAO.getInstance().insertStd(std);
		if(result>0) {
			System.out.println("신규등록 성공");
		}else {
			System.out.println("신규등록 실패");
		}
		
//		System.out.println("");
	}
	
	//제적
	public void deleteStd() {
		System.out.println("=== 제적 학생 ===");
		System.out.println("학번 입력 > ");
		int stdNo = Integer.parseInt(sc.nextLine());
		int result=StudentDAO.getInstance().deleteStd(stdNo);
		
		if(result>0) {
			System.out.println("학생 삭제 성공");
		}else {
			System.out.println("학생 삭제 실패");
		}
		
	}
	
	//전공변경
	public void updateStd() {
		Student std = new Student();
		System.out.println("=== 전공 변경 ===");
		System.out.println("전과할 전공 입력 >");
		String major=sc.nextLine();
		System.out.println("전과할 학생 학번 입력 > ");
		int stdNo=Integer.parseInt(sc.nextLine());
		std.setStdMajor(major);
		std.setStdId(stdNo);
		
		int result = StudentDAO.getInstance().updateStd(std);
		if(result>0) {
			System.out.println("전공 변경 성공");
		}else {
			System.out.println("전공 변경 실패");
		}
	}
	
	//점수 구하기
	public void getAnalyze() {
		List<Student> list = StudentDAO.getInstance().getAnalyze();
		
		for(int i=0;i<list.size();i++) {
			System.out.println("===전공별 점수===");
			System.out.println("전공명 : "+list.get(i).getStdMajor());
			System.out.println("합  계 : "+list.get(i).getStdSum());
			System.out.println("평  균 : "+list.get(i).getStdAvg());
			System.out.println("인  원 : "+(int)(list.get(i).getStdSum()/list.get(i).getStdAvg())+"명");
		}
		
	}
	
	
}
