/**
 * 
 */
package com.revanwang.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 3, 20199:58:05 AM
 */
public class JdbcUtil {
	
	private static DataSource dataSource = null;
	
	/**
	 * 私有化构造器
	 */
	private JdbcUtil() {}
	
	//静态代码块
	static {
		ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = clzLoader.getResourceAsStream("db.properties");
		Properties p = new Properties();
		try {
			p.load(inStream);
			
			//使用连接池
			dataSource = DruidDataSourceFactory.createDataSource(p);
			
			//加载驱动
			/*Class.forName(p.getProperty("driverClassName"));
			connection = DriverManager.getConnection(
					p.getProperty("url"), 
					p.getProperty("username"), 
					p.getProperty("password")
					);*/
		} catch (Exception e) {
			throw new RuntimeException("加载classpath配置文件失败");
		}
	}

	/**
	 * @Desc	获取连接对象
	 * @return
	 * @auther Revan Wang
	 * @Date May 14, 20197:56:36 PM
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection connection, Statement ps, ResultSet reSet) {
		try {
			if (reSet != null) {
				reSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
