package kr.or.ddit.basic.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/T_cookieLoginServlet.do")
public class T_cookieLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset='utf-8'>");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String chkId = request.getParameter("checkid");
        
        // Id값을 쿠키값으로 갖는 cookie 객체 생성
        Cookie loginCookie = new Cookie("username", username);
        //checkbox의 체크 여부 검사
        /*
        if(chkId==null) { // 체크 상태가 아닐때...
           // 쿠키 삭제한다.
           loginCookie.setMaxAge(0);
           response.addCookie(loginCookie);
        }else {// 체크 상태
           response.addCookie(loginCookie);
        }
       */
        if(chkId==null) { // 체크 상태가 아닐때...
           // 쿠키 삭제한다.
           loginCookie.setMaxAge(0);
        }response.addCookie(loginCookie);
        
        // 로그인 성공 여부 검사
        if(username != null && password != null) {
           if("test".equals(username) && "1234".equals(password)) { // 로그인 성공
              response.sendRedirect(request.getContextPath() + "/basic/cookie/T_cookieMain.jsp");
           }else {
              response.sendRedirect(request.getContextPath() + "/basic/cookie/T_cookieLogin.jsp");
           }
        }
        
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
