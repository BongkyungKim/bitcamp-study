package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Board;

public class BoardDaoTest {

  public static void main(String[] args) throws Exception {

    MariaDBBoardDao dao = new MariaDBBoardDao();

    List<Board> list = dao.findAll();

    for (Board b : list) {
      System.out.println(b);
    }
    System.out.println("------------------");
    //
    //    Board board = new Board();
    //    board.title = "aaaaa";
    //    board.content = "bbbbbb";
    //    board.memberNo = 2;
    //
    //    dao.insert(board);

    //    dao.delete(22);

    Board board = new Board();
    board.no = 1;
    board.title = "xxxx";
    board.content = "okokok";
    dao.update(board);

    Board board2 = dao.findByNo(12);
    System.out.println(board2);

    //    Board member2 = dao.findByNo(1);
    //    System.out.println(member2);

    list = dao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }
    System.out.println("------------------");

  }
}
