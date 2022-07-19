package com.eomcs.quiz.ex01;

// [문제] 
// 파라미터로 주어진 정수 값을 2진수로 표현했을 때 1로 설정된 비트의 개수를 구하라!
// [훈련 목표]
// - 비교 연산자 및 비트 연산자 활용
// - 반복문 활용
// - 메서드 파라미터 및 리턴 값 다루기
//
public class Test01 {

  public static void main(String[] args) {
    int c = countBits(0b01100011);
    System.out.println(c == 4); // true

    c = countBits(0b01010111_01100011);
    System.out.println(c == 9); // true
  }

  static int countBits(int value) {
    int r = 0;
    // 이 메서드를 완성하시오!
    while (value != 0) {
      r += (value & 1); // 1 , 최하위 0번 비트 추출하는(value & 1)
      value >>>= 1;
    }
    return r;
  }
}

//String a = "";
//int b = 0;
//a = Integer.toBinaryString(value);
//for (int i = 0; i < a.length() ;i++) {
//  b = a.charAt(i);
//  if (b == 1) {
//    r = b;
//  }
//}
