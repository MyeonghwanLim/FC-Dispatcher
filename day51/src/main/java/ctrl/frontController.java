package ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class frontController
 */
@WebServlet("*.do") // *.do 요청을 수행하면 해당 어노테이션에 의해 FC로 오게됨!!!
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public frontController() { 
    	// ★ FrontCotroller fc = new FrontController(); 사용안했음
        // 객체화를 하지않았는데, 메서드를 사용할 수 있었다...??!
    	// 서블릿 컨테이너(==객체를 관리하는 것) == 웹 서버 == 톰캣이 서블릿을 객체화해주고 있었음
    	// 그래서 서블릿컨테이너 객체화를 통해 기본생성자가 필요하다
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String command=uri.substring(cp.length());
		System.out.println(command);
		
		ActionForward forward =null;
		if(command.equals("/main.do")) {
			try {
				forward= new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.do")) {
			try {
				forward=new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else if(command.equals("/login.do")) {
			try {
				forward=new LoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/insert.do")) {
			try {
				forward=new InsertAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/insert_b.do")) {
			try {
				forward=new InsertB_Action().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/insert_r.do")) {
			try {
				forward=new InsertR_Action().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/delete_b.do")) {
			try {
				forward=new DeleteB_Action().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/delete_r.do")) {
			try {
				forward=new DeleteR_Action().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/fav.do")) {
			try {
				forward=new FavoriteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
//		if(forward==null) {
//			forward=new ActionForward();
//			forward.setPath("error/error.jsp");
//			forward.setRedirect(false);
//		}
//		
//		RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
//		try {
//			dispatcher.forward(request,response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<script>alert('요청차리실패!');history.go(-1);</sctipt>");
		
		
		
		
		
		
		
	}
}
