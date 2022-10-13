package com.bitcamp.board.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/auth/")
public class AuthController {

  MemberService memberService;

  public AuthController(MemberService memberService) {
    this.memberService = memberService;
  }

  // InternalResourceViewResilver 설정 전
  //  @GetMapping("form")
  //  //  @RequestMapping(value="form", method=RequestMethod.GET)
  //  public View form() throws Exception {
  //    return new JstlView("/auth/form.jsp");
  //  }

  //  InternalResourceViewResilver 설정 
  @GetMapping("form")
  //  @RequestMapping(value="form", method=RequestMethod.GET)
  public String form() throws Exception {
    return "auth/form";
  }

  @PostMapping("login")
  // value나 path나 같다.
  //  @RequestMapping(path="login", method=RequestMethod.POST)
  public ModelAndView login(
      String email, 
      String password, 
      String saveEmail, 
      HttpServletResponse response, 
      HttpSession session) throws Exception {

    Member member = memberService.get(email, password);

    if (member != null) {
      session.setAttribute("loginMember", member); // 로그인한 멤버 정보를 세션 보관소에 저장
    }

    // 클라이언트에게 쿠키 보내기
    // - 쿠키 데이터는 문자열만 가능
    Cookie cookie = new Cookie("email", email); // 클라이언트 쪽에 저장할 쿠키 생성
    if (saveEmail == null) {
      cookie.setMaxAge(0); // 클라이언트에게 해당 이름의 쿠키를 지우라고 명령한다.
    } else {
      // 쿠키의 지속시간을 설정하지 않으면 웹브라우저가 실행되는 동안만 유효하다.
      // 만약 웹브라우저를 종료하더라도 쿠키를 유지하고 싶다면,
      // 지속 시간을 설정해야 한다.
      cookie.setMaxAge(60 * 60 * 24 * 7); // 7일
    }

    response.addCookie(cookie); // 응답 헤더에 쿠키를 포함시킨다.

    ModelAndView mv = new ModelAndView("auth/loginResult");
    mv.addObject("member", member);
    return mv;
  }

  @GetMapping("logout")
  //  @RequestMapping(value="logout", method=RequestMethod.GET)
  public String logout(HttpSession session) throws Exception {
    session.invalidate(); // 현재 세션을 무효화시킨다.
    return "redirect:../../"; // 로그아웃 한 후 메인 페이지를 요청하라고 응답한다.
  }

}

