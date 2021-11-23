import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://114.55.7.3:3306/linux_final?serverTimezone=GMT%2B8";
    static final String USER = "root";
    static final String PASS = "hspedu100";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select studentId,studentName,age from t_student where studentId=4";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int studentId = rs.getInt("studentId");
                String studentName = rs.getString("studentName");
		String age=rs.getString("age");
		System.out.println("Student{"+studentId+"\t"+studentName+"\t"+age+"}");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
