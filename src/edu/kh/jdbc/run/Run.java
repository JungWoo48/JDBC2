package edu.kh.jdbc.run;

import java.sql.SQLException;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestService service = new TestService();
		
		// TB_TEST 테이블에 INSERT 수행
		TestVO vo1 = new TestVO(2, "제목1", "내용1");
		
		// TB_TEST 테이블에 INSET를 수행하는 서비스 메서드를 호출후 반환받기
		// insert는 행의 개수를 반환 int 자료형 사용
		
		try {
			int result = service.insert(vo1); // 1/ 0
			
			if(result > 0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
			
			result = service.insert(vo1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
