package com.bitcamp.board.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configurable // 설정에 관련된 클래스이니 이 클래스 객체를 만들어주라~~ 아래 설정으로~
@Component
public class AppWebConfig {

  public AppWebConfig() {
    System.out.println("AppWebConfig() 생성자 호출됨!");
  }

  // multipart/form-data 형식으로 보내온 요청 데이터를
  //  도메인 객체로 받는 일을 할 도우미 객체를 등록한다.
  // 이 객체가 등록된 경우 multipart/form-data 를 도메인 객체로 받을 수 있다.
  @Bean
  public MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }

  // Spring WebMVC의 기본 ViewResolver를 교체한다.
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class); // 주어진 URL을 처리할 객체 => JSP 실행시켜주는 객체
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");

    return viewResolver;
  }
}







