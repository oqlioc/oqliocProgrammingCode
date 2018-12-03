package Nike.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import NikeAddToCartDB.NikeAddToCartDAO;
import NikeAddToCartDB.NikeAddToCartDTO;

public class NikeCartListOrderForm2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String email = request.getParameter("email");
		
		NikeAddToCartDAO dao = new NikeAddToCartDAO();
		ArrayList<NikeAddToCartDTO> dtos = dao.cartlist(email);
		request.setAttribute("cartlist", dtos);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./NikeMain/Nike_Cart_Order.jsp");
		return forward;
	}
}
