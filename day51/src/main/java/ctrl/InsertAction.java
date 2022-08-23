package ctrl;





import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		mVO.setMname(request.getParameter("mname"));
		
		ActionForward forward =new ActionForward();
		if(!mDAO.insert(mVO)) {
			forward.setPath(null);
		};
		
		
			
		
		
		
		
		
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}