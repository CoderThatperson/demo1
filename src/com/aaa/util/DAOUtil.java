package com.aaa.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/***
 * DAO的 工具包
 * DAO 封装
	 * 1  数据库 加载驱动 和 建立连接 都需要 所以 抽取到 工具类
	 *   A 为什么是static     
	 *   B 为什么 需要返回值 Connection 
	 *   C 为什么需要return null
	 * 2 数据库资源关闭 代码也重复 抽取到工具类中
	 * 3 将加载驱动的代码写到 静态代码块中 因为 加载驱动没必要 每次调用都加载
	 * 4 增删改的代码 基本上一样
	 *   A  sql 
	 *   B  预处理的占位符替换数据 个数 内容
	 * 
	 * 5 可变参数  就是一个数组 Object...  Object[]
	 *    可变参数必须在参数列表的最后
 *
 */

public class DAOUtil {
	
	private static DataSource dataSource;
	static {
		try {
			Properties p = new Properties();
			p.load(DAOUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 加载驱动和获取连接对象
	 */
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static void executeUpdate(String sql,Object...  obj){
		Connection conn =  null;
		PreparedStatement ps = null;
        try {
			conn = DAOUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源化
			close(null, ps, conn);
		}
	}
	
	/***
	 *  只负责查询 并将查询的结果返回 
	 * @param sql
	 * @param obj
	 * @return   List<Map>
	 */
	public static  List< Map<String,  Object> >  executeQuery(String sql,Object... obj){
		Connection conn =  null;
		PreparedStatement ps = null;
		ResultSet set = null;
		try {
			conn = DAOUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			set = ps.executeQuery();//不一样的表 查询出来的 set 不一样
			
			int count = set.getMetaData().getColumnCount();
			
			List<Map<String,  Object>> list = new ArrayList<>();
			while(set.next()){
				 Map<String,Object> map = new HashMap<>();//每一行都创建一个map 从来存储该行数据
				 // 从set中取出数据 存储到map中 ？ 问题： 表不一样 列名就不一样  如何通用的从set中取出数据呢？ 可以根据序号取出数据    问题： 我们怎么知道本次结果集有多少列？  int count = set.getMetaData().getColumnCount();      
				 for(int i=1;i<=count;i++){
					 Object value = set.getObject(i);
					 String key = set.getMetaData().getColumnName(i);
					 map.put(key, value);
				 }
				 // 将 map  添加到 list中
				 list.add(map);
			}
		   return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(set, ps, conn);
		}
		return null;
	}
	
    public static  <T>  List<T> seelectList(String sql,Class<T> c,Object... args){
		     
    	    List < Map <String, Object> > data = executeQuery(sql, args);
	
			List <T> list = new ArrayList <>();
			
			for (Map <String, Object> map : data) {
				try {
					T obj = c.newInstance();//反射创建c类型的对象   User obj = new User()
					BeanInfo info = Introspector.getBeanInfo(obj.getClass());//javabean内省机制获取c这个类的信息
					PropertyDescriptor[] pro = info.getPropertyDescriptors();//获取c这个类的属性列表
					//遍历所有的属性
					for (PropertyDescriptor p : pro) {
						String  name = p.getName();//获取属性的名字
						//根据属性名去set中取数据并判断是否取到数据
						if( map.get(name) != null){
							//如果取到 就调用该属性的set方法 将获取的value赋值给该属性
							p.getWriteMethod().invoke(obj, map.get(name));
						}
					}
					//将封装后的实体对象放入到list 中
					list.add(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
			return list;
		
	}

	
	
	
	/**
	 * 关闭连接
	 */
	public static void close(ResultSet set, Statement st, Connection conn) {
		try {
			if (set != null) {
				set.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


}
