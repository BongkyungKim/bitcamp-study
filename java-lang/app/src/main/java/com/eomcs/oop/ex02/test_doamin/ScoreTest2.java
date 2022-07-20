package com.eomcs.oop.ex02.test_doamin;

public class ScoreTest2 {

  public String name; // 변수 또는 필드
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public ScoreTest2(String n, int k, int e, int m) {
    this.name = n;
    this.kor = k;
    this.eng = e;
    this.math = m;

    this.compute();

  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

}
