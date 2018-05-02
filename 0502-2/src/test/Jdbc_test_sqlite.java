package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_test_sqlite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;

		try
		{
			/* SQLite JDBC 클래스가 있는지 검사하는 부분입니다. */
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("org.sqlite.JDBC를 찾지 못했습니다.");
		}

		/* Program.class와 같은 디렉터리에 있는 test.db를 엽니다. */
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* 연결 성공했을 때, connection으로부터 statement 인스턴스를 얻습니다. 여기서 SQL 구문을 수행합니다. */
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* 아래는 SQL 예시입니다. */
		/* Table1이라는 테이블 안에 field1(text형), field2(integer형)라는 이름의 필드가 있다고 가정합니다. */
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery("select * from Table1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* 결과를 첫 행부터 끝 행까지 반복하며 출력합니다. */
		try {
			while(resultSet.next())
			{
				System.out.printf("\"%s\",\"%s\",\"%s\",\"%d\",\"%d\",\"%d\"\n", new Object[] { resultSet.getString("field1"), new Integer(resultSet.getInt("field2")) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* resultSet 닫기 */
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* DB와의 연결 닫기 */
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
