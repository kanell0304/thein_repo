package java_0612.com.gjl.dbTest0612;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Date;

public class BachelorManagement {
	public static void main(String[] args) {
		
		// DataSet 준비 : int와 String이 섞여있으므로 2차원 배열의 Object를 사용
				Object[][] acStudenDataset = {
					{"10101", "김행복", "010-1111-2222", "M", "서울 동대문구 휘경1동"}, 
					{"10102", "이축복", "010-1111-3333", "F", "서울 동대문구 휘경2동"},
					{"10103", "장믿음", "010-1111-4444", "M", "울릉군 울릉읍 독도1리"},
					{"10104", "최사랑", "010-1111-5555", "F", "울릉군 울릉읍 독도2리"},
					{"10105", "진평화", "010-1111-6666", "M", "제주도 제주시 외나무골"},
					{"10106", "차공단", "010-1111-7777", "M", "제주도 제주시 감나무골"}
				};
				
				Object[][] acExamDataset = {
					{"10101", 98, 91, 95, 90},
					{"10102", 87, 89, 92, 82}
				};
				
				
				// CurrentDatabase: 현재 연결된 DB확인
				String checkDB = "select current_database()";

				// INSERT SQL
		        // ac_student테이블에 데이터 삽입
		        String insertIntoAcStudent = "INSERT INTO ac_student (s_no, s_name, s_phone, s_gender, s_address) VALUES(?, ?, ?, ?, ?)";
		        
		        // ac_exam테이블에 데이터 삽입
		        String insertIntoAcExam = "INSERT INTO ac_exam (s_no, e_kor, e_math, e_eng, e_hist) VALUES(?, ?, ?, ?, ?)";

		        // SELECT SQL
		        // ac_student테이블 조회
		        String selectSqlFromAcStudent = "SELECT s_no, s_name, s_phone, s_gender, s_address FROM ac_student";
		        
		        // ac_exam테이블 조회
		        String selectSqlFromAcExam = "SELECT s_no, e_kor, e_math, e_eng, e_hist FROM ac_exam";
		             
		        try {
		        	
		        	// DB연결 및 연결 여부 확인
		        	Connection conn = ConnectDB.getConnection();
		        	PreparedStatement checkDBsql = conn.prepareStatement(checkDB);
		        	ResultSet resultDB = checkDBsql.executeQuery();
		        	conn.setAutoCommit(false); // 오토커밋 off
		        	
		        	if (resultDB.next()) { // 커서이동(초기값 0 -> next()로 첫번쨰 행으로 이동)
		        		System.out.println("현재 연결된 DB: '" + resultDB.getString(1) + "'");
		        	} else {
		        		System.out.println("현재 연결된 DB를 출력할 수 없습니다.");
		        	}
		        	
		            // INSERT (데이터 삽입)
		        	// ac_student
		            try (PreparedStatement isas = conn.prepareStatement(insertIntoAcStudent)) {
		            	
		            	for (Object[] row : acStudenDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"10101", "김행복", "010-1111-2222", "M", "서울 동대문구 휘경1동"}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isas.setString(1, (String) row[0]); // String
		            		isas.setString(2, (String) row[1]); // String
		            		isas.setString(3, (String) row[2]); // String
		            		isas.setString(4, (String) row[3]); // String
		            		isas.setString(5, (String) row[4]); // String

		            		isas.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isas.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 ac_student 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }
		            
		         // ac_exam
		            try (PreparedStatement isae = conn.prepareStatement(insertIntoAcExam)) {
		            	
		            	for (Object[] row : acExamDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"10101", 98, 91, 95, 90}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isae.setString(1, (String) row[0]); // String
		            		isae.setInt(2, (int) row[1]); // int
		            		isae.setInt(3, (int) row[2]); // int
		            		isae.setInt(4, (int) row[3]); // int
		            		isae.setInt(5, (int) row[4]); // int

		            		isae.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isae.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 ac_exam 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }

		            // SELECT (조회)
		            // ac_student : s_no, s_name, s_phone, s_gender, s_address
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromAcStudent)
		            ) {

		                System.out.println("\n학생 목록");

		                while (rs.next()) {

		                	String s_no = rs.getString("s_no");
		                    String s_name = rs.getString("s_name");
		                    String s_phone = rs.getString("s_phone");
		                    String s_gender = rs.getString("s_gender");
		                    String s_address = rs.getString("s_address");

		                    System.out.println(
		                            "s_no : " + s_no +
		                            ", s_name : " + s_name +
		                            ", s_phone : " + s_phone +
		                            ", s_gender : " + s_gender +
		                            ", s_address : " + s_address
		                    );
		                }
		            }
		            
		            // ac_exam : s_no, e_kor, e_math, e_eng, e_hist
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromAcExam)
		            ) {

		                System.out.println("\n성정 목록");

		                while (rs.next()) {

		                    String s_no = rs.getString("s_no");
		                    int e_kor = rs.getInt("e_kor");
		                    int e_math = rs.getInt("e_math");
		                    int e_eng = rs.getInt("e_eng");
		                    int e_hist = rs.getInt("e_hist");

		                    System.out.println(
		                            "s_no : " + s_no +
		                            ", e_kor : " + e_kor +
		                            ", e_math : " + e_math +
		                            ", e_eng : " + e_eng +
		                            ", e_hist : " + e_hist
		                    );
		                }
		            }
		            
		            resultDB.close();
		            checkDBsql.close();
		            conn.close();
		        } catch (Exception e) {
		        	System.out.println(e.getMessage());
		        }

	}
}
