package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

@WebServlet("/member/list")
public class MemberListController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  @Override
  public void init() {
    memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      List<Member> members = memberDao.findAll();

      request.setAttribute("members", members);
      response.setContentType("text/html; charset=UTF-8");
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/member/list.jsp");
      요청배달자.include(request, response);

    } catch (Exception e) {
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error.jsp");
      request.setAttribute("exception", e);

      요청배달자.forward(request, response);
    }
  }
}
