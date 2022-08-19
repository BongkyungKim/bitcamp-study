package com.bitcamp.board.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import com.bitcamp.board.domain.Member;

public class MemberDaoProxyTest {

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("127.0.0.1", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      MemberDaoProxy memberDao = new MemberDaoProxy("member", in, out);

      // 테스트1) 목록 가져오기
      Member[] members = memberDao.findAll();
      for (Member b : members) {
        System.out.println(b);
      }
      System.out.println("--------------------------------");

      // 테스트2) 상세 데이터 가져오기
      Member member = memberDao.findByEmail();
      System.out.println(member);
      System.out.println("--------------------------------");


      //      // 테스트3) 데이터 등록하기
      //      board = new Board();
      //      board.title = "xxxx";
      //      board.content = "xxxxxxxxxx";
      //      board.viewCount = 11;
      //      board.createdDate = System.currentTimeMillis();
      //      board.writer = "hong";
      //      board.password = "1111";
      //
      //      System.out.println(boardDao.insert(board));
      //      System.out.println("--------------------------------");
      //
      //
      //      // 데이터 등록 확인
      //      boards = boardDao.findAll();
      //      for (Board b : boards) {
      //        System.out.println(b);
      //      }
      //      System.out.println("--------------------------------");
      //
      //      // 테스트4) 데이터 변경하기
      //      board = boardDao.findByNo(3);
      //      board.title = "okoko";
      //      board.content = "nononono";
      //      System.out.println(boardDao.update(board));
      //      System.out.println("--------------------------------");
      //
      //      // 데이터 변경 확인
      //      board = boardDao.findByNo(3);
      //      System.out.println(board);
      //      System.out.println("--------------------------------");
      //
      //      // 테스트5)데이터 삭제하기
      //      System.out.println(boardDao.delete(3));
      //      System.out.println("--------------------------------");
      //
      //      // 데이터 삭제 확인
      //      boards = boardDao.findAll();
      //      for (Board b : boards) {
      //        System.out.println(b);
      //      }
      //      System.out.println("--------------------------------");

      out.writeUTF("exit");
    }
  }
}
