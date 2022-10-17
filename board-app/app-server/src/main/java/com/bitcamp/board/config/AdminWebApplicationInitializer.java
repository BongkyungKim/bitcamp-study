package com.bitcamp.board.config;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

// 
// 서블릿 컨테이너에서 웹 애플리케이션을 시작할 때:
// ===> SpringServletContainerInitializer.onStartup() 호출
//      ===> AppWebApplicationInitializer.onStartup() 호출
///         ===> AbstractContextLoaderInitializer.onStartup() 호출
//              ===> registerContextLoaderListener() 호출
//                  ===> createRootApplicationContext() 호출
//          ===> IoC 컨테이너, 프로트 컨트롤러 준비, 필터 준비
//
public class AdminWebApplicationInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {

  // 수퍼클래스에서 Root IoC 컨테이너를 만들어 준단다.
  // 그럼 우리가 해야 할 일은 그 컨테이너가 사용할 클래스 정보만 알려주면 된다.
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected String getServletName() {
    return "admin";
  }

  // 수퍼클래스에서 DispatcherServlet이 사용할 IoC 컨테이너를 만들어 준단다.
  // 그럼 우리가 할 일은 그 컨테이너를 만들 때 사용할 java config 클래스를 알려주면 된다.
  @Override
  protected Class<?>[] getServletConfigClasses() {
    // java config 클래스 정보를 배열에 담아서 리턴한다.
    return new Class<?>[] {AdminWebConfig.class};
  }

  // 수퍼클래스에서 DispatcherServlet 의 URL을 연결할 때 사용할 경로를 리턴한다.
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/admin/*"};
  }

  // 수퍼클래스에서 필터를 등록할 때 사용할 정보를 리턴한다.
  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] {
        new CharacterEncodingFilter("UTF-8"), 
        new LoginCheckFilter(), 
        new AdminCheckFilter()
    };
  }

}
