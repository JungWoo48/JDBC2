package edu.kh.jdbc.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {
	public static void main(String[] args) {
		
		// XML (eXtensible Markup Language) : 단순화된 데이터 기술 형식
		
		// XML에 저장되는 데이터 형식은 Map : <K:V> 형식이다.
		// Map<String, String>
		// Key와 Value 모두 String 형식이다
		
		// * Properties 컬렉션 개체 *
		// - Map의 후손 클래스
		// - Key, Value 모두 String 형식
		// - XML 파일을 읽고, 쓰는데 특화된 메서드를 제공
		
		// FileOutputStream 생성
		// 파일명.xml
		try {
			
			Scanner sc = new Scanner(System.in);
			
			// Properties 객체 생성
			Properties prop = new Properties();
			
			System.out.print("생성할 파일 이름 :");
			String fileName = sc.nextLine();
			
			FileOutputStream fos = new FileOutputStream(fileName+".xml");
			
			// Properties 객체를 이용해서 XML 파일 생성
			prop.storeToXML(fos, fileName + ".xml file"); //outstream 이름과 코맨트 입력
			
			System.out.println(fileName + ".xml 파일 생성 완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
