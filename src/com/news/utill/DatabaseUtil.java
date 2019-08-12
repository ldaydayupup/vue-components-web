package com.news.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ�������رչ����ࡣ
 
 */
public class DatabaseUtil {
    private static String driver = ConfigManager.getProperty("driver");// ���ݿ������ַ���
    private static String url = ConfigManager.getProperty("url");// ����URL�ַ���
    private static String user = ConfigManager.getProperty("user"); // ���ݿ��û���
    private static String password = ConfigManager.getProperty("password"); // �û�����

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ݿ����Ӷ���
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        // ��ȡ���Ӳ������쳣
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return conn;// �������Ӷ���
    }

    /**
     * �ر����ݿ����ӡ�
     * 
     * @param conn
     *            ���ݿ�����
     * @param stmt
     *            Statement����
     * @param rs
     *            �����
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // �����������Ϊ�գ���ر�
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ��Statement����Ϊ�գ���ر�
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // �����ݿ����Ӷ���Ϊ�գ���ر�
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
