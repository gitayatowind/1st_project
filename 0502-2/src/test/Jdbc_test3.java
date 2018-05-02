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
				+ "values(?,?)"; // ''�����ؼ� ?�� ����Ѵ�. 
		//�ٸ������� ��ü�� �Ŷ�� ǥ���صа�.
		BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String userid = null;
		String username = null;
		
		try {
			Class.forName(driver);
			System.out.println("���̵�");
			userid = keyin.readLine();
			System.out.println("�̸�");
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
			//���⼭ ?�� ���� �����ͷ� �ٲ۴�
			//pstmt.setString(1, userid);
			/*pstmt.setString(1, userid); // ù��° ?�� userid�� �ִ´�.
			//��¥�� �� ������, date�� ����.
			pstmt.setString(2, username);*/
			int result = pstmt.executeUpdate();
			System.out.println(result + "�Ϸ�");
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
