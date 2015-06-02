package harry.tan.thread.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    private static Pool pool = new Pool();



    public DBManager() {

    }



    /**
     * 
     * <method description> 执行插入
     * 
     * @return
     */
    public void executeUpdate(String sql, Object... objects) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = pool.getConn();
            statement = conn.prepareStatement(sql);
            if (statement.getParameterMetaData().getParameterCount() != objects.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i + 1, objects[i]);
            }

            statement.execute();
            // System.out.println("     "+Thread.currentThread().getName()+"执行插入操作!");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            this.release(conn, statement, null);
        }
    }



    /**
     * release source
     * 
     * @param conn
     * @param st
     * @param rs
     */
    public void release(Connection conn, Statement st, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("release resultSet is failed");
            }
        }
        if (null != st) {
            try {
                st.close();
            } catch (SQLException e) {
                System.err.println("release statement is failed");
            }
        }

        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("release connection is failed");
            }
        }
    }

}
