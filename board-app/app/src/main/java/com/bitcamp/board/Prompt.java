/*
 * 게시판 관리 애플리케이션
 * 비트캠프 2022-07-04
 */
package com.bitcamp.board;

public class Prompt {

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  // 메서드를 통해 특정 코드의 복잡함을 감출 수 있다. ==> encapsulation(캡슐화)
  static int inputInt() {
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str); // "123" ==> 123, "5" ==> 5
  }

  static int inputInt(String title) {
    System.out.print(title);
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  //
  //  static int inputInt(String title) {
  //    System.out.print(title);
  //    return keyboardInput.nextInt();
  //  }

  static String inputString() {
    return keyboardInput.nextLine();
  }

  static String inputString(String title) {
    System.out.print(title);
    return keyboardInput.nextLine();
  }

  static void close() {
    keyboardInput.close();
  }
}