package com.yedam.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	//DAO -> Data Access Object
	//Java<-> DB 연결할 때 쓰는 객체
	//JDBC를 통해서 JAVA<-> DB가 연결 한다.
	//OJDBC<- 오라클사에서 제공해주는 JDBC;를 사용
	
	//사용할 객체 4가지
	//1. Java-> DB 연결할 때 쓰는 객체(Connection)
	protected Connection conn = null;
	
	//2. Query문(SQL)을 가지고 해당 질의문 실행하는 객체
	protected PreparedStatement pstmt = null;
	
	//3. Query문(SQL)을 가지고 해당 질의문 실행하는 객체
	protected Statement stmt=null;
	
	//4. Select(조회) 결과 값을 반환 받는 객체 <- 즉 데이터 넘겨 받을 객체
	protected ResultSet rs = null;
	
	//JAVA->연결(conn)->Select(조회)->결과값(ResultSet)
	//해제할땐 역순
	
	//hr 계정 접속[DB에 연결할 구문]
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String id = "hr";
//	String pw = "hr";
	//chatGPT>>? 성인 인증 무엇
	Properties pro=new Properties();
	String driver = null;
	String url = null;
	String id = null;
	String pw = null;
	
	
	//DB연결메소드
	public void conn() {
		try {
			//db.properties의 정보 loading
			getProperties();
			//1.드라이버 로딩
			Class.forName(driver);
			//2.DB연결
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//DB 연결 해제 [conn 끊었을 경우 쿼리문 휴지상태->충돌위험]
	public void disconn() {
		try {
		if(rs !=null) {
			rs.close();
		}
		if(stmt !=null) {
			stmt.close();
		}
		if(pstmt !=null) {
			pstmt.close();
		}
		if(conn !=null) {
			conn.close();
		}
	}catch(Exception e) {
			e.printStackTrace();
	}
}
	

	//DB 접속 정보 호출 메소드
	//1.프로그램 안에 DB 관련 정보를 넣지 않기 위해서
	//2.프로그램 실행 중 DB가 변경이 된다면.. 원래 프로그램 껐다가 내용 수정 후 켜야하는데..
	//메모장 같은 곳에 내용을 불러와서 쓴다면.. 프로그램이 돌아가고 있는 도중에도 메모장에 쓴
	//내용을 불러가기 때문에, 프로그램 종료하지 않아도 수정된 db 관련 내용을 적용시킬 수 있다.
	private void getProperties() {
		try {
			FileReader resource = new FileReader("src/config/db.properties");
			pro.load(resource);
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			id=pro.getProperty("id");
			pw=pro.getProperty("pw");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
