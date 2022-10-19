package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan // 패키지 이름 및 하위 패키지를 뒤져서 객체 생성
// 스프링 IoC 컨테이너의 설정을 수행하는 클래스
// 1) DB 커넥션 객체 관리자 준비 : DataSource
// 2) 트랜잭션 관리자 준비: PlatformTransactionManager
// 3) 어떤 패키지에 있는 객체를 자동으로 생성할 것인지 지정한다.

// @Transactional 애노테이션으로 사용하여 트랜잭션을 제어할 수 있게 기능을 활성화시킨다.
@EnableTransactionManagement

// JDBC 프로퍼티 값이 저장되어 있는 .properties 파일을 로딩한다.
@PropertySource("classpath:com/bitcamp/board/config/jdbc.properties")
public class DatabaseConfig {

  public DatabaseConfig() {
    System.out.println("DatabaseConfig() 생성자 호출됨!");
  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource ds) {
    System.out.println("PlatformTransactionManager 객체 생성!");
    return new DataSourceTransactionManager(ds);
  }

  // ${jdbc.url} ==> .properties 파일에서 jdbc.url 이름으로 저장된 값을 가져온다.
  // @Value("....") ==> 애노테이션에 지정된 문자열을 파라미터 변수에 전달한다.
  @Bean
  public DataSource dataSource(
      @Value("${jdbc.driverClassName}") String driverClassName, 
      @Value("${jdbc.url}")String url, 
      @Value("${jdbc.username}")String username,
      @Value("${jdbc.password}")String password) {
    System.out.println("DataSource 객체 생성!");

    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(driverClassName);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);

    return ds;
  }
}







