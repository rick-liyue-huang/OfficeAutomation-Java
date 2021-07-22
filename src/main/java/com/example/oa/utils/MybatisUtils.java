package com.example.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
//			初始化过程中产生的异常
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Object executeQuery(Function<SqlSession, Object> func) {
		{
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Object obj = func.apply(sqlSession);
			try {
				sqlSession.close();
				return obj;
			} finally {
				sqlSession.close();
			}
		}
	}

	/**
	 * 执行INSERT/UPDATE/DELETE
	 * @param func 要执行的代码块
	 * @return 返回的结果
	 */
	public static Object executeUpdate(Function<SqlSession, Object> func) {
//		代表手动提交或者回滚事务
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			Object obj = func.apply(sqlSession);
			sqlSession.commit();
			return obj;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
	}
}
