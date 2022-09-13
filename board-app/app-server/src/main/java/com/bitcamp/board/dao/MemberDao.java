package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Member;

// MemberDao와 통신을 담당할 대행 객체
//
public interface MemberDao {

  public int insert(Member member) throws Exception;

  public Member findByNo(int no) throws Exception;

  public int update(Member member) throws Exception;

  public int delete(int no) throws Exception;

  // 너무 구체적으로 정하지는 말아라~ 유연성이 떨어진다~
  public List<Member> findAll() throws Exception;

}














