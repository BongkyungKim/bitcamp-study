package com.bitcamp.board.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
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
public class AppWebApplicationInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {

  // 수퍼클래스에서 Root IoC 컨테이너를 만들어 준단다.
  // 그럼 우리가 해야 할 일은 그 컨테이너가 사용할 클래스 정보만 알려주면 된다.
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] {RootConfig.class, DatabaseConfig.class, MybatisConfig.class};
  }

  @Override
  protected String getServletName() {
    return "app";
  }

  // 수퍼클래스에서 DispatcherServlet이 사용할 IoC 컨테이너를 만들어 준단다.
  // 그럼 우리가 할 일은 그 컨테이너를 만들 때 사용할 java config 클래스를 알려주면 된다.
  @Override
  protected Class<?>[] getServletConfigClasses() {
    // java config 클래스 정보를 배열에 담아서 리턴한다.
    return new Class<?>[] {AppWebConfig.class};
  }

  // 수퍼클래스에서 DispatcherServlet 의 URL을 연결할 때 사용할 경로를 리턴한다.
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }

  // 수퍼클래스에서 필터를 등록할 때 사용할 정보를 리턴한다.
  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] {
        new CharacterEncodingFilter("UTF-8"), 
        new LoginCheckFilter()
    };
  }

  // 수퍼클래스에서 DispatcherServlet 을 준비할 때 추가적으로 설정할 것이 있으면 설정한다.
  @Override
  protected void customizeRegistration(Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement(
        System.getProperty("java.io.tmpdir"), // 클라이언트가 보낸 파일을 임시 저장할 디렉토리
        1024 * 1024 * 5, // 한 개 파일의 최대 크기
        1024 * 1024 * 10, // 첨부 파일을 포함한 전체 요청 데이터의 최대 크기
        1024 * 1024 // 첨부 파일 데이터를 일시적으로 보관할 버퍼 크기
        ));
  }
}