package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc_test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "hr";
		/*String query = "update test set username = ?"
				+ "where userid = ?";*/
		/*String query = "DELETE test "
				+ "WHERE userid = ?";*/
		String query = "insert into test "
				+ "values(?,?)"; // ''포함해서 ?로 사용한다. 
		//다른값으로 대체할 거라고 표기해둔것.
		BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String userid = null;
		String username = null;
		
		try {
			Class.forName(driver);
			System.out.println("아이디");
			userid = keyin.readLine();
			System.out.println("이름");
			username = keyin.readLine();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(2, username);
			pstmt.setString(1, userid);
			//여기서 ?를 실제 데이터로 바꾼다
			//pstmt.setString(1, userid);
			/*pstmt.setString(1, userid); // 첫번째 ?에 userid를 넣는다.
			//날짜만 잘 넣으면, date도 들어간다.
			pstmt.setString(2, username);*/
			int result = pstmt.executeUpdate();
			System.out.println(result + "완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
