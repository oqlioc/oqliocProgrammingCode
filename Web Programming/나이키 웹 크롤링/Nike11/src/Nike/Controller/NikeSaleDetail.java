package Nike.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NikeAdminDB.NikeAdminDAO;
import NikeAdminDB.NikeAdminDTO;

public class NikeSaleDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String itemnum = request.getParameter("itemnum");
		NikeAdminDAO dao = new NikeAdminDAO();
		NikeAdminDTO dto = dao.detail(itemnum);
		
		request.setAttribute("detail_list", dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./NikeMen/Nike_Men_Shoes_sale.jsp");
		return forward;
	}

}
