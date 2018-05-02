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
			/* SQLite JDBC Ŭ������ �ִ��� �˻��ϴ� �κ��Դϴ�. */
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("org.sqlite.JDBC�� ã�� ���߽��ϴ�.");
		}

		/* Program.class�� ���� ���͸��� �ִ� test.db�� ���ϴ�. */
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* ���� �������� ��, connection���κ��� statement �ν��Ͻ��� ����ϴ�. ���⼭ SQL ������ �����մϴ�. */
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* �Ʒ��� SQL �����Դϴ�. */
		/* Table1�̶�� ���̺� �ȿ� field1(text��), field2(integer��)��� �̸��� �ʵ尡 �ִٰ� �����մϴ�. */
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery("select * from Table1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* ����� ù ����� �� ����� �ݺ��ϸ� ����մϴ�. */
		try {
			while(resultSet.next())
			{
				System.out.printf("\"%s\",\"%s\",\"%s\",\"%d\",\"%d\",\"%d\"\n", new Object[] { resultSet.getString("field1"), new Integer(resultSet.getInt("field2")) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* resultSet �ݱ� */
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* DB���� ���� �ݱ� */
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
