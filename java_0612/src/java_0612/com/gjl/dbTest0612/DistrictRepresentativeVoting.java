package java_0612.com.gjl.dbTest0612;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Date;

public class DistrictRepresentativeVoting {

	public static void main(String[] args) {

		// DataSet 준비 : int와 String이 섞여있으므로 2차원 배열의 Object를 사용
		Object[][] voteHistoryDataset = {
				{"9901011001", "김유권", "1", "0930", "제1투표장", "N"}, 
				{"8901012002", "이유권", "2", "0930", "제1투표장", "N"},
				{"6901011003", "박유권", "3", "0930", "제1투표장", "Y"},
				{"5901012004", "홍유권", "4", "0930", "제1투표장", "Y"},
				{"7901011005", "조유권", "5", "0930", "제1투표장", "Y"},
				{"8901012006", "최유권", "1", "0930", "제1투표장", "Y"},
				{"5901011007", "지유권", "1", "0930", "제1투표장", "Y"},
				{"4901012008", "장유권", "3", "0930", "제1투표장", "Y"},
				{"7901011009", "정유권", "3", "0930", "제1투표장", "Y"},
				{"89010120010", "강유권", "4", "0930", "제1투표장", "Y"},
				{"99010110011", "신유권", "5", "0930", "제1투표장", "Y"},
				{"79010120012", "오유권", "1", "1330", "제1투표장", "Y"},
				{"69010110013", "현유권", "4", "1330", "제2투표장", "Y"},
				{"89010110014", "왕유권", "2", "1330", "제2투표장", "Y"},
				{"99010110015", "유유권", "3", "1330", "제2투표장", "Y"},
				{"79010110016", "한유권", "2", "1330", "제2투표장", "Y"},
				{"89010110017", "문유권", "4", "1330", "제2투표장", "Y"},
				{"99010110018", "양유권", "2", "1330", "제2투표장", "Y"},
				{"99010110019", "구유권", "4", "1330", "제2투표장", "Y"},
				{"79010110020", "황유권", "5", "1330", "제2투표장", "Y"},
				{"69010110021", "배유권", "3", "1330", "제2투표장", "Y"},
				{"79010110022", "전유권", "3", "1330", "제2투표장", "Y"},
				{"99010110023", "고유권", "1", "1330", "제2투표장", "Y"},
				{"59010110024", "권유권", "3", "1330", "제2투표장", "Y"}
		};
		
		Object[][] voteMemberDataset = {
				{"1", "김후보", "P1", "1", "6603011999991", "수선화동"},
				{"2", "이후보", "P2", "3", "5503011999992", "민들레동"},
				{"3", "박후보", "P3", "2", "7703011999993", "나팔꽃동"},
				{"4", "조후보", "P4", "2", "8803011999994", "진달래동"},
				{"5", "최후보", "P5", "3", "9903011999995", "개나리동"}
		};
		
		Object[][] votePartyDataset = {
				{"P1", "A정당", "2010-01-01", "위대표", "02", "1111", "0001"},
				{"P2", "B정당", "2010-02-01", "명대표", "02", "1111", "0002"},
				{"P3", "C정당", "2010-03-01", "기대표", "02", "1111", "0003"},
				{"P4", "D정당", "2010-04-01", "옥대표", "02", "1111", "0004"},
				{"P5", "E정당", "2010-05-01", "임대표", "02", "1111", "0005"}
		};
		
		// CurrentDatabase: 현재 연결된 DB확인
		String checkDB = "select current_database()";

		// INSERT SQL
        // vote_history테이블에 데이터 삽입
        String insertIntoVoteHistory =
                "INSERT INTO vote_history (v_jumin, v_name, m_no, v_time, v_area, v_confirm) VALUES(?, ?, ?, ?, ?, ?)";
        
        // vote_member테이블에 데이터 삽입
        String insertIntoVoteMember =
                "INSERT INTO vote_member (m_no, m_name, p_code, p_school, m_jumin, m_city) VALUES(?, ?, ?, ?, ?, ?)";
        
        // vote_party테이블에 데이터 삽입
        String insertIntoVoteParty =
                "INSERT INTO vote_party (p_code, p_name, p_indate, p_reader, p_tel1, p_tel2, p_tel3) VALUES(?, ?, ?, ?, ?, ? ,?)";

        // SELECT SQL
        // vote_history테이블 조회
        String selectSqlFromVoteHistory = "SELECT v_jumin, v_name, m_no, v_time, v_area, v_confirm FROM vote_history";
        
        // vote_member테이블 조회
        String selectSqlFromVoteMember = "SELECT m_no, m_name, p_code, p_school, m_jumin, m_city FROM vote_member";
        
        // vote_party테이블 조회
        String selectSqlFromVoteParty = "SELECT p_code, p_name, p_indate, p_reader, p_tel1, p_tel2, p_tel3 FROM vote_party";
             
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
            try (PreparedStatement isvh = conn.prepareStatement(insertIntoVoteHistory)) {
            	
            	for (Object[] row : voteHistoryDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"9901011001", "김유권", "1", "0930", "제1투표장", "N"}
                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
            		isvh.setString(1, (String) row[0]); // String
            		isvh.setString(2, (String) row[1]); // String
            		isvh.setString(3, (String) row[2]); // String
            		isvh.setString(4, (String) row[3]); // String
            		isvh.setString(5, (String) row[4]); // String
            		isvh.setString(6, (String) row[5]); // String

            		isvh.addBatch(); // 한번에 데이터를 담음
                }
            	
            	int[] totalInserted = isvh.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
                conn.commit(); // 커밋(적용)

                System.out.println(totalInserted.length + "건의 복합 데이터를 vote_history 테이블에 삽입 성공");
            	
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            	conn.rollback();
            }
            
         // golf_member
            try (PreparedStatement isvm = conn.prepareStatement(insertIntoVoteMember)) {
            	
            	for (Object[] row : voteMemberDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"1", "김후보", "P1", "1", "6603011999991", "수선화동"}
                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
            		isvm.setString(1, (String) row[0]); // String
            		isvm.setString(2, (String) row[1]); // String
            		isvm.setString(3, (String) row[2]); // String
            		isvm.setString(4, (String) row[3]); // String
            		isvm.setString(5, (String) row[4]); // String
            		isvm.setString(6, (String) row[5]); // String

            		isvm.addBatch(); // 한번에 데이터를 담음
                }
            	
            	int[] totalInserted = isvm.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
                conn.commit(); // 커밋(적용)

                System.out.println(totalInserted.length + "건의 복합 데이터를 vote_member 테이블에 삽입 성공");
            	
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            	conn.rollback();
            }
            
         // golf_class
            try (PreparedStatement isvp = conn.prepareStatement(insertIntoVoteParty)) {
            	
            	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            	
            	for (Object[] row : votePartyDataset) { // 2차원 배열 안에 1차원에 담기 데이터를 꺼내서 작업 = 첫번째 작업의 row = {"P1", "A정당", "2010-01-01", "위대표", "02", "1111", "0001"}
                    // Object 타입을 원래의 데이터 타입으로 타입 캐스팅(변환)
            		isvp.setString(1, (String) row[0]); // String
            		isvp.setString(2, (String) row[1]); // String
            		isvp.setDate(3, Date.valueOf((String) row[2])); // timeStamp
            		isvp.setString(4, (String) row[3]); // String
            		isvp.setString(5, (String) row[4]); // String
            		isvp.setString(6, (String) row[5]); // String
            		isvp.setString(7, (String) row[6]); // String

            		isvp.addBatch(); // 한번에 데이터를 담음
                }
            	
            	int[] totalInserted = isvp.executeBatch(); // 데이터를 한번에 보내서 쿼리 실행
                conn.commit(); // 커밋(적용)

                System.out.println(totalInserted.length + "건의 복합 데이터를 vote_party 테이블에 삽입 성공");
            	
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            	conn.rollback();
            }

            // SELECT (조회)
            // golf_teacher : v_jumin, v_name, m_no, v_time, v_area, v_confirm
            try (
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(selectSqlFromVoteHistory)
            ) {

                System.out.println("\n투표 기록");

                while (rs.next()) {

                	String v_jumin = rs.getString("v_jumin");
                    String v_name = rs.getString("v_name");
                    String m_no = rs.getString("m_no");
                    String v_time = rs.getString("v_time");
                    String v_area = rs.getString("v_area");
                    String v_confirm = rs.getString("v_confirm");

                    System.out.println(
                            "v_jumin : " + v_jumin +
                            ", v_name : " + v_name +
                            ", m_no : " + m_no +
                            ", v_time : " + v_time +
                            ", v_area : " + v_area +
                            ", v_confirm : " + v_confirm
                    );
                }
            }
            
            // vote_member : m_no, m_name, p_code, p_school, m_jumin, m_city
            try (
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(selectSqlFromVoteMember)
            ) {

                System.out.println("\n후보자 목록");

                while (rs.next()) {

                    String m_no = rs.getString("m_no");
                    String m_name = rs.getString("m_name");
                    String p_code = rs.getString("p_code");
                    String p_school = rs.getString("p_school");
                    String m_jumin = rs.getString("m_jumin");
                    String m_city = rs.getString("m_city");

                    System.out.println(
                            "m_no : " + m_no +
                            ", m_name : " + m_name +
                            ", p_code : " + p_code +
                            ", p_school : " + p_school +
                            ", m_jumin : " + m_jumin +
                            ", m_city : " + m_city
                    );
                }
            }
            
            // vote_party : p_code, p_name, p_indate, p_reader, p_tel1, p_tel2, p_tel3
            try (
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(selectSqlFromVoteParty)
            ) {

                System.out.println("\n상세 목록");

                while (rs.next()) {

                	String p_code = rs.getString("p_code");
                    String p_name = rs.getString("p_name");
                    Timestamp p_indate = rs.getTimestamp("p_indate");
                    String p_reader = rs.getString("p_reader");
                    String p_tel1 = rs.getString("p_tel1");
                    String p_tel2 = rs.getString("p_tel2");
                    String p_tel3 = rs.getString("p_tel3");

                    System.out.println(
                            "p_code : " + p_code +
                            ", p_name : " + p_name +
                            ", p_indate : " + p_indate +
                            ", p_reader : " + p_reader +
                            ", p_tel1 : " + p_tel1 +
                            ", p_tel2 : " + p_tel2 +
                            ", p_tel3 : " + p_tel3 
                            + "대표전화 : " + p_tel1 + "-" + p_tel2 + "-" + p_tel3
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