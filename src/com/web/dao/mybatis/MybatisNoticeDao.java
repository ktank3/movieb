package com.web.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web.dao.NoticeDao;
import com.web.entities.Notice;
import com.web.model.NoticeModel;

public class MybatisNoticeDao implements NoticeDao {
	
	SqlSessionFactory ssf;
	
	public MybatisNoticeDao(){
		ssf = WebSessionFactoryBuilder.getSqlsessionFactory();
		
	}

	@Override
	public Notice get(String code){
		SqlSession session= ssf.openSession();
		NoticeDao noticedao = session.getMapper(NoticeDao.class);
		return noticedao.get(code);
	}

	@Override
	public List<NoticeModel> getList(int page, String field, String query){
		SqlSession session= ssf.openSession();
		NoticeDao noticedao = session.getMapper(NoticeDao.class);
		
		return noticedao.getList(page,field,query);
	}

	@Override
	public List<NoticeModel> getList(int page){
	
		return getList(page,"TITLE","");
	}
	@Override
	public List<NoticeModel> getList(){
		return getList(1,"TITLE","");
	}


	@Override
	public int insert(Notice notice){
		SqlSession session= ssf.openSession();
		NoticeDao noticedao = session.getMapper(NoticeDao.class);
		int result=noticedao.insert(notice);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int update(Notice notice){
		SqlSession session= ssf.openSession();
		NoticeDao noticedao = session.getMapper(NoticeDao.class);
		int result=noticedao.update(notice);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code){
		SqlSession session= ssf.openSession();
		NoticeDao noticedao = session.getMapper(NoticeDao.class);
		int result =noticedao.delete(code);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session= ssf.openSession();
		NoticeDao noticedao = session.getMapper(NoticeDao.class);
		int result = noticedao.getCount(field, query);
		session.close();
		return result;
		
	}


}
