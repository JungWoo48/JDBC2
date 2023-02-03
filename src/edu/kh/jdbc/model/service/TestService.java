package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.SQLException;

// import static 구문 
//-> static이 붙은 필드, 메서드를 호출할때
// 클래스명을 생략할수 있게 해준다
// import static ...  .*;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dao.TestDAO;
import edu.kh.jdbc.model.vo.TestVO;

// service : 비즈니스 로직(데이터 가공, 트랜잭션 제어) 처리
// -> 실제 프로그램이 제공하는 기능을 모아놓은 클래스


// 하나의 Service 메서드에서 n개의 DAO메서드(지정된 SQL 수행)를 호출하여
// 이를 하나의 트랙잭션 단위로 취급하여
// 한번에 commit, rollback을 수행할 수 있다.

// *여러 DML을 수행하지 않는 경우 (단일 DML, SELECT등) 라도
// 코드의 통일성을 지키기 위해서 Service에 작성
// -> Connection 객체 생성


public class TestService {

	//DAO 연결 메서드
	private TestDAO dao = new TestDAO();
	
	
	/** 1행 삽입 서비스
	 * @param vo1
	 * @return result
	 */
	public int insert(TestVO vo1) throws SQLException{
		// 커낵션 생성
		Connection conn = getConnection();
							//클래스명.메서드명 (JDBCTemplate)에서 만든것
							//import문을 수정하여 메서드명만 써서 클래스의 모든 것을 가져옴
		
		// INSERT DAO 메서드를 호출하여 수행 후 결과 반환 받기
		// inser반환이라 int 자료형
		int result = dao.insert(conn, vo1);
		// result == SQL 수행후 반영된 결과 행의 개수
		
		// 트랜잭션 제어
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		// 커넥션 반환(close)
		close(conn);
		
		return result;
	}
	
	
	/** 3개 행 삽입 서비스
	 * @param vo1
	 * @param vo2
	 * @param vo3
	 * @return result
	 */
	public int insert(TestVO vo1, TestVO vo2, TestVO vo3) throws Exception {
		//1. Connection 생성
		Connection conn = getConnection();
		
		int result = 0; // 1 / 0
		
		try {
			
			int result1 = dao.insert(conn, vo1);
			int result2 = dao.insert(conn, vo2);
			int result3 = dao.insert(conn, vo3);
			
			//트랙젝션 제어
			if(result1 + result2 + result3 == 3) {//모두 성공시 commit
				commit(conn);
				result = 1;
			} else {
				rollback(conn);
			}
		} catch(SQLException e)	 { //dao 수행중에 예외가 발생했을때
			rollback(conn);
			//실패된 데이터를 db에 삽입하지 않음-> DB에는 성공된 테이터만 삽입한다
			//DB는 저장된 데이터의 신뢰도가 높아야한다
			
			//Run2 클래스로 예외 throws
			throw new Exception("DAO 수행중 예외발생");
			
		} finally { // 무조건 conn 반환하기
			close(conn);
		} 

		return result; // insert를 3회 반환한 결과
	}


	
	
	/** 번호가 일치하는 행 제목 내용 수정 서비스
	 * @param vo
	 * @return result
	 * @throws SQLException
	 */
	public int update(TestVO vo) throws SQLException{
		// 1. Connection 생성
		Connection conn = getConnection();
		
		int result = dao.update(conn, vo);
		
		if(result >0) commit(conn);
		else		 	rollback(conn);
		
		
		close(conn);
		return result;
	}
	

	
}
