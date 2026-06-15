package java_0612.com.gjl.dbTest0612;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class GolfManagement {

	public static void main(String[] args) {

		// DataSet 준비 : int와 String이 섞여있으므로 2차원 배열의 Object를 사용
		Object[][] golfTeacherDataset = {
				{100, "이초급", "초급반", 100000, "20220101"}, 
				{200, "김중급", "중급반", 200000, "20220102"},
				{300, "박고급", "고급반", 300000, "20220103"},
				{400, "정심화", "심화반", 400000, "20220104"}
		};
		
		Object[][] golfMemberDataset = {
				{"10001", "홍길동", "01011112222", "서울시 강남구", "일반"},
				{"10002", "장발장", "01022223333", "성남시 분당구", "일반"},
				{"10003", "임꺽정", "01033334444", "대전시 유성구", "일반"},
				{"20001", "성춘향", "01044445555", "부산시 서구", "VIP"},
				{"20002", "이몽룡", "01055556666", "대구시 북구", "VIP"}
		};
		
		Object[][] golfClassDataset = {
				{"202203", "10001", "서울본원", 100000, "100"},
				{"202203", "10002", "성남분원", 100000, "100"},
				{"202203", "10003", "대전분원", 200000, "200"},
				{"202203", "20001", "부산분원", 150000, "300"},
				{"202203", "20002", "대구분원", 200000, "400"}
		};
		
		// CurrentDatabase: 현재 연결된 DB확인
		String checkDB = "select current_database()";

		// INSERT SQL
        // golf_teacher테이블에 데이터 삽입
        String insertIntoGolfTeacher =
                "INSERT INTO golf_teacher (teacher_code, teacher_name, class_name, class_price, teacher_regist_date) VALUES(?, ?, ?, ?, ?)";
        
        // golf_member테이블에 데이터 삽입
        String insertIntoGolfMember =
                "INSERT INTO golf_member (c_no, c_name, phone, address, grade) VALUES(?, ?, ?, ?, ?)";
        
        // golf_class테이블에 데이터 삽입
        String insertIntoGolfClass =
                "INSERT INTO golf_class (regist_month, c_no, class_area, tuition, teacher_code) VALUES(?, ?, ?, ?, ?)";

        // SELECT SQL
        // golf_teacher테이블 조회
        String selectSqlFromGolfTeacher = "SELECT teacher_code, teacher_name, class_name, class_price, teacher_regist_date FROM golf_teacher";
        
        // golf_member테이블 조회
        String selectSqlFromGolfMember = "SELECT c_no, c_name, phone, address, grade FROM golf_member";
        
        // golf_class테이블 조회
        String selectSqlFromGolfClass = "SELECT regist_month, c_no, class_area, tuition, teacher_code FROM golf_class";
             
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
        	// golf_teacher
            try (PreparedStatement isgt = conn.prepareStatement(insertIntoGolfTeacher)) {
            	
            	for (Object[] row : golfTeacherDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {100, "이초급", "초급반", 100000, "20220101"}
                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
            		isgt.setInt(1, (Integer) row[0]); // int
            		isgt.setString(2, (String) row[1]); // String
            		isgt.setString(3, (String) row[2]); // String
            		isgt.setInt(4, (Integer) row[3]); // int
            		isgt.setString(5, (String) row[4]); // String

            		isgt.addBatch(); // 한번에 데이터를 담음
                }
            	
            	int[] totalInserted = isgt.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
                conn.commit(); // 커밋(적용)

                System.out.println(totalInserted.length + "건의 복합 데이터를 golf_teacher 테이블에 삽입 성공");
            	
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            	conn.rollback();
            }
            
         // golf_member
            try (PreparedStatement isgm = conn.prepareStatement(insertIntoGolfMember)) {
            	
            	for (Object[] row : golfMemberDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"10001", "홍길동", "01011112222", "서울시 강남구", "일반"}
                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
            		isgm.setString(1, (String) row[0]); // String
            		isgm.setString(2, (String) row[1]); // String
            		isgm.setString(3, (String) row[2]); // String
            		isgm.setString(4, (String) row[3]); // String
            		isgm.setString(5, (String) row[4]); // String

            		isgm.addBatch(); // 한번에 데이터를 담음
                }
            	
            	int[] totalInserted = isgm.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
                conn.commit(); // 커밋(적용)

                System.out.println(totalInserted.length + "건의 복합 데이터를 golf_member 테이블에 삽입 성공");
            	
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            	conn.rollback();
            }
            
         // golf_class
            try (PreparedStatement isgc = conn.prepareStatement(insertIntoGolfClass)) {
            	
            	for (Object[] row : golfClassDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"202203", "10001", "서울본원", 100000, "100"}
                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
            		isgc.setString(1, (String) row[0]); // String
            		isgc.setString(2, (String) row[1]); // String
            		isgc.setString(3, (String) row[2]); // String
            		isgc.setInt(4, (Integer) row[3]); // int
            		isgc.setString(5, (String) row[4]); // String

            		isgc.addBatch(); // 한번에 데이터를 담음
                }
            	
            	int[] totalInserted = isgc.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
                conn.commit(); // 커밋(적용)

                System.out.println(totalInserted.length + "건의 복합 데이터를 golf_class 테이블에 삽입 성공");
            	
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            	conn.rollback();
            }

            // SELECT (조회)
            // golf_teacher : teacher_code, teacher_name, class_name, class_price, teacher_regist_date
            try (
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(selectSqlFromGolfTeacher)
            ) {

                System.out.println("\n강사 목록");

                while (rs.next()) {

                    Long teacher_code = rs.getLong("teacher_code");
                    String teacher_name = rs.getString("teacher_name");
                    String class_name = rs.getString("class_name");
                    int class_price = rs.getInt("class_price");
                    String teacher_regist_date = rs.getString("teacher_regist_date");

                    System.out.println(
                            "teacher_code : " + teacher_code +
                            ", teacher_name : " + teacher_name +
                            ", class_name : " + class_name +
                            ", class_price : " + class_price +
                            ", teacher_regist_date : " + teacher_regist_date
                    );
                }
            }
            
            // golf_member : c_no, c_name, phone, address, grade
            try (
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(selectSqlFromGolfMember)
            ) {

                System.out.println("\n회원 목록");

                while (rs.next()) {

                    String c_no = rs.getString("c_no");
                    String c_name = rs.getString("c_name");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String grade = rs.getString("grade");

                    System.out.println(
                            "c_no : " + c_no +
                            ", c_name : " + c_name +
                            ", phone : " + phone +
                            ", address : " + address +
                            ", grade : " + grade
                    );
                }
            }
            
            // golf_class : regist_month, c_no, class_area, tuition, teacher_code
            try (
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(selectSqlFromGolfClass)
            ) {

                System.out.println("\n강의반 목록");

                while (rs.next()) {

                	String regist_month = rs.getString("regist_month");
                    String c_no = rs.getString("c_no");
                    String class_area = rs.getString("class_area");
                    int tuition = rs.getInt("tuition");
                    String teacher_code = rs.getString("teacher_code");

                    System.out.println(
                            "regist_month : " + regist_month +
                            ", c_no : " + c_no +
                            ", class_area : " + class_area +
                            ", tuition : " + tuition +
                            ", teacher_code : " + teacher_code
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