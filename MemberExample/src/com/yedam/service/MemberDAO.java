package com.yedam.service;

import com.yedam.common.DAO;

public class MemberDAO extends DAO{
	
	//싱글톤
	private static MemberDAO mDao = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	//필드에서 싱글톤이 항상 새 객체 생성을 해줘서 그냥 리턴 가능
	public static MemberDAO getInstance() {
		return mDao;
	}
	
	
	//1.로그인 기능
	public Member login(String id) {
		Member mem =null;
		try {
			conn();
			String sql="select * from member where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberPhone(rs.getString("member_phone"));
				mem.setMemberAddr(rs.getString("member_addr"));
				mem.setMemberGrade(rs.getString("member_grade"));
			}
		}catch(Exception e) {
		e.printStackTrace();
		}finally {
			disconn();
		}
		return mem;
	}
	
	public Member getMember() {
		Member member =null;
		try {
			conn();
			String sql = "select * from member where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberGrade(rs.getString("member_grade"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	public int modifyMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql ="update member\r\n"
					+ "set member_phone = ?\r\n"
					+ "where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPhone());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	public int deleteMember(String memId) {
		int result=0;
		try {
			conn();
			String sql = "delete from member where member_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
