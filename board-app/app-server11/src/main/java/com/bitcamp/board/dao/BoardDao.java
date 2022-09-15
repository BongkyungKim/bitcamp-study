package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Board;

public interface BoardDao {

  public int insert(Board board) throws Exception;

  public Board findByNo(int no) throws Exception;

  public int update(Board board) throws Exception;

  public int delete(int no) throws Exception;
  // 너무 구체적으로 정하지는 말아라~ 유연성이 떨어진다~
  public List<Board> findAll() throws Exception;

}














