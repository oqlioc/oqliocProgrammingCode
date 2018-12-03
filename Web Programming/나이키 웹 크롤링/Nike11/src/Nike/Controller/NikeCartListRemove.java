package Nike.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NikeAddToCartDB.NikeAddToCartDAO;


public class NikeCartListRemove implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		NikeAddToCartDAO dao = new NikeAddToCartDAO();
		
		String cartnum = request.getParameter("cartnum");
		
		dao.cartlistremove(cartnum);

		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./Nike_Cart_List.nf");
		return forward;
	}

}
