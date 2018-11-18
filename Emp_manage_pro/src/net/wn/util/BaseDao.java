package net.wn.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BaseDao<T> {

	public void insert(String sql,Object ... params) throws SQLException {
		Connection conn = ConnectDb.Connect();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		// 执行SQL插入
		int n = qRunner.update(conn, sql,params);
		System.out.println("成功插入" + n + "条数据！");
		// 关闭数据库连接
		DbUtils.closeQuietly(conn);
	}
	
	public void delete(String sql,Object ... param) throws SQLException {
		Connection conn = ConnectDb.Connect();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		// 执行SQL插入
		int n = qRunner.update(conn, sql, param);
		System.out.println("删除成功" + n + "条数据！");
		// 关闭数据库连接
		DbUtils.closeQuietly(conn);
	}
	
	public void updata(String sql,Object ... param) throws SQLException {
		Connection conn = ConnectDb.Connect();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		// 执行SQL插入
		int n = qRunner.update(conn, sql, param);
		System.out.println("成功更新" + n + "条数据！");
		// 关闭数据库连接
		DbUtils.closeQuietly(conn);
	}
	
	public List<T> getAll(String sql,Class<T> myclass) throws Exception{
		Connection conn = ConnectDb.Connect();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		List<T> list = (List<T>) qRunner.query(conn, sql,new BeanListHandler<T>(myclass));
		// 关闭数据库连接
		DbUtils.closeQuietly(conn);
		return list;
	}
	
	public T getOne(String sql,Class<T> myclass,Object ... param) throws SQLException {
		Connection conn = ConnectDb.Connect();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) qRunner.query(conn, sql,new BeanListHandler<Object>(myclass),param);
		T t = null!=list && list.size()>0 ? list.get(0):null;
		System.out.println(t);
		// 关闭数据库连接
		DbUtils.closeQuietly(conn);
		return t;
	}
	
}
