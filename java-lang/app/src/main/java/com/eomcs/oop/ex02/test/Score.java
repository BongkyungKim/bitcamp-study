package com.eomcs.oop.ex02.test;

public class Score {
  String name; // 변수 또는 필드
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

}
