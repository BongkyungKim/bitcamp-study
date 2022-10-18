package com.bitcamp.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bitcamp.board.domain.Member;

@Repository // DAO 역할을 수행하는 객체에 붙이는 애노테이션
public class MybatisMemberDao implements MemberDao {

  //  @Autowired DataSource ds; // required = false 있으면 꼽 없으면 놉
  @Autowired SqlSessionFactory sqlSessionFactory;

  //  public MybatisMemberDao(DataSource ds, SqlSessionFactory sqlSessionFactory) {
  //    System.out.println("MybatisMemberDao() 호출됨!");
  //    this.ds = ds;
  //    this.sqlSessionFactory = sqlSessionFactory;
  //  }

  @Override
  public int insert(Member member) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      return sqlSession.insert("MemberDao.insert", member);
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("MemberDao.findByNo", no);
    }
  }

  @Override
  public int update(Member member) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      return sqlSession.update("MemberDao.update", member);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      return sqlSession.delete("MemberDao.delete", no);
    }
  }

  @Override
  public List<Member> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      return sqlSession.selectList("MemberDao.findAll");
    }
  }

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {

      Map<String, Object> paramMap = new HashMap<>();
      paramMap.put("email", email);
      paramMap.put("password", password);

      return sqlSession.selectOne( // selectOne인 이유는 where 조건이 들어가서 어차피 하나만 리
          "MemberDao.findByEmailPassword", // SQL 문의 ID
          paramMap // SQL 문의 in-parameter(#{})에 들어 갈 값을 담고 있는 객체
          );
    }
  }
}




