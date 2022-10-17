package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

//@ComponentScan // 패키지 이름 및 하위 패키지를 뒤져서 객체 생성
// 스프링 IoC 컨테이너의 설정을 수행하는 클래스
// 1) DB 커넥션 객체 관리자 준비 : DataSource
// 2) 트랜잭션 관리자 준비: PlatformTransactionManager
// 3) 어떤 패키지에 있는 객체를 자동으로 생성할 것인지 지정한다.

public class DatabaseConfig {

  public DatabaseConfig() {
    System.out.println("DatabaseConfig() 생성자 호출됨!");
  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource ds) {
    System.out.println("PlatformTransactionManager 객체 생성!");
    return new DataSourceTransactionManager(ds);
  }

  @Bean
  public DataSource dataSource() {
    System.out.println("DataSource 객체 생성!");

    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.mariadb.jdbc.Driver");
    ds.setUrl("jdbc:mariadb://localhost:3306/studydb");
    ds.setUsername("study");
    ds.setPassword("1111");

    return ds;
  }
}







