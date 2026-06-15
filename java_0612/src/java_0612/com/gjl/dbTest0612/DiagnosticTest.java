package java_0612.com.gjl.dbTest0612;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class DiagnosticTest {
	public static void main(String[] args) {
		
		// DataSet 준비 : int와 String이 섞여있으므로 2차원 배열의 Object를 사용
				Object[][] mePatientDataset = {
						{"1001", "김환자", "19850301", "M", "010", "2222", "0001", "10"}, 
						{"1002", "이환자", "19900301", "M", "010", "2222", "0002", "20"},
						{"1003", "박환자", "19770301", "F", "010", "2222", "0003", "30"},
						{"1004", "조환자", "19650301", "F", "010", "2222", "0004", "10"},
						{"1005", "황환자", "19490301", "M", "010", "2222", "0005", "40"},
						{"1006", "양환자", "19440301", "F", "010", "2222", "0006", "40"},
						{"1007", "허환자", "19760301", "F", "010", "2222", "0007", "10"}
				};
				
				Object[][] meTestDataset = {
						{"T001", "결핵"},
						{"T002", "장티푸스"},
						{"T003", "수두"},
						{"T004", "홍역"},
						{"T005", "콜레라"}
				};
				
				Object[][] meResultDataset = {
						{"1001", "T001", "2020-01-01", "1", "2020-01-02", "X"},
						{"1002", "T002", "2020-01-01", "2", "2020-01-02", "P"},
						{"1003", "T003", "2020-01-01", "2", "2020-01-02", "N"},
						{"1004", "T004", "2020-01-01", "2", "2020-01-02", "P"},
						{"1005", "T005", "2020-01-01", "2", "2020-01-02", "P"},
						{"1006", "T001", "2020-01-01", "2", "2020-01-02", "N"},
						{"1007", "T002", "2020-01-01", "2", "2020-01-02", "P"},
						{"1005", "T003", "2020-01-01", "2", "2020-01-02", "P"},
						{"1006", "T004", "2020-01-01", "2", "2020-01-02", "N"},
						{"1007", "T005", "2020-01-01", "2", "2020-01-02", "N"}
				};
				
				// CurrentDatabase: 현재 연결된 DB확인
				String checkDB = "select current_database()";

				// INSERT SQL
		        // me_patient테이블에 데이터 삽입
		        String insertIntoMePatient =
		                "INSERT INTO me_patient (p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		        
		        // me_test테이블에 데이터 삽입
		        String insertIntoMeTest =
		                "INSERT INTO me_test (t_code, t_name) VALUES(?, ?)";
		        
		        // me_result테이블에 데이터 삽입
		        String insertIntoMeResult =
		                "INSERT INTO me_result (p_no, t_code, t_sdate, t_status, t_ldate, t_result) VALUES(?, ?, ?, ?, ?, ?)";

		        // SELECT SQL
		        // me_patient테이블 조회
		        String selectSqlFromMePatient = "SELECT p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city FROM me_patient";
		        
		        // me_test테이블 조회
		        String selectSqlFromMeTest = "SELECT t_code, t_name FROM me_test";
		        
		        // me_result테이블 조회
		        String selectSqlFromMeResult = "SELECT p_no, t_code, t_sdate, t_status, t_ldate, t_result FROM me_result";
		             
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
		        	// me_patient
		            try (PreparedStatement isvh = conn.prepareStatement(insertIntoMePatient)) {
		            	
		            	for (Object[] row : mePatientDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"1001", "김환자", "19850301", "M", "010", "2222", "0001", "10"}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isvh.setString(1, (String) row[0]); // String
		            		isvh.setString(2, (String) row[1]); // String
		            		isvh.setString(3, (String) row[2]); // String
		            		isvh.setString(4, (String) row[3]); // String
		            		isvh.setString(5, (String) row[4]); // String
		            		isvh.setString(6, (String) row[5]); // String
		            		isvh.setString(7, (String) row[6]); // String
		            		isvh.setString(8, (String) row[7]); // String

		            		isvh.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isvh.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 me_patient 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }
		            
		         // me_test
		            try (PreparedStatement isvm = conn.prepareStatement(insertIntoMeTest)) {
		            	
		            	for (Object[] row : meTestDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"T001", "결핵"}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isvm.setString(1, (String) row[0]); // String
		            		isvm.setString(2, (String) row[1]); // String

		            		isvm.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isvm.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 me_test 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }
		            
		         // me_result
		            try (PreparedStatement isvp = conn.prepareStatement(insertIntoMeResult)) {
		            	
		            	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		            	
		            	for (Object[] row : meResultDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"1001", "T001", "2020-01-01", "1", "2020-01-02", "X"}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isvp.setString(1, (String) row[0]); // String
		            		isvp.setString(2, (String) row[1]); // String
		            		isvp.setDate(3, Date.valueOf((String) row[2])); // timeStamp
		            		isvp.setString(4, (String) row[3]); // String
		            		isvp.setDate(5, Date.valueOf((String) row[4])); // timeStamp
		            		isvp.setString(6, (String) row[5]); // String

		            		isvp.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isvp.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 me_result 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }

		            // SELECT (조회)
		            // me_patient : p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromMePatient)
		            ) {

		                System.out.println("\n환자 목록");

		                while (rs.next()) {

		                	String p_no = rs.getString("p_no");
		                    String p_name = rs.getString("p_name");
		                    String p_birth = rs.getString("p_birth");
		                    String p_gender = rs.getString("p_gender");
		                    String p_tel1 = rs.getString("p_tel1");
		                    String p_tel2 = rs.getString("p_tel2");
		                    String p_tel3 = rs.getString("p_tel3");
		                    String p_city = rs.getString("p_city");

		                    System.out.println(
		                            "p_no : " + p_no +
		                            ", p_name : " + p_name +
		                            ", p_birth : " + p_birth +
		                            ", p_gender : " + p_gender +
		                            ", p_tel1 : " + p_tel1 +
		                            ", p_tel2 : " + p_tel2 +
		                            ", p_tel3 : " + p_tel3 +
		                            ", p_city : " + p_city
		                    );
		                }
		            }
		            
		            // me_test : t_code, t_name
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromMeTest)
		            ) {

		                System.out.println("\n병명 목록");

		                while (rs.next()) {

		                    String t_code = rs.getString("t_code");
		                    String t_name = rs.getString("t_name");

		                    System.out.println(
		                            "t_code : " + t_code +
		                            ", t_name : " + t_name
		                    );
		                }
		            }
		            
		            // me_result : p_no, t_code, t_sdate, t_status, t_ldate, t_result
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromMeResult)
		            ) {

		                System.out.println("\n테스트 결과");

		                while (rs.next()) {

		                	String p_no = rs.getString("p_no");
		                    String t_code = rs.getString("t_code");
		                    Timestamp t_sdate = rs.getTimestamp("t_sdate");
		                    String t_status = rs.getString("t_status");
		                    Timestamp t_ldate = rs.getTimestamp("t_ldate");
		                    String t_result = rs.getString("t_result");

		                    System.out.println(
		                            "p_no : " + p_no +
		                            ", t_code : " + t_code +
		                            ", t_sdate : " + t_sdate +
		                            ", t_status : " + t_status +
		                            ", t_ldate : " + t_ldate +
		                            ", t_result : " + t_result
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
