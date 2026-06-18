package java_0612.com.gjl.dbTest0612;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Date;

public class VaccineReservation {
	public static void main(String[] args) {
		
		// DataSet 준비 : int와 String이 섞여있으므로 2차원 배열의 Object를 사용
				Object[][] vaJuminDataset = {
						{"710101-1000001", "김주민", "010-1111-1111", "경기도 성남시 수정구 태평1동"},
						{"720101-2000001", "이주민", "010-1111-2222", "경기도 성남시 수정구 태평2동"},
						{"730101-1000001", "박주민", "010-1111-3333", "경기도 성남시 수정구 복정동"},
						{"740101-2000001", "홍주민", "010-1111-4444", "경기도 성남시 수정구 산성동"},
						{"750101-1000001", "조주민", "010-1111-5555", "경기도 성남시 중원구 성남동"},
						{"760101-2000001", "최주민", "010-1111-6666", "경기도 성남시 중원구 중앙동"},
						{"770101-1000001", "장주민", "010-1111-7777", "경기도 성남시 중원구 상대원동"},
						{"780101-2000001", "정주민", "010-1111-8888", "경기도 성남시 중원구 하대원동"},
						{"790101-1000001", "강주민", "010-1111-9999", "경기도 성남시 분당구 야탑1동"},
						{"800101-2000001", "신주민", "010-2222-1111", "경기도 성남시 분당구 야탑2동"},
				};
				
				Object[][] vaHospDataset = {
						{"H001", "가_병원", "031-1111-2222", "10"},
						{"H002", "나_병원", "031-1111-3333", "20"},
						{"H003", "다_병원", "031-1111-4444", "30"},
						{"H004", "라_병원", "031-1111-5555", "40"}
				};
				
				Object[][] vaVaccResvDataset = {
					    {20210001, "710101-1000001", "H001", "2021-08-01", 1930, "V001"},
					    {20210002, "720101-2000001", "H002", "2021-08-01", 1030, "V002"},
					    {20210003, "730101-1000001", "H003", "2021-08-01", 1130, "V003"},
					    {20210004, "740101-2000001", "H001", "2021-08-01", 1230, "V001"},
					    {20210005, "750101-1000001", "H001", "2021-08-01", 1330, "V002"},
					    {20210006, "760101-2000001", "H002", "2021-08-01", 1430, "V003"},
					    {20210007, "770101-1000001", "H003", "2021-08-01", 1530, "V001"},
					    {20210008, "780101-2000001", "H001", "2021-08-01", 1630, "V002"},
					    {20210009, "790101-1000001", "H001", "2021-08-01", 1730, "V003"},
					    {20210010, "800101-2000001", "H002", "2021-08-01", 1830, "V001"}
					};
				
				// CurrentDatabase: 현재 연결된 DB확인
				String checkDB = "select current_database()";

				// INSERT SQL
		        // va_jumin테이블에 데이터 삽입
		        String insertIntoVaJumin = "INSERT INTO va_jumin (jumin, name, phone, address) VALUES(?, ?, ?, ?)";
		        
		        // va_hosp테이블에 데이터 삽입
		        String insertIntoVaHosp = "INSERT INTO va_hosp (hosp_code, hosp_name, hosp_tel, hosp_addr) VALUES(?, ?, ?, ?)";
		        
		        // va_vacc_resv테이블에 데이터 삽입
		        String insertIntoVaVaccResv = "INSERT INTO va_vacc_resv (resv_no, jumin, hosp_code, resv_date, resv_time, v_code) VALUES(?, ?, ?, ?, ?, ?)";

		        // SELECT SQL
		        // va_jumin테이블 조회
		        String selectSqlFromVaJumin = "SELECT jumin, name, phone, address FROM va_jumin";
		        
		        // va_hosp테이블 조회
		        String selectSqlFromVaHosp = "SELECT hosp_code, hosp_name, hosp_tel, hosp_addr FROM va_hosp";
		        
		        // va_vacc_resv테이블 조회
		        String selectSqlFromVaVaccResv = "SELECT resv_no, jumin, hosp_code, resv_date, resv_time, v_code FROM va_vacc_resv";
		             
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
		        	// va_jumin
		            try (PreparedStatement isvj = conn.prepareStatement(insertIntoVaJumin)) {
		            	
		            	for (Object[] row : vaJuminDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"710101-1000001", "김주민", "010-1111-1111", "경기도 성남시 수정구 태평1동"}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isvj.setString(1, (String) row[0]); // String
		            		isvj.setString(2, (String) row[1]); // String
		            		isvj.setString(3, (String) row[2]); // String
		            		isvj.setString(4, (String) row[3]); // String

		            		isvj.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isvj.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 va_jumin 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }
		            
		         // va_hosp
		            try (PreparedStatement isvh = conn.prepareStatement(insertIntoVaHosp)) {
		            	
		            	for (Object[] row : vaHospDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"H001", "가_병원", "031-1111-2222", "10"}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isvh.setString(1, (String) row[0]); // String
		            		isvh.setString(2, (String) row[1]); // String
		            		isvh.setString(3, (String) row[2]); // String
		            		isvh.setString(4, (String) row[3]); // String

		            		isvh.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isvh.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 va_hosp 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }
		            
		         // va_vacc_resv
		            try (PreparedStatement isvr = conn.prepareStatement(insertIntoVaVaccResv)) {
		            	
		            	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		            	
		            	for (Object[] row : vaVaccResvDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"20210001", "710101-1000001", "H001", "20210801", "1930", "V001"}
		                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
		            		isvr.setInt(1, (int) row[0]); // int
		            		isvr.setString(2, (String) row[1]); // String
		            		isvr.setString(3, (String) row[2]); // String
		            		isvr.setDate(4, Date.valueOf((String) row[3])); // timeStamp
		            		isvr.setInt(5, (int) row[4]); // int
		            		isvr.setString(6, (String) row[5]); // String

		            		isvr.addBatch(); // 한번에 데이터를 담음
		                }
		            	
		            	int[] totalInserted = isvr.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
		                conn.commit(); // 커밋(적용)

		                System.out.println(totalInserted.length + "건의 복합 데이터를 va_vacc_resv 테이블에 삽입 성공");
		            	
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            	conn.rollback();
		            }

		            // SELECT (조회)
		            // va_jumin : jumin, name, phone, address
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromVaJumin)
		            ) {

		                System.out.println("\n주민 목록");

		                while (rs.next()) {

		                	String jumin = rs.getString("jumin");
		                    String name = rs.getString("name");
		                    String phone = rs.getString("phone");
		                    String address = rs.getString("address");

		                    System.out.println(
		                            "jumin : " + jumin +
		                            ", name : " + name +
		                            ", phone : " + phone +
		                            ", address : " + address
		                    );
		                }
		            }
		            
		            // va_hosp : hosp_code, hosp_name, hosp_tel, hosp_addr
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromVaHosp)
		            ) {

		                System.out.println("\n병원 목록");

		                while (rs.next()) {

		                    String hosp_code = rs.getString("hosp_code");
		                    String hosp_name = rs.getString("hosp_name");
		                    String hosp_tel = rs.getString("hosp_tel");
		                    String hosp_addr = rs.getString("hosp_addr");

		                    System.out.println(
		                            "hosp_code : " + hosp_code +
		                            ", hosp_name : " + hosp_name +
		                            ", hosp_tel : " + hosp_tel +
		                            ", hosp_addr : " + hosp_addr
		                    );
		                }
		            }
		            
		            // va_vacc_resv : resv_no, jumin, hosp_code, resv_date, resv_time, v_code
		            try (
		                Statement stmt = conn.createStatement();

		                ResultSet rs = stmt.executeQuery(selectSqlFromVaVaccResv)
		            ) {

		                System.out.println("\n백신 예약 목록");

		                while (rs.next()) {

		                	int resv_no = rs.getInt("resv_no");
		                    String jumin = rs.getString("jumin");
		                    String hosp_code = rs.getString("hosp_code");
		                    Timestamp resv_date = rs.getTimestamp("resv_date");
		                    int resv_time = rs.getInt("resv_time");
		                    String v_code = rs.getString("v_code");

		                    System.out.println(
		                            "resv_no : " + resv_no +
		                            ", jumin : " + jumin +
		                            ", hosp_code : " + hosp_code +
		                            ", resv_date : " + resv_date +
		                            ", resv_time : " + resv_time +
		                            ", v_code : " + v_code
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
