package com.alibaba.druid.atest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.pool.DruidPooledStatement;

public class TestDruid {
	
	private static DruidDataSource source;
	
	static{
		Properties properties =  new Properties();
		try {
			loadPropertyFile(properties,TestDruid.class.getClassLoader());
			source=(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		DruidPooledConnection conn=source.getConnection();
		DruidPooledStatement statment=(DruidPooledStatement) conn.createStatement();
		 ResultSet rs = statment.executeQuery("select * from people");
		   while(rs.next()){
		     int id = rs.getInt("id");
		     String name = rs.getString("name");
		     int age = rs.getInt("age");
		     String sex = rs.getString("sex");
		     System.out.print("ID: " + id);
		     System.out.print("| name: " + name);
		     System.out.print("| age: " + age);
		     System.out.println("| sex: " + sex);
		   }
		   conn.recycle();
		   conn.close();
	}
	
	
	private static void execute() throws Exception{
		DruidPooledConnection conn=source.getConnection();
		DruidPooledStatement statment=(DruidPooledStatement) conn.createStatement();
		 ResultSet rs = statment.executeQuery("select * from people");
		   while(rs.next()){
		     int id = rs.getInt("id");
		     String name = rs.getString("name");
		     int age = rs.getInt("age");
		     String sex = rs.getString("sex");
		     System.out.print("ID: " + id);
		     System.out.print("| name: " + name);
		     System.out.print("| age: " + age);
		     System.out.println("| sex: " + sex);
		   }
		   conn.recycle();
	}
	
	  private static void loadPropertyFile(Properties filterProperties, ClassLoader classLoader) throws IOException {
	        if (classLoader == null) {
	            return;
	        }
	        for (Enumeration<URL> e = classLoader.getResources("META-INF/druid.properties"); e.hasMoreElements();) {
	            URL url = e.nextElement();
	            Properties property = new Properties();
	            InputStream is = null;
	            try {
	                is = url.openStream();
	                property.load(is);
	            } finally {
	            	is.close();
	            }
	            filterProperties.putAll(property);
	        }
	    }

}
