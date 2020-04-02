package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberVo;


public class DbManager {
	
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader =  Resources.getResourceAsReader("com/example/demo/db/sqlmapconfig.xml");
		    factory = new SqlSessionFactoryBuilder().build(reader);
		    reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static MemberVo selectMember(String username){
		SqlSession session = factory.openSession();
		MemberVo m = session.selectOne("member.selectMember", username);
		session.close();
		return m;
	}
	
	public static int insertMember(MemberVo m){
		SqlSession session = factory.openSession();
		int re = session.insert("member.insert", m);
		session.commit();
		session.close();
		return re;
	}
	
	
}
