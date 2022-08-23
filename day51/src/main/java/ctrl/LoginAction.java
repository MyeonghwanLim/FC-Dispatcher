package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
	
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null) {
	
		HttpSession session=request.getSession();
		session.setAttribute("mid", mVO.getMid());
		}
		
			
		
		ActionForward forward =new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}