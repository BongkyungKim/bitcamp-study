# 051. Application Server 구조로 전환하기

## 작업 내용

### 1단계 - app-client 프로젝트를 복사하여 app-server 프로젝트로 만든다.

- build.gradle 변경
  - 이클립스 프로젝트 이름을 'board-app-server'로 변경
  - application 메인 클래스를 ServerApp 으로 변경

### 2단계 - 메인 클래스의 이름을 'ServerApp'으로 변경한다.

- com.bitcamp.board.ServerApp 클래스 이름 변경

### 3단계 - 클라이언트와 통신 프로토콜을 정의한다.

```
[client] <---------------------> [server]
   |---- 접속 ---------------------->|
   |<----- 환영 메시지 --------------|
   |---- 사용자 입력 전송(요청) ---->|
   |<----- 응답 메시지 --------------|
   |         요청/응답 반복          |
   |---- "quit" -------------------->| 
   |          연결 끊기              |

                   
```

```
요청 메시지:
  한 덩어리의 문자열

응답 메시지: 
  한 덩어리의 문자열

```

### 4단계 - 통신 프로토콜에 따라 클라이언트의 요청을 처리한다.

- com.bitcamp.board.ServerApp 클래스 변경