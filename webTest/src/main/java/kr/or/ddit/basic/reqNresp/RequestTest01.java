package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터를 문자 인코딩 방식 지정
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 보내온 데이터 받기
		
		// 1) Request객체.getParameter("파라미터명")
		//		==> 해당 '파라미터명'에 설정된 '값'을 가져온다.
		//		==> '파라미터명'은 보통 입력요소의 'name속성'의 값이 된다.
		//		==> 가져오는 '값'의 자료형은 'String'이다.
		String userName = request.getParameter("username");
		String job = request.getParameter("job");
		
		// 2) Request객체.getParameteValues("파라미터명")
		//		==> '파라미터명'이 같은 것이 여러개 일 경우에 사용한다.
		//		==> 가져오는 값의 자료형은 'String [](배열)'이다.
		
		String[] hobbies = request.getParameterValues("hobby");
		
		
		// -------------------------------------------------------------
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request연습</title></head>");
		out.println("<body>");		

		out.println("<h3>요청할 때 보내온 데이터 출력하기 </h3>");
		out.println("<table border='1'>");
		
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");
		
		out.println("<tr><td>직 업</td>");
		out.println("<td>" + job + "</td></tr>");
		
		out.println("<tr><td>취 미</td>");
		out.println("<td>");
		if(hobbies!=null) {
			//배열 크기만큼 반복 처리
			for(String hobby : hobbies) {
				out.println(hobby + "<br>");
			}
		}
		out.println("</td></tr>");
		
		out.println("</table>");
		
		out.println("<br><hr><br>");
		
		out.println("<h3>Request객체의 메서드들</h3>");
	    out.println("<ol>");
	    out.println("<li>클라이언트의 IP주소 : " + request.getRemoteAddr()+ "</li>");
	      
	    out.println("<li>요청메서드 : " + request.getMethod() + "</li>");
	    out.println("<li>Context Path : " + request.getContextPath() + "</li>");
	      
	    out.println("<li>프로토콜 : " + request.getProtocol() + "</li>");
	    out.println("<li>URL 정보 : " + request.getRequestURL() + "</li>");
	    out.println("<li>URI 정보 : " + request.getRequestURI() + "</li>");
	      
	    out.println("</ol>");
	      
	    out.println("<br><hr><br>");
	      /*
	          -Request객체.getParameterMap() 
	          ==> 클라이언트가 보내온 모든 파라미터를 Map객체에 담아서 반환한다.
	          ==> 이 Map객체의 'key값'은 '파라미터명'이 되고 자료형은 'String'이고
	             'value값'은 해당 파라미터에 지정된 '값'이며 자료형은 'String[]'이다.
	       */
	      
	    out.println("<h3>파라미터 정보 가져오기 - getParameterMap()메서드 </h3>");
	      
	    out.println("<ul>");
	      
	    Map<String, String[]> paramMap = request.getParameterMap();
	      
	    Iterator<String> paramIt = paramMap.keySet().iterator();
	      
	    while(paramIt.hasNext()) {
	     String paramName = paramIt.next(); // '파라미터명 구하기'
	  	 out.println("<li>" + paramName + " : ");
	    	  
	     String[] paramValues = paramMap.get(paramName); // 파라미터 값 구하기
	    	  
	     if(paramValues==null || paramValues.length==0) {	// 파라미터 값이 없는경우 
	    	 continue;
	      } else if (paramValues.length==1) {
	    		  out.println(paramValues[0]);
	    	  } else { // 파라미터 값이 2개 이상일 경우
	    		  for(int i= 0;  i<paramValues.length; i++) {
	    			  if(i>0) out.println("/ ");
	    			  out.println(paramValues[i]);
	    		  }
	    	  }
	     	out.println("</li>");
	      }
	      
	      out.println("</ul>");
	      

		 
		
	      out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
