package com.yedam.student;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StudentDAO extends DAO{
	
	private static StudentDAO stdDao = null;
	
	private StudentDAO() {
		
	}
	
	public static StudentDAO getInstance() {
		if(stdDao ==null) {
			stdDao = new StudentDAO();
		}
	return stdDao;
	}
	 
//	STD_ID    NOT NULL NUMBER       
//	STD_NAME  NOT NULL VARCHAR2(15) 
//	STD_MAJOR          VARCHAR2(30) 
//	STD_POINT          NUMBER(2,1)  
	//전체 조회
	public List<Student> getStudentList(){
		List<Student> list = new ArrayList<>();
		Student std = null;
		try {
			conn();
			String sql = "select * from std";
			//\r\n = \r = 윈도우에서 그전 명령문에서 벗어남? mac에서 사용 \n = 줄바꿈 mac외에 사용
			stmt = conn.createStatement();
						
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				std=new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getDouble("std_point"));
				
				list.add(std);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}

	//학번 조회
	public Student getStudent(int stdId) {
		Student std = null;
		try {
			conn();
			String sql="select * from std where std_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				std=new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getDouble("std_point"));
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return std;
	}
	
//	STD_ID    NOT NULL NUMBER       
//	STD_NAME  NOT NULL VARCHAR2(15) 
//	STD_MAJOR          VARCHAR2(30) 
//	STD_POINT          NUMBER(2,1)  
	//학생등록
	public int insertStd(Student std) {
		int result=0;
		try {
			conn();
		String sql = "insert into std values(?,?,?,?)";
		//insert into std values(nvl((select count(*) from std),0)+1,?,?,?)
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, std.getStdId());
		pstmt.setString(2, std.getStdName());
		pstmt.setString(3, std.getStdMajor());
		pstmt.setDouble(4, std.getStdPoint());
		
		result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
		
	}
	
	//제적
	public int deleteStd(int stdId) {
		int result =0;
		try {
			conn();
			String sql = "delete from std where std_id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//전공변경
	public int updateStd(Student std) {
		int result =0;
		try {
			conn();
			String sql = "update std set std_major=? where std_id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, std.getStdMajor());
			pstmt.setInt(2, std.getStdId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//전공별 성적 합계, 평균
	public List<Student> getAnalyze(){
		List<Student> list = new ArrayList<>();
		Student std = null;
		try {
			conn();
			String sql = "select std_major,sum(std_point) 총점, avg(std_point) 평균\r\n"
					+"from std\r\n"
					+"group by std_major";
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				std = new Student();
				std.setStdMajor(rs.getString("std_major"));
				std.setStdSum(rs.getDouble("총점"));
				std.setStdAvg(rs.getDouble("평균"));
				
				list.add(std);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
}
