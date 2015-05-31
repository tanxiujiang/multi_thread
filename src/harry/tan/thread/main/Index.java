package harry.tan.thread.main;

import java.sql.Connection;
import java.sql.SQLException;

import harry.tan.thread.db.Pool;

public class Index {

    /**
     * <method description>
     *
     * @param args
     * @throws SQLException 
     */

    public static void main(String[] args) throws SQLException {
        Pool pool = new Pool();
        Connection conn = pool.getConnection();
        conn.close();
        System.out.println("sss");
    }

}
