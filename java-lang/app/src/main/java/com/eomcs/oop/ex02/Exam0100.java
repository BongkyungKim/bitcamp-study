package com.eomcs.oop.ex02;

public class Exam0100 {
  public static void main(String[] args) {
    String name; // 변수 또는 필드
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    name = "홍길동";
    kor = 100;
    eng = 90;
    math = 85;
    sum = kor + eng + math;
    aver = sum / 3f;

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", name, kor, eng, math,
        sum, aver);

    name = "임꺽정";
    kor = 90;
    eng = 80;
    math = 75;
    sum = kor + eng + math;
    aver = sum / 3f;

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", name, kor, eng, math,
        sum, aver);

    name = "유관순";
    kor = 80;
    eng = 70;
    math = 65;
    sum = kor + eng + math;
    aver = sum / 3f;

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", name, kor, eng, math,
        sum, aver);
  }
}
