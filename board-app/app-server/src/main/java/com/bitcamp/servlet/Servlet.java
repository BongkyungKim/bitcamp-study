package com.bitcamp.servlet;

import java.io.PrintWriter;
import java.util.Map;

public interface Servlet {
  void service(Map<String,String> paramMap, PrintWriter out) throws Exception;
}
