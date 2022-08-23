package ctrl;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;



public class DeleteR_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ReplyVO rVO=new ReplyVO();
		BoardDAO bDAO=new BoardDAO();
		
		rVO.setRid(Integer.parseInt(request.getParameter("rid")));
		
		bDAO.deleteR(rVO);
		
			
		
		
		
		ActionForward forward =new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}