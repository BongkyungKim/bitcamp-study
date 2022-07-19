package com.eomcs.oop.ex02.domain;

// 다른 패키지에서도 사용할 수 있도록 public 으로 공개한다.
public class Score2 {

  //다른 패키지에서 이 설계도에 따라 만든 변수에 접근할 수 있도록
  //접근 범위를 넓힌다.

  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  //new 연산자를 이용하여 인스턴스를 만들 때 자동으로 호출되는 메서드
  // => 생성자
  //   - 메서드명은 클래스 이름과 같아야 한다.
  //   - 리턴 타입은 없다.
  //   - 오직 new 명령을 호출할
  public Score2(String n, int k, int e, int m) {
    this.name = n;
    this.kor = k;
    this.eng = e;
    this.math = m;

    this.compute();
  }

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}
