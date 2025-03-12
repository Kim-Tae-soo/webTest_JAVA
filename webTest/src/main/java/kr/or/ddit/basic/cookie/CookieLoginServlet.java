package kr.or.ddit.basic.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("cookieLogin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String rememberId = request.getParameter("remember-id");

        // 체크박스 처리
        if ("on".equals(rememberId)) {
            Cookie idCookie = new Cookie("userId", id);
            idCookie.setMaxAge(60 * 60 * 24 * 7); 
            response.addCookie(idCookie);
        } else {
            Cookie idCookie = new Cookie("userId", "");
            idCookie.setMaxAge(0);
            response.addCookie(idCookie);
        }

     
        if ("test".equals(id) && "1234".equals(password)) {
            
            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieMain.jsp?status=success");
        } else {
       
            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieLogin.jsp?status=failure");
        }


    }
}
