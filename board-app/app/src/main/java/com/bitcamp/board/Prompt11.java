/*
 * 키보드 입력을 받는 도구를 구비하고 있다.
 * 비트캠프 2022-07-04
 */
package com.bitcamp.board;

public class Prompt {

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  // 메서드를 통해 특정 코드의 복잡함을 감출 수 있다. ==> encapsulation(캡슐화)
  static int inputInt() {
    // 사용자로부터 메뉴 번호를 입력 받
    // 방법 1:
    /*
    String input = keyboardInput.nextLine();
    return Integer.parseInt(input);
    */

    // 방법 2:
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str); // "123" ==> 123, "5" ==> 5
  }

  static String inputString() {
    return keyboardInput.nextLine();
  }

  static void close() {
    keyboardInput.close();
  }
}