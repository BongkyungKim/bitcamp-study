package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.testDomain.ScoreTest2;

public class ExamTest {


  public static void main(String[] args) {

    ScoreTest2 s1 = new ScoreTest2("홍길동", 100, 90, 85);
    printScore(s1);

    ScoreTest2 s2 = new ScoreTest2("임꺽정", 90, 80, 75);
    printScore(s2);

    ScoreTest2 s3 = new ScoreTest2("유관순", 80, 70, 65);
    printScore(s3);
  }

  static void printScore(ScoreTest2 s) {

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math,
        s.sum, s.aver);
  }


}
