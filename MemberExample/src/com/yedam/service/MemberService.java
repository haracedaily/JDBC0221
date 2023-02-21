package com.yedam.service;

import java.util.Scanner;

public class MemberService {
	Scanner sc = new Scanner(System.in);
	//member의 정보를 자바 전역에 공유하기 위해서 static
	//1. memberInfo -> null이 아니다 or null이다.
	//null -> O 로그인 안된 상태
	//null -> X 로그인 된 상태
	
	public static Member memberInfo = null;
	//=Member memberInfo=new Member();
	
	//1.로그인
	public void login() {
		Member member =null;
		System.out.println("ID>");
		String memberId=sc.nextLine();
		System.out.println("PW>");
		String memberPw=sc.nextLine();
		
		member = MemberDAO.getInstance().login(memberId);
		
		
		//id를 통해서 회원 정보를 조회하고, 조회 된 결과에 따라서 login 여부를 결정
		//1.id를 통해 조회가 되었다. -> 회원 정보가 존재
		//2. 따라서 입력한 비밀번호와 회원 정보에서 비밀번호가 동일하면 로그인진행
		//memberInfo에 조회된 회원 정보 대입
		
		//2-1. 비밀번호가 다를 경우 로그인 실패
		//1-1. 회원아이디로 조회되는 정보가 없다-> 로그인 실패
		//memberInfo는 null상태 그대로<
		
		if(member !=null) {
			if(member.getMemberPw().equals(memberPw)) {
			System.out.println("로그인 성공");
			System.out.println(member.getMemberId()+"님 환영합니다.");
			memberInfo = member;
			}else{
				System.out.println("비밀번호가 다릅니다.");
			}
		}else {
			System.out.println("회원 아이디가 존재하지 않습니다.");
		}
	}

	//회원정보 조회
	public void getMember() {
		Member member = MemberDAO.getInstance().getMember();
		System.out.println(member.toString());
	}
	
	//회원정보 수정
	public void modifyMember() {
		System.out.println("연락처>");
		Member member = new Member();
		member.setMemberPhone(sc.nextLine());
		System.out.println("회원ID>");
		member.setMemberId(sc.nextLine());
		
		
		int result = MemberDAO.getInstance().modifyMember(member);
		
		if(result>0) {
			System.out.println("연락처 수정 완료");
		}else {
			System.out.println("연락처 수정 실패");
		}
	}
	//회원 탈퇴
	public void deleteMember() {
		System.out.println("회원ID>");
		int result = MemberDAO.getInstance().deleteMember(sc.nextLine());
		
		//자신의 ID를 넣었다.
		//로그인 되어 있는 상태에서 회원 탈퇴 -> 로그아웃.
		if(result>0) {
			memberInfo = null;
			System.out.println("회원 ID 삭제 완료");
		}else {
			System.out.println("회원 ID 삭제 실패");
		}
	}
	
	public void logout() {
		memberInfo=null;
	}
	
}
