package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.utill.DatabaseUtil;

/**
 * ִ�����ݿ�����Ĺ����ࡣ
 */
public class BaseDao {

    private Connection conn;
    
    public BaseDao(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * ����ɾ���Ĳ���
     * 
     * @param sql
     *            sql���
     * @param prams
     *            ��������
     * @return ִ�н��
     * @throws SQLException 
     */
    protected int executeUpdate(String sql, Object... params) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DatabaseUtil.closeAll(null, pstmt, null);
        }
        return result;
    }

    /**
     * ��ѯ����
     * 
     * @param sql
     *            sql���
     * @param params
     *            ��������
     * @return ��ѯ�����
     * @throws SQLException 
     */
    protected ResultSet executeQuery(String sql, Object... params) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return rs;
    }
}
