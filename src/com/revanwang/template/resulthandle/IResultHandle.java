/**
 * 
 */
package com.revanwang.template.resulthandle;

import java.sql.ResultSet;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 3, 201911:27:02 AM
 */
public interface IResultHandle<T> {

	/**
	 * @Desc 处理JDBC结果集
	 * @param resultSet
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 3, 201911:28:46 AM
	 */
	T resultHandle(ResultSet resultSet);
}
