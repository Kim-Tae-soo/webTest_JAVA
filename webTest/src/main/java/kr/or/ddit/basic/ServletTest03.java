package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
    Servlet의 동작 방식에 대하여...
    
      1. 사용자(클라이언트)가 URL등을 클릭하여 HTTP 요청(request)을 Servlet Container로 전송(요청)
      
      2. 컨테이너는 web.xml에 정의된 'urlPattern'을 확인하여 어느 Servlet을 통해서 처리할 지를
         검색함.
         (이 때 로딩이 안되어 있으면 로딩함. 처음 로딩 시 init() 메소드가 호출됨)
         (이 작업은 Servlet 3.0 이상에서는 어노테이션(@WebServlet)으로 설정가능함)
      
      3. Servlet Container는 개별 요청을 처리할 쓰레드를 생성하여 해당 Servlet의 service()
         메소드를 호출함.
         (이 때 HttpServletRequest 객체 및 HttpServletResponse 객체를 생성하여 매개변수로 넘겨줌)
      
      4. service() 메소드는 전송방식(GET, POST 등)을 체크하여 적절한 메소드를 호출함.
         (예: doGet(), doPost(), doPut(), doDelete() 등)
      
      5. 요청 및 응답의 처리가 모두 완료되면 3번에서 생성된 HttpServletRequest 객체와
         HttpServletResponse 객체는 자동으로 소멸됨.
         
      6. 컨테이너로부터 Servlet이 제거되는 경우에는 destroy() 메소드가 호출됨.
*/
@WebServlet("/ServletTest03.do")
public class ServletTest03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    System.out.println(this.getServletName() + "에서 init() 메소드 호출...");
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("doGet() 메소드 시작...");

    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html; charset=utf-8");
    PrintWriter out = response.getWriter();

    out.println("<html><head><meta charset='utf-8'></head>"
        + "<body><h2 style='color : red;'>doGet() 메소드를 처리한 결과</h2></body></html>");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("service()메소드 시작...");

    // GET 방식과 POST 방식을 구별해서 맞는 메소드 호출하기

    // 방법1) 부모 클래스 HttpServlet의 service() 메소드로 위임하기
    //super.service(request, response);
    // 방법2) ==> 클라이언트 전송 방식을 직접 구분해서 맞는 메서드 호출하기
    String method = request.getMethod();
    System.out.println("method : " + method);
    
    if("GET".equals(method)) {
    	this.doGet(request, response);
    } else if("POST".equals(method)) {
    	this.doPost(request, response);
    } else {
    	System.out.println("전송 방식의 오류가 발생함...");
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("doPost() 메소드 시작...");

    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html; charset=utf-8");
    PrintWriter out = response.getWriter();

    out.println("<html><head><meta charset='utf-8'></head>"
        + "<body><h2 style='color : blue;'>doPost() 메소드를 처리한 결과</h2></body></html>");
  }

  @Override
  public void destroy() {
    System.out.println("destroy() 메소드 호출...");
  }

}
