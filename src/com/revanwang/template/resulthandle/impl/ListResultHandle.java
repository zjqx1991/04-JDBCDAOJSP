/**
 * 
 */
package com.revanwang.template.resulthandle.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revanwang.template.resulthandle.IResultHandle;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 3, 201911:29:50 AM
 */
public class ListResultHandle<T> implements IResultHandle<List<T>> {

	private Class<T> clazz = null;
	
	public ListResultHandle(Class<T> clz) {
		this.clazz = clz;
	}
	
	@Override
	public List<T> resultHandle(ResultSet resultSet) {
		List<T> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				//1、实例对象
				T objT = this.clazz.newInstance();
				//2、内省机制
				BeanInfo info = Introspector.getBeanInfo(this.clazz, Object.class);
				PropertyDescriptor[] pds = info.getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					String propertyString = pd.getName();
					Object value = resultSet.getObject(propertyString);
					pd.getWriteMethod().invoke(objT, value);
				}
				list.add(objT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
