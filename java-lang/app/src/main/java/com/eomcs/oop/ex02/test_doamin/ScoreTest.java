package com.eomcs.oop.ex02.test_doamin;

public class ScoreTest {
  public String name; // 변수 또는 필드
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

}
