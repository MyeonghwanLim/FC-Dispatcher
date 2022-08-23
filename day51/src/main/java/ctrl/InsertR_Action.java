package ctrl;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;



public class InsertR_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ReplyVO rVO=new ReplyVO();
		BoardDAO bDAO=new BoardDAO();
		
		rVO.setMid(request.getParameter("mid"));
		rVO.setBid(Integer.parseInt(request.getParameter("bid")));
		rVO.setRmsg(request.getParameter("rmsg"));
		bDAO.insertR(rVO);
		
			
		
		
		
		ActionForward forward =new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}