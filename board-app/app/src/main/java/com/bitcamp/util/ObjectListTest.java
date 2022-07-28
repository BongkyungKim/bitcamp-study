package com.bitcamp.util;

public class ObjectListTest {
  public static void main(String[] args) throws Throwable {

    ObjectList list = new ObjectList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add(null); // 목록에 null을 넣을 수 있다.
    list.add("안중근");

    System.out.println(list.get(0)); // obj가 실제 가리키는 것은 String 클래스다.
    System.out.println(list.get(1)); // "임꺽정"
    System.out.println(list.get(2)); // "유관순"
    System.out.println(list.get(4)); // "안중근" 

    // 3번 인덱스에 null 들어 있기 때문에 꺼낸 값도 null이다.
    System.out.println(list.get(3)); // println()에 전달하는 값이 null이면 "null"이라고 출력한다.

    // 100번 인덱스는 유효한 인덱스가 아니기 때문에 get() 메서드가 null을 리턴한다.
    System.out.println(list.get(100));

    // println()
    // - 파라미터 값이 유효한 인스턴스 주소라면 toString()을 호출하여 그 리턴 값을 출력한다.
    // 따라서 굳이 toString()을 명시적으로 호출할 필요가 없다.

    // - 파라미터 값이 null 이라면 그대로 null을 출력한다.

    // 생각해 볼 문제!
    // - get()이 null을 리턴한다면,
    //   예외 상황인가? 아니면 그냥 정상적인 상황인가?

    // 결론!
    // - 알 수 없다.
    // - 리턴 값으로는 정상과 예외 상황을 표현할 수 없다.
    // - 리턴 값으로 두 상황을 구분할 수 없다.
    // 해결책!
    // - 정상적인 경우는 정상적으로 해당 값을 리턴한다.
    // - 예외 상황일 경우에는 예외 정보를 던진다. 예외를 발생시킨다.


  }
}




