package java_0612.com.gjl.dbconnecttest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectEx1 {

	public static void main(String[] args) {

        // INSERT SQL
        String insertSql =
                "INSERT INTO departments(name) VALUES(?)";
        
        // SELECT SQL
        String selectSqlFromDepartments =
                "SELECT id, name FROM departments";
        
        try {
        	
        	Connection conn = ConnectDB.getConnection();
        	
            // INSERT (수정)
//            try (PreparedStatement pstmt =
//                         conn.prepareStatement(insertSql)) {
//
//                pstmt.setString(1, "홍길동");
//
//                int result =
//                        pstmt.executeUpdate();
//
//                System.out.println(
//                        result + "건 INSERT 완료"
//                );
//            }

            // SELECT (조회)
//            try (
//                Statement stmt =
//                        conn.createStatement();
//
//                ResultSet rs =
//                        stmt.executeQuery(selectSql)
//            ) {
//
//                System.out.println("\n부서 목록");
//
//                while (rs.next()) {
//
//                    Long id =
//                            rs.getLong("id");
//
//                    String name =
//                            rs.getString("name");
//
//                    System.out.println(
//                            "ID : " + id +
//                            ", 부서명 : " + name
//                    );
//                }
//            }
        	
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }

	}
}