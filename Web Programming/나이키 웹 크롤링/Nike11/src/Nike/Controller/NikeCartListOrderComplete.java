package Nike.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NikeOrderDB.NikeOrderDAO;

public class NikeCartListOrderComplete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		NikeOrderDAO dao = new NikeOrderDAO();
		
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		int itemnum = Integer.parseInt(request.getParameter("itemnum"));
		int price =  Integer.parseInt(request.getParameter("price"));
		String board = request.getParameter("board");
		int num =  Integer.parseInt(request.getParameter("num"));
		String category = request.getParameter("category");
		
		String nikename1 = request.getParameter("nikename1");
		String nikephone1 = request.getParameter("nikephone1");
		String nikeaddress1 = request.getParameter("nikeaddress1");
		String nikeaddress2 = request.getParameter("nikeaddress2");
		String nikemessage1 = request.getParameter("nikemessage1");
		
		dao.order(email, title, itemnum, price, board, num, category, nikename1, nikephone1, nikeaddress1, nikeaddress2, nikemessage1);
		
		forward.setRedirect(false);
   		forward.setPath("./NikeMain/Nike_Cart_Order_2.jsp");
   		return forward;
	}
	
	
}
