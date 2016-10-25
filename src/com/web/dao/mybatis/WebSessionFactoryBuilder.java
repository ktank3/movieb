package com.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class WebSessionFactoryBuilder {
	
	static String src="com/web/dao/mybatis/config.xml";//������ġ�� �����δ� ��������̾ƴϴ�.->����ΰ� ����
	static SqlSessionFactory ssf =null;
	static{
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ssf = new SqlSessionFactoryBuilder().build(is);
		
	}
	public static SqlSessionFactory getSqlsessionFactory() {
		// TODO Auto-generated method stub
		return ssf;
	}
	



}
