package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardSet;
import board.BoardVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		 request.setCharacterEncoding("UTF-8");
//		 response.setCharacterEncoding("UTF-8");
		
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
		String paramCnt=request.getParameter("cnt");
		if(paramCnt==null || paramCnt.equals("")){
			vo.setCnt(2);
		}
		else {
			vo.setCnt(Integer.parseInt(paramCnt));
		}
		HttpSession session=request.getSession();
		ArrayList<BoardSet> datas=dao.selectAll(vo);
		request.setAttribute("datas", datas);
		session.setAttribute("cnt", vo.getCnt());
		System.out.println("cnt로그"+vo.getCnt());
		
		ActionForward forward=new ActionForward();
		forward.setPath("/main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
