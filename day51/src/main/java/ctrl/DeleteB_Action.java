package ctrl;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;



public class DeleteB_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		BoardVO bVO=new BoardVO();
		BoardDAO bDAO=new BoardDAO();
		
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		
		bDAO.delete(bVO);
		
			
		
		
		
		ActionForward forward =new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}