package harry.tan.thread.db;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class Pool implements DataSource {
    private static LinkedList<Connection> connections  = new LinkedList<Connection>();
    private final static String           DBDrive      = "com.mysql.jdbc.Driver";
    private final static String           DBUrl        = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
    private final static String           DBUser       = "root";
    private final static String           DBPassword   = "123456";
    private final static int              minSize      = 20;
    private final static String           CLOSE_METHOD = "close";
    static {
        try {
            Class.forName(DBDrive);
            for (int i = 0; i < minSize; i++) {
                final Connection conn = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
                Connection connection = (Connection) Proxy.newProxyInstance(Pool.class.getClassLoader(),
                        new Class[] { Connection.class }, new InvocationHandler() {

                            @Override
                            public Object invoke(Object pProxy, Method pMethod, Object[] pArgs) throws Throwable {
                                if (pMethod != null && pMethod.getName().equals(CLOSE_METHOD)) {
                                    connections.addLast(conn);
                                    System.out.println("    回收资源成功……");
                                    return null;
                                } else {
                                    return pMethod.invoke(conn, pArgs);
                                }
                            }
                        });

                connections.add(connection);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

        }

    }



    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }



    @Override
    public void setLogWriter(PrintWriter pOut) throws SQLException {
        // TODO Auto-generated method stub

    }



    @Override
    public void setLoginTimeout(int pSeconds) throws SQLException {
        // TODO Auto-generated method stub

    }



    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public <T> T unwrap(Class<T> pIface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public boolean isWrapperFor(Class<?> pIface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public Connection getConnection() throws SQLException {
        if (connections.size() > 0) {
            return connections.removeFirst();
        } else {
            // 继续创建连接
            
            throw new RuntimeException("the database is busy");
        }
    }



    @Override
    public Connection getConnection(String pUsername, String pPassword) throws SQLException {
        return null;
    }

    public synchronized Connection getConn() throws SQLException{
        System.out.println("获取资源连接……");
        return this.getConnection();
    }



	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
}
